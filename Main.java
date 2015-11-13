
import java.util.Scanner;

/**
 * This is the Main method of the project.
 * @author Ronak Shah(4949773)
 * @version 19 / 09 / 2014
 * 
 */

public class Main {
	
	/**
	 * Main Method, Program Starts from here.
	 * @param args
	 */
	
	public static void main(String args[]){
		// Two conditions were given in the question for "sell" and "show", so to implement that we using if loop.
		//If user selects sell then, this if loop will be executed.
		if(args[0].equals("sell"))
		{	
			Book book = new Book();
			CD cd = new CD();	
			Movie movie=new Movie();
			String continueShopping = "yes";
			Scanner choice = new Scanner(System.in); //User Input 
		
	do{Shop shopObject = new Shop();
	
	System.out.println("==================================");
	System.out.println("Welcome to the Media Shop");
	System.out.println("==================================");
	System.out.println();
	System.out.println("Choose from the following");
	System.out.println("1. Books  <enter 'b'>");
	System.out.println("2. CDs <enter 'c'>");
	System.out.println("3. Movies <enter 'm'>");
		
	// choice taken as a User input to select from the options of Book,CD,Movies.
	 	
	int check = 0;
	System.out.print("Enter your Choice: ");	 
	String letter = choice.next();
			
	 // This loop performs the validation for the user input, if user doesn't enter the right choice then user will be interrupted and asked again and again until user makes right choice.
	 	
	do{
		if(letter .equals("b"))
			
			check = 1;
		
		else if(letter .equals("c"))
		
			check = 1;
		
		else if(letter .equals("m"))
			
			check = 1;
		else{
			System.out.println("Invalid Entry.TryAgain");
			System.out.print("Enter your Choice: ");	 
			letter = choice.next();
		}
					
	} while (check <= 0) ;
		
	 // After the valid selection User will be given options to choose among the available media.
	 	
	System.out.println("Type the number to choose a book");
	System.out.println("=========================================");
	
	System.out.println(shopObject.displaySalesItems(letter));
		
	 // Now user needs to select valid media which he/she wants to buy.
	
	 int select = -1;
	 // Validation
	do{System.out.print("Choose valid Integer: ");
	
	   while (!choice.hasNextInt()) 
	    {  // check if the valid input is passed
	        System.out.println("Enter Integer");
	        System.out.print("Choose: ");
	        choice.next();   
	    }
	
	select = choice.nextInt();
	}while(select <= 0 || select >= 6);
	
	
	 // After making of mind what he/she wants to buy user is being asked to enter quantity of that media he/she wants to buy.
	 
	
	int quantity = -1;
	
	do{System.out.print("Enter number of quantity: ");
		
	   while (!choice.hasNextInt()) 
	    {  // check if the valid input is passed
	        System.out.println("Enter Integer");
	        System.out.print("Enter number of quantity: ");
	        choice.next();   
	    }	
	   
	   quantity = choice.nextInt();
	}while(quantity <= 0);
		
	 // After user enters quantity validation is being performed whether that number of quantity is in stock or not.	
	 // If its in stock then method is being called to sell particular media.
		 				
		int total = shopObject.mediaSell(letter, select, quantity);
		
		if(!(total == 0)){
		
		System.out.println("Amount you have to pay: " +total);
		
		 // Then User is being asked to rate the media in scale of 1 to 10 and its rating is being stored.
		 
		
		
		int rating = -1;
		
		do{System.out.print("Please rate the media on the scale of 1 to 10. 10 is excellent, 1 is absolutely uninteresting: ");
		// Validation of Rating
		   while (!choice.hasNextInt()) 
		    {  // check if the valid input is passed
		        System.out.println("Enter Integer");
		        choice.next();
		        System.out.print("Please rate the media on the scale of 1 to 10. 10 is excellent, 1 is absolutely uninteresting: ");
		    }
		
		rating = choice.nextInt();
		}while(rating <= 0 || rating >= 10);
		
		 
		
		System.out.println("Your rating: "+rating);	
		
		// Now we need to update rating.
		
		if(letter .equals("b")){			
			book.updateRating(rating, select);			
		}else if(letter .equals("c")){
			cd.updateRating(rating, select);			
		}else{
			movie.updateRating(rating, select);
		}
		
		Rating avgRating = new Rating();
		
		double averageRating = avgRating.getAverageRating();
		System.out.println("Average Rating: " +averageRating);
		
		System.out.println("Your rating has been saved. Thank you for the feedback.");
		}
		
	System.out.print("If you like to continue shoping type 'yes' orelse type anything: ");
		
	continueShopping = choice.next();
	//If customer wants to continue shopping then he/she should type yes.
	}while (continueShopping .equals("yes"));
	
	System.out.println("Thank You!!!!!");
	System.out.println("Good Bye :-) ");
		}
	// If user selects show then, this if loop will be executed. 
		if(args[0].equals("show"))
		{
		    Shop shopObject = new Shop();
		    int booksSold = shopObject.getBooksSold();
		    int cdsSold = shopObject.getcdsSold();
		    int moviesSold = shopObject.getmoviesSold();
		    long total = shopObject.calculateRevenue();
		    System.out.println("------------------------------------");
		    System.out.println("Welcome to the Media Shop");
		    System.out.println("------------------------------------");
		    System.out.println("Total Books sold: " +booksSold);
		    System.out.println("Total cds sold: " +cdsSold);
		    System.out.println("Total movies sold: " +moviesSold);
		    System.out.println("Total Revenue: $" +total);
		    
		}
}
	
	
}