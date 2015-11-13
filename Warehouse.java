
/**
 * This is the class called Warehouse is like the Database of the shop.
 * And to do so we have imported an ArrayList.
 */
import java.util.ArrayList;
/**
 * 
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class Warehouse {
	
	/**
	 * Here we store all the information of the books.One by one and we store it in the ArrayList.
	 * @return list of Books.
	 */
	
	static ArrayList<Book> getBooks(){
		
		
		ArrayList<Book> listBooks= new ArrayList<Book>(); 
		
		
		Book book1 = new Book();
	
		book1.setAuthor("Margaret Mitchell");
		book1.setTitle("Gone With The Wind");
		book1.setAvailable(10);
		book1.setPrice(500);
		book1.setSold(10);
	
		listBooks.add(book1);
		
		
		Book book2 = new Book();
		
		book2.setAuthor("Jane Austen");
		book2.setTitle("Pride and Prejudice");
		book2.setAvailable(10);
		book2.setPrice(40);
		book2.setSold(13);
				
		listBooks.add(book2);
		
		
		Book book3 = new Book();
		
		book3.setAuthor("Willian Shakespeare");
		book3.setTitle("Romeo and Juliet");
		book3.setAvailable(10);
		book3.setPrice(30);
		book3.setSold(21);
				
		listBooks.add(book3);
		
		
		Book book4 = new Book();
		
		book4.setAuthor("J.R.R.Tolkien");
		book4.setTitle("The Hobbit");
		book4.setAvailable(10);
		book4.setPrice(60);
		book4.setSold(19);
				
		listBooks.add(book4);
		
		
		Book book5 = new Book();
		
		book5.setAuthor("Victor Hugo");
		book5.setTitle("Les Miserables");
		book5.setAvailable(12);
		book5.setPrice(56);
		book5.setSold(15);
				
		listBooks.add(book5);
		
		return listBooks;
	}
	
	/**
	 * Here we store all the information of the cds.One by one and we store it in the ArrayList.
	 * @return list of CDs.
	 */
	static ArrayList<CD> getCDs(){
		
		ArrayList<CD> listCDs = new ArrayList<CD>();
		
		CD cd1 = new CD();
		
		cd1.setPerformer("ColdPlay");
		cd1.setTitle("Viva la Vida");
		cd1.setPrice(15);
		cd1.setFileType("MP4");
		cd1.setAvailable(15);
		cd1.setSold(54);
		
		listCDs.add(cd1);
		
		
		CD cd2 = new CD();
		
		cd2.setPerformer("Enrique Iglesias");
		cd2.setTitle("Euphoria");
		cd2.setPrice(8);
		cd2.setFileType("MP4");
		cd2.setAvailable(15);
		cd2.setSold(30);
		
		listCDs.add(cd2);
		
		
		CD cd3 = new CD();
		
		cd3.setPerformer("Red Hot Chill Peppers");
		cd3.setTitle("Stadium Arcadium");
		cd3.setPrice(14);
		cd3.setFileType("MP4");
		cd3.setAvailable(11);
		cd3.setSold(32);
		
		listCDs.add(cd3);
		
		
		CD cd4 = new CD();
		
		cd4.setPerformer("Adele");
		cd4.setTitle("21");
		cd4.setPrice(12);
		cd4.setFileType("MP4");
		cd4.setAvailable(12);
		cd4.setSold(12);
		
		listCDs.add(cd4);
		
		
		CD cd5 = new CD();
		
		cd5.setPerformer("One Direction");
		cd5.setTitle("Midnight Memories");
		cd5.setPrice(14);
		cd5.setFileType("MP4");
		cd5.setAvailable(21);
		cd5.setSold(32);
		
		listCDs.add(cd5);
				
		return listCDs;		
	}
	
	/**
	 * Here we store all the information of the movies.One by one and we store it in the ArrayList.
	 * @return
	 */
	static ArrayList<Movie> getMovies(){
			
		ArrayList<Movie> listMovies = new ArrayList<Movie>();
		
		Movie movie1 = new Movie();
		
		movie1.setDirector("Francis Ford Coppola");
		movie1.setProducer("Albert S. Ruddy");
		movie1.setTitle("The Godfather");
		movie1.setPrice(5);
		movie1.setFileType("BlueRay");
		movie1.setAvailable(10);
		movie1.setSold(12);
		
		listMovies.add(movie1);
		
		
		Movie movie2 = new Movie();
		
		movie2.setDirector("Frank Darabont");
		movie2.setProducer("Niki Marvin");
		movie2.setTitle("The Shawshank Redemption ");
		movie2.setPrice(56);
		movie2.setFileType("BlueRay");
		movie2.setAvailable(16);
		movie2.setSold(14);
		
		listMovies.add(movie2);
		
		
		Movie movie3 = new Movie();
		
		movie3.setDirector("Richard Attenborough");
		movie3.setProducer("Richard Attenborough");
		movie3.setTitle("Gandhi");
		movie3.setPrice(65);
		movie3.setFileType("BlueRay");
		movie3.setAvailable(65);
		movie3.setSold(19);
		
		listMovies.add(movie3);
		
		
		Movie movie4 = new Movie();
		
		movie4.setDirector("Rajkumar Hirani");
		movie4.setProducer("Vidhu Vinod Chopra");
		movie4.setTitle("3 Idiots");
		movie4.setPrice(46);
		movie4.setFileType("BlueRay");
		movie4.setAvailable(101);
		movie4.setSold(32);
		listMovies.add(movie4);
		
				
		Movie movie5 = new Movie();
		
		movie5.setDirector("Rajkumar Santoshi");
		movie5.setProducer("Vinay Kumar Sinha");
		movie5.setTitle("Andaz Apna Apna");
		movie5.setPrice(70);
		movie5.setFileType("BlueRay");
		movie5.setAvailable(40);
		movie5.setSold(50);
		
		listMovies.add(movie5);
		
		return listMovies;	
	}	
}
