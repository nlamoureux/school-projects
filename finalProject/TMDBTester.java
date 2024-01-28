package cs249.finalProject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;

public class TMDBTester extends Application {

	static TMDBMainHandler tmdbHandler;
	static MovieDBHandler Movie08;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 tmdbHandler = new TMDBMainHandler();

		 try {
			 FileInputStream filein = new FileInputStream("file.dat");
			 ObjectInputStream objectInputStream = new ObjectInputStream(filein);
			 Object holder = objectInputStream.readObject();
			 if(holder.getClass() == MovieDBHandler.class) {
			 	Movie08 = (MovieDBHandler) holder;
			 }
			 else{
			 	Movie08 = new MovieDBHandler();
			 }
			 objectInputStream.close();
			 filein.close();
		 } catch (IOException| ClassNotFoundException e) {
			 System.out.println("File not found. Creating the object.");
			 Movie08 = new MovieDBHandler();
		 }

		//System.out.println(tmdbHandler.getApiKey());
		launch(args);

	}
	@Override
	   public void start(Stage primaryStage) {
			BorderPane pane = new BorderPane();

			GridPane resultGP = new GridPane();

			resultGP.setGridLinesVisible(true);
			resultGP.setVgap(10);
		ScrollPane sp = new ScrollPane(resultGP);

		Label searchLabel = new Label("Movie Title to search for: ");
		TextField searchBar = new TextField();
		Button searchBttn = new Button("Search");
		Button viewList = new Button("View List");
		ViewMovieListActionHandler handle = new ViewMovieListActionHandler();
		viewList.setOnAction(handle);

		HBox input = new HBox(5);
		input.getChildren().addAll(searchLabel,searchBar,searchBttn, viewList);
		pane.setTop(input);

		pane.setCenter(sp);

		searchBttn.setOnAction(event -> {
			resultGP.getChildren().clear();
			String results = null;
			try {
				results = tmdbHandler.searchMovies(searchBar.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(results);
			JsonParser jsonParser = new JsonParser();

			JsonObject jsonObject = (JsonObject) jsonParser.parse(results);

			JsonArray jResults = jsonObject.getAsJsonArray("results");

			int row = 0;
			for(JsonElement o:jResults) {
				BorderPane movie = new BorderPane();
				GridPane info = new GridPane();
				info.setHgap(10);
				info.setVgap(10);

				ImageView poster;
				if(o.getAsJsonObject().get("poster.path").isJsonNull()) {
					poster = new ImageView("download.jpg");
					poster.setFitWidth(342.0);
				}
				else {
					poster = new ImageView(tmdbHandler.returnPosterImageUrl(o.getAsJsonObject().get("poster.path").toString().replace("\"", "")));
					poster.setFitWidth(342.0);
				}
				info.add(new Text("Title:"), 1, 0);
				info.add(new Text(o.getAsJsonObject().get("title").toString().replace("\"", "")), 2, 1);
				info.add(new Text("Description"), 1, 2);
				TextArea description = new TextArea(o.getAsJsonObject().get("overview").toString().replace("\"", ""));
				description.setWrapText(true);
				description.setMaxWidth(500);
				description.setEditable(false);
				info.add(description, 2, 3);

				Text alertInfo = new Text();
				info.add(alertInfo,3,5);
				Button addToList = new Button("Add");

				addToList.setId(o.getAsJsonObject().get("id").toString().replace("\"", ""));
				addToList.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> {
					int id = Integer.parseInt(((Control)event1.getSource()).getId());

					System.out.println((((Control)event1.getSource()).getId()));
					String movieInfo = tmdbHandler.getMovie(id);
					JsonObject movieInfoJson = (JsonObject) jsonParser.parse(movieInfo);
					alertInfo.setText("adding");

					Movie08.addMovie(movieInfoJson);
					alertInfo.setText("added");
					Thread ts = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(6000);
								Platform.runLater(() -> {
									alertInfo.setText("");
								});
								System.out.println("hiding");
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
					});
					ts.start();
				});




				movie.setLeft(poster);
				movie.setCenter(info);
				movie.setRight(addToList);
				resultGP.add(movie, 0,row);
				row ++;

			}

		});

	        Scene scene = new Scene(pane, 500, 400);
	   
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	@Override
	public void stop() throws Exception {
		super.stop();

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("file.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(Movie08);
			objectOut.close();
			fileOut.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ViewMovieListActionHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			System.out.println(Movie08.getMovie(1));
			Movie08.listMovies();

			Stage secondStage = new Stage();
			secondStage.show();

		}
	}
}
