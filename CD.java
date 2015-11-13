/**
 *This is class CD. And it has related information about CDs. 
 */
import java.util.List;

/**
 * 
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class CD extends Media{
    public String performer;
   // public String title;
    //public int available;
    //public int price;
    //public int rating;
    public String fileType;
    //public int sold;
    
    /**
     * This Method is being called to get Performer. 
     * @return Performer
     */
        
    public String getPerformer() {
        return performer;
    }
    
    /**
     * This Method being called to set Performer.
     * @param performer
     */
    
    public void setPerformer(String performer) {
        this.performer = performer;
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
     * This method is to display the all the CDs which are available in the CDList.
     * @param cdlist contains all the CDs.
     * @return the concatenated list of CDs in the shop and its being displayed over there.
     */
    
        public String toString(List<CD> cdlist){
            
            String list = "";
            int counter = 1;
            
            
             // Counter for representational purpose i.e, 1,2,3...
             
            
            for(CD cds: cdlist){
                
                
                 // for loop is used to iterate through all the CDs in cdList.
                 
                
                if(cds.getAvailable() >= 1){
                    
                    
                    // if statement to check Availability, if not available then don't display the particular CDs. 
                     
                    
                list += counter+" . "+cds.getTitle()+" performed by "+cds.getPerformer()+" in, $"+cds.getPrice() +"\n"; 
                
                }     
                counter++;
            }
            
            return list;        
    }
        
        /**
         * Method sellCopies to calculated the total price.
         * @param price of the selected CDs.
         * @param quantity of the selected CD required.
         * @return total price.
         */
        
        public int sellCopies(int price, int quantity){
            int total = 0;
            total = price * quantity;
             return total;
            
        }

        /**
         * This Method is being used to update rating and Rating object is being created and rating is being transfered to updateRating method in Class Rating.
         * @param cdRating
         * @param select
         */
        
        public void updateRating(int cdRating, int select){
             
            select = select -1;
           
            Shop.listCD.get(select).setRating(cdRating);
            
            Rating rateBook = new Rating();
            rateBook.updateRating(cdRating);
            
        }
}
