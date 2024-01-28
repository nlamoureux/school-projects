package cs249.finalProject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;
//Nathan Lamoureux

public class Commandlineinterface {
    static TMDBMainHandler tmdbMainHandler;

    public static void main(String[] args) throws IOException {
        tmdbMainHandler = new TMDBMainHandler();
        JsonParser jsonParser = new JsonParser();
        HttpConnectionHandler handler = new HttpConnectionHandler();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a movie:");
        String search = keyboard.nextLine();


        String response = handler.getInformation("https://api.themoviedb.org/3/search/movie?api_key=9a9ec11c7c955325431bc2fa0f5955e2&language=en-US&query=" + URLEncoder.encode(search) + "&page=1&include_adult=false");

        System.out.println(response);

        JsonElement jsonElement = jsonParser.parse(response);

        JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("results");
        for (JsonElement o:jsonArray) {
          //  System.out.println(o.getAsJsonObject().get("title").toString().replace("\"", "").replace("\\", ""));
          //  System.out.println(o.getAsJsonObject().get("overview").toString().replace("\"", ""));
            String dMovie = handler.getInformation("https://api.themoviedb.org/3/movie."+o.getAsJsonObject().get("id").toString().replace("\"", "")+"?api_key=cb7ca60452b19601157cc2066a7fe63&language=en_US");

            System.out.println(jsonElement);
        }
    }

}
