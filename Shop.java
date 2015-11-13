/**
 * This is an Shop class which includes various methods.
 * We have imported List and Scanner.
 */
import java.util.List;

/**
 * 
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class Shop {
    
    /**
     * Variables declared as static, so that any changes made in the data can be stored.
     */
    
    static  List<Book> listBook = Warehouse.getBooks();
    static  List<CD> listCD = Warehouse.getCDs();
    static  List<Movie> listMovie = Warehouse.getMovies();
    
    /**
     * objects for Book, CD and Movie is being created.
     */
    
    Book book = new Book();
    CD cd = new CD();   
    Movie movie=new Movie();
    
    /**
     * Method Name displaySalesItems starts here which displays the items to sell.
     */
    
    public String displaySalesItems(String letter){
        
        if(letter .equals ("b")){   
            
        return  book.toString(listBook);                
        }       
        else if(letter .equals ("c")){
            
            return cd.toString(listCD);
        }           
        else{
            return movie.toString(listMovie);
        }               
    }
    
    /**
     * Method is being called to get the total price of the media sold.And to update the availability.
     * @param letter is the choice of media.
     * @param select is the choice among media.
     * @param quantity is the no of quantity ordered.
     * @return total price.
     */
        public int mediaSell(String letter, int select, int quantity){
            
            
             // select is being changed because ArrayList starts from 0 and we need to compare to it.
                      
            select = select-1;
            int price = 0;
            int total = 0;
            
             //Now using if statements price of the selected media is being get, returned and displayed. 
             
            if(letter .equals("b")){    
                
                 // Now we want to get the price of selected media so kits being get using this statement.
                 
            	
            	if((listBook.get(select).getAvailable() - quantity) < 0){
            		
            		System.out.println("Quantity of book selected not available.Try again.");
            	}
            	else{
                price =listBook.get(select).getPrice();
                
                 // Its being called to the method sellCopies in the book and its total price is being fetched.
                 
                    total = book.sellCopies(price, quantity);
                    
                   /** 
                     * Once customer buys the book we need to change the availability of the book.
                     * To do so first we get the Availability and then subtract it from the quantity 
                     * bought and then set the Availability.
                     */
                    
                    int booksLeft = listBook.get(select).getAvailable();
                    
                    listBook.get(select).setAvailable((booksLeft - quantity));
                    
            	}
            }   
            
             // Similar to the actions in books is being performed here.
             
            if(letter .equals("c")){
                
            		if((listCD.get(select).getAvailable() - quantity) < 0){
            		
            		System.out.println("Quantity of book selected not available.Try again.");
            	}
            	else{
            	
                price = listCD.get(select).getPrice();
                total = cd.sellCopies(price, quantity); 
                
                int cdsLeft = listCD.get(select).getAvailable();
                
                listCD.get(select).setAvailable(cdsLeft - quantity);
                
            	}
            }
            
             // Similar to the actions in books is being performed here.
             
            
            if(letter.equals("m")){
                
            		if((listMovie.get(select).getAvailable() - quantity) < 0){
            		
            		System.out.println("Quantity of book selected not available.Try again.");
            	}
            	else{
            	
                price = listMovie.get(select).getPrice();
                total = movie.sellCopies(price, quantity);
                
                int moviesLeft = listMovie.get(select).getAvailable();
                
                listMovie.get(select).setAvailable(moviesLeft - quantity);
                
            } 
            }
            return total;
            
        }     
        
        /**
         * This Method gives the Total Book Sold.
         * @return BooksSold
         */
        
        public int getBooksSold(){
          
            int booksSold = 0;
            
            for (Book book: listBook){
              
                booksSold = booksSold + book.getSold();
              }
          return booksSold;
          }
          
        /**
         * This Method gives the Total CD Sold.
         * @return CDssold
         */
        
          public int getcdsSold(){
          
            int cdsSold = 0;
            
            for (CD cd: listCD){
              
                cdsSold = cdsSold + cd.getSold();
              }
          return cdsSold;
          }
          /**
           * This Method gives the Total Movies Sold.
           * @return MoviesSold
           */
          public int getmoviesSold(){
          
            int moviesSold = 0;
            
            for (Movie movie: listMovie){
              
                moviesSold = moviesSold + movie.getSold();
              }
          return moviesSold;
          }
          
          /**
           * To calculate the Total Revenue by selling Books, CDs and Movies. 
           * @return totalRevenue
           */
          
          public long calculateRevenue(){
              
              int totalBook = 0;
              int totalCD = 0;
              int totalMovie = 0;
              int total = 0;
              
              
              for (Book book: listBook){
                
                 totalBook = totalBook + (book.getSold() * book.getPrice());
                  
                }
                
                for (Movie movie: listMovie){
                
                 totalMovie = totalMovie + (movie.getSold() * movie.getPrice());
                  
                }
                
                for (CD cd: listCD){
                
                 totalCD = totalCD + (cd.getSold() * cd.getPrice());
                  
                }
            
              total = totalBook + totalCD + totalMovie;
              return total;
            }
	}	