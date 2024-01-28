package cs249.finalProject;

import java.io.IOException;
import java.net.URLEncoder;

public class TMDBMainHandler {
	TMDBConfiguration tmdb;
	HttpConnectionHandler handler;
	public TMDBMainHandler() {
		tmdb = new TMDBConfiguration();
		System.out.println(tmdb.getBase_URL());
		handler = new HttpConnectionHandler();
	
		// TODO Auto-generated constructor stub
	}
	public String returnBackDropImageUrl(String image) {
		return tmdb.getImage_Base_URL()+tmdb.getBackdrop()+image;
	}
	public String returnLogoImageUrl(String image) {
		return tmdb.getImage_Base_URL()+tmdb.getLogo()+image;
	}
	public String returnPosterImageUrl(String image) {
		return tmdb.getImage_Base_URL()+tmdb.getPoster()+image;
	}
	public String returnProfileImageUrl(String image) {
		return tmdb.getImage_Base_URL()+tmdb.getProfile()+image;

	}public String returnStillImageUrl(String image) {
		return tmdb.getImage_Base_URL()+tmdb.getStill()+image;
	}

	
	
	
	//Movie methods
	
	public String searchMovies(String title, int year,String page) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchMovies(String title, String page) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchMovies(String title, int year) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchMovies(String title ) throws IOException {
		String response = handler.getInformation("https://api.themoviedb.org/3/search/movie?api_key=9a9ec11c7c955325431bc2fa0f5955e2&language=en-US&query=" + URLEncoder.encode(title) + "&page=1&include_adult=false");

		return response;
		
	}
	public String getMovie(int id) {
		String searchURL = tmdb.getBase_URL()+"movie/"+id+"?api_key="+tmdb.getApiKey()+"&language="+tmdb.getLanguage();
		String response = null;
		try {
			response = handler.getInformation(searchURL);
		} catch (IOException e) {
			e.printStackTrace();
		}


		return response;
		
	}
	
	//TVMethods
	
	public String searchTVShows(String title, int year,String page) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchTVShows(String title, String page) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchTVShows(String title, int year) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	public String searchTVShows(String title ) {
		StringBuilder Result = new StringBuilder();
		
		
		
		return Result.toString();
		
	}
	public String getTV(int id) {
		String Result = "null";
		
		
		
		return Result;
		
	}
	

	
	
	

}
