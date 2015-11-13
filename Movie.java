/**
 *This is class Movie. And it has related information about movie. 
 */
import java.util.List;

/**
 * 
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class Movie extends Media{
	
	public String director;
	public String producer;
	//public String title;
	//public int available;
	//public int price;
	//public int rating;
	public String fileType;
	//public int sold;
		
	/**
	 * This Method is being called to get Director. 
	 * @return Director.
	 */
	
	public String getDirector() {
		return director;
	}
	
	/**
	 * This Method being called to set Director.
	 * @param director
	 */
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * This Method is being called to get Producer. 
	 * @return Producer.
	 */
	
	public String getProducer() {
		return producer;
	}
	
	/**
	 * This Method being called to set Producer.
	 * @param producer
	 */
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	/**
	 * This Method is being called to get FileType. 
	 * @return FileType
	 */
	
	public String getFileType() {
		return fileType;
	}
	
	/**
	 * This Method being called to set FileType.
	 * @param fileType
	 */
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	
	/**
	 * This method is to display the all the movies which are available in the MovieList.
	 * @param movielist contains all the movies.
	 * @return the concatenated list of movies in the shop and its being displayed over there.
	 */
	
	public String toString(List<Movie> movielist){
		
		String list = "";
		int counter = 1;
		
		/**
		 * Counter for representational purpose i.e, 1,2,3...
		 */
		
		for(Movie movies: movielist){
			
			/**
			 * for loop is used to iterate through all the movies in movieList.
			 */
			
			if(movies.getAvailable() >= 1){
				/**
				 * if statement to check Availability, if not available then don't display the particular movie. 
				 */
			list += counter+" . "+movies.getTitle()+" directed by " +movies.getDirector()+" and produced by "+movies.getProducer() +" in, $ "+movies.getPrice() +"\n"; 	
			
			}
			counter++;
		}		
		return list;
	}
	
	/**
	 * Method sellCopies to calculated the total price.
	 * @param price of the selected movie.
	 * @param quantity of the selected movie required.
	 * @return total price.
	 */
	
public int sellCopies(int price, int quantity){
		int total = 0;
		total = price * quantity;
		 return total;
		
	}

/**
 * This Method is being used to update rating and Rating object is being created and rating is being transfered to updateRating method in Class Rating.
 * @param movieRating
 * @param select
 */

public void updateRating(int movieRating, int select){
	
    select = select-1;
	Shop.listMovie.get(select).setRating(movieRating);
	
	Rating rateBook = new Rating();
	rateBook.updateRating(movieRating);
	
}
}
