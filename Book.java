/**
 *This is class Book. And it has related information about books. 
 */
import java.util.List;

/**
 * 
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class Book extends Media{
    
    public String author;
    //public String title;
    //public int available;
    //public int price;
    //public int rating;
    //public int sold;
   
    

    /**
     * This Method is being called to get Author. 
     * @return Author
     */
    
    public String getAuthor() {
        return author;
    }
    
    /**
     * This Method being called to set Author.
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    
    
    /**
     * This method is to display the all the books which are available in the bookList. And those Books who are not available are being not displayed to the customer.
     * @param booklist contains all the books.
     * @return the concatenated list of books in the shop and its being displayed over there.
     */
    
    public String toString(List<Book> booklist){
            
        String list = "";       
        int counter = 1;
                    
         // Counter for representational purpose i.e, 1,2,3...
                
        for(Book books: booklist){
                        
             // for loop is used to iterate through all the books in bookList.           
            
            if(books.getAvailable() >= 1){
                                
                //  if statement to check Availability, if not available then don't display the particular book.        
                
            list += counter+" . "+books.getTitle()+" by " +books.getAuthor()+" in ,$ "+books.getPrice() +"\n"; 
            
            
            }       
            counter++;
        }           
        return list;
}
    
    /**
     * Method sellCopies to calculated the total price.
     * @param price of the selected books.
     * @param quantity of the selected book required.
     * @return total price.
     */
    
    public int sellCopies(int price, int quantity){
        int total = 0;
        total = price * quantity;
        return total;       
    }

    /**
     * This Method is being used to update rating and Rating object is being created and rating is being transfered to updateRating method in Class Rating.
     * @param bookRating
     * @param select
     */
    
    public void updateRating(int bookRating, int select){
        select= select-1;        
        Shop.listBook.get(select).setRating(bookRating);    
        
        Rating rateBook = new Rating();
        rateBook.updateRating(bookRating);
        
    }   
    }
