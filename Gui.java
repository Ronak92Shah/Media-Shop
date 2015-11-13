
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 * 
 * @author ronak and took help from Parag
 *
 */
public class Gui implements ActionListener{
	
	JFrame frame;
	
	JTable tableBook;
	JTable tableCD;
	JTable tableMovie;
	
	JLabel labelOne;
	JLabel labelSecond;
	JLabel labelThree;
	
	JPanel panelTop;
    JPanel panelMiddle;
    
    JPanel panelPurchaseButton;
    JPanel panelTextArea;
    
    
    JButton addButton;
    JButton purchaseButton;
    JButton showButton;
    JButton cancelButton;
    
    JTextArea output;
    
    

    String[] media = {"Select","Book", "CD","Movie"};
    
   
    String store;
    
    
    
   JComboBox mediaSalesBox = new JComboBox(media);

   final List<TableCellEditor> edit = new ArrayList<TableCellEditor>(100);
   
   ArrayList<Book> books = Warehouse.getBooks();
   public Object[][] bookData = new Object[books.size()][5];
   
   ArrayList<CD> cds = Warehouse.getCDs();
   public Object[][] cdData = new Object[cds.size()][5];
   
   ArrayList<Movie> movies = Warehouse.getMovies();
   public Object[][] movieData = new Object[movies.size()][5];
   
  // ArrayList<Media> addListBook = new ArrayList<Media>();
   ArrayList<Media> addList = new ArrayList<Media>();
   
   ArrayList<Media> itemsSold = new ArrayList<Media>();
   
    	public Gui(){
    		
    		designFrame();
    		designMenuBar();
    		
    		
    		
    	}
    	   	/**
    	   	 * Method design Frame
    	   	 */
    	public void designFrame(){
    		
    		frame = new JFrame("Media Shop");
    		frame.setVisible(true);
    		frame.setSize(400,400);
    		
    		  	labelOne = new JLabel("Welcome to Media Shop");
    	        labelSecond = new JLabel("Buy original copies at the cheapest rates");
    	        labelThree = new JLabel();
    	        
    	        addButton = new JButton("Add");
    	        purchaseButton = new JButton("Purchase");
    	        showButton = new JButton("Show");
    	        cancelButton = new JButton("Cancel");
    	        
    	        output= new JTextArea(10, 40);
    	        
    	        panelTop = new JPanel();
    	        panelMiddle = new JPanel();
    	       
    	        panelPurchaseButton = new JPanel();
    	        panelTextArea = new JPanel();
    	        
    	        
    	        
    	        
    	        
    	        output.setEditable(false);
    	        
    	        
    	        
    	        
    	        frame.add(panelTop, BorderLayout.NORTH);
    	        frame.add(panelMiddle, BorderLayout.CENTER);
    	        
    	        frame.add(panelTextArea, BorderLayout.EAST);
    	        //frame.add(panelPurchaseButton, BorderLayout.);
    	        
    	       
    	        
    	        
    	        
    	        mediaSalesBox.addActionListener(new ActionListener(){
    	        	
    	        
    	        	public void actionPerformed(ActionEvent e){
    	        		
    	        		String str = mediaSalesBox.getSelectedItem().toString();
    	        		if(str.equals("Book")){
    	        			
    	        			panelMiddle.removeAll();
    	        			labelOne.setText(str);
    	        			panelMiddle.repaint();
    	        		
    	        			booksMethod();
    	        			//System.out.println("hii");
    	        			panelMiddle.add(addButton);
    	        			panelTextArea.add(output);
    	        			panelTop.add(purchaseButton);
    	        			panelMiddle.add(showButton);
    	        			panelMiddle.add(cancelButton);
    	        			
    	        		
    	        		}else if(str.equals("CD")){
    	        			
    	        			panelMiddle.removeAll();
    	        			labelOne.setText(str);
    	        			panelMiddle.repaint();
    	        			
    	        			cdsMethod();
    	        			panelMiddle.add(addButton);
    	        			panelTextArea.add(output);
    	        			panelTop.add(purchaseButton);
    	        			panelMiddle.add(showButton);
    	        			panelMiddle.add(cancelButton);
    	        		
    	        			
    	        		}else if(str.equals("Movie")){
    	        			
    	        			panelMiddle.removeAll();
    	        			labelOne.setText(str);
    	        			panelMiddle.repaint();
    	        
    	        			moviesMethod();
    	        			panelMiddle.add(addButton);
    	        			panelTextArea.add(output);
    	        			panelTop.add(purchaseButton);
    	        			panelMiddle.add(showButton);
    	        			panelMiddle.add(cancelButton);
    	        		} 		
    	        	}
    	       });
    	        
    	        
    	        addButton.addMouseListener(new MouseAdapter()
    	        {
    	        	
    	        	public void mouseClicked(MouseEvent e){
    	        		
    	        		if(store.equals("Book")){
    	        			
    	        			int rowCount = tableBook.getRowCount();
    	        			for(int r = 0; r < rowCount; r++){
    	        				
    	        				String strBook = (String) String.valueOf(tableBook.getValueAt(r, 4));
    	        				int selectBook = Integer.parseInt(strBook);
    	        				System.out.println(selectBook);
    	        				if(selectBook > 0){
    	        					
    	        					Book tabBookSelect = books.get(r);
    	        					
    	        					if(!addList.contains(tabBookSelect)){	
    	        						tabBookSelect.selected = selectBook;
    	        					addList.add(tabBookSelect);
    	        					}else{
    	        						
    	        						tabBookSelect.selected = selectBook;
    	        						
    	        					}
    	        				
    	        				}
    	        				
    	        				
    	        			}
    	        		}	else if(store.equals("CD")){
    	        			
    	        			System.out.println("CD");
    	        			int rowCount = tableCD.getRowCount();
    	        			for(int c = 0; c < rowCount; c++){
    	        				
    	        				String strCD = (String) String.valueOf(tableCD.getValueAt(c, 4));
    	        				int selectCD = Integer.parseInt(strCD);
    	        				System.out.println(selectCD);
    	        				if(selectCD > 0){
    	        					
    	        					CD tabCDSelect = cds.get(c);
    	        					
    	        					if(!addList.contains(tabCDSelect)){
    	        					
    	        						tabCDSelect.selected = selectCD; 
    	        					addList.add(tabCDSelect);
    	        					}else{
    	        						
    	        						tabCDSelect.selected = selectCD;
    	        						
    	        					}
    	        				
    	        				}
    	        					
    	        			}
    	        		
    	        		}else if(store.equals("Movies")){
    	        			
    	        			System.out.println("Movies");
    	        			int rowCount = tableMovie.getRowCount();
    	        			for(int m = 0; m < rowCount; m++){
    	        				
    	        				String strMovie = (String) String.valueOf(tableMovie.getValueAt(m, 4));
    	        				int selectMovie = Integer.parseInt(strMovie);
    	        				System.out.println(selectMovie);
    	        				if(selectMovie > 0){
    	        					
    	        					Movie tabMovieSelect = movies.get(m);
    	        					
    	        					if(!addList.contains(tabMovieSelect)){
    	        					
    	        						tabMovieSelect.selected = selectMovie; 
    	        					addList.add(tabMovieSelect);
    	        					}else{
    	        						
    	        						tabMovieSelect.selected = selectMovie;
    	        						
    	        					}
    	        				
    	        				}
    	        					
    	        			}
    	        		
    	        		}
    	        		
    	        		 output.setText("");
    	         		for(Media media:addList){
    	         			
    	         			output.append(" Title: "+ media.getTitle() + " Quantity: " +media.selected + " TotalPrice: $" +(media.getPrice()*media.selected) +"\n" );
    	         			
    	         		}
    	        		
    	        		}
    	        	
    	        }); 
    	        
    	       
    	        purchaseButton.addActionListener(new ActionListener(){
    	        
    	        	/**
    	        	 * Method ActionPerformed
    	        	 */
    	        	public void actionPerformed(ActionEvent e){
    	        		
    	        		output.setText("");
    	        		
    	        		output.append("\n"+"\n"+"\n");
    	        		output.append("------------------------------------------------------------"+"\n");
    	        		output.append("Items SuccesFully Purchased"+"\n");
    	        		output.append("Thank You for Shopping with Media Sales"+"\n");
    	        		output.append("------------------------------------------------------------");
    	        		
    	        		 for(Media media: addList)
    	                 {
    	                     media.sellCopies(media.getPrice(),media.selected);
    	                     media.setAvailable(media.getAvailable()-media.selected);
    	                     itemsSold.add(media);
    	                 }
    	        		
    	        	}
    	        	
    	        	
    	        	
    	        	
    	        }
    	        		
    	        		);
    	        
    	        /**
    	         * Method ShowButton
    	         */
    	        showButton.addActionListener(new ActionListener(){
        	        
    	        	public void actionPerformed(ActionEvent e){
    	        		
    	        		output.setText("");
    	        		output.append("List of Items Purchased"+ "\n"+"\n");
    	        			for(Media media:addList){
    	         			output.append(" Title: "+ media.getTitle() + " Quantity: " +media.selected + " TotalPrice: $" +(media.getPrice()*media.selected) +"\n" );
    	         		}
    	        	}
    	        	
    	        	
    	        	
    	        	
    	        }
    	        		
    	        		);
    	        /**
    	         * Method cancelButton
    	         */
    	        cancelButton.addActionListener(new ActionListener(){
        	        
    	        	public void actionPerformed(ActionEvent e){
    	        		
    	        		addList = new ArrayList<Media>();
    	        		output.setText("");
    	        		output.append("Shopping Canceled");
    	        	}
    	        	
    	        	
    	        	
    	        	
    	        }
    	        		
    	        		);
    	        
    	        
    	        
    	   }
    	
    	/**
    	 * method book
    	 */
    	public void booksMethod(){
    		
    		String[] col = {"Title", "Price", "Author","Available","Quantity"};
    		
    		for(Book book:books)
    		{
    			
    			bookData[books.indexOf(book)][0] = book.getTitle();
    			bookData[books.indexOf(book)][1] = book.getPrice();
    			bookData[books.indexOf(book)][2] = book.getAuthor();
    			bookData[books.indexOf(book)][3] = book.getAvailable();
    			bookData[books.indexOf(book)][4] = 0;
    			
    			String[] quantity = new String[book.getAvailable()+1];
    			
    			for(int k = 0; k<=book.getAvailable(); k++){
    				quantity[k] = Integer.toString(k);
    				}
    			
    			JComboBox box = new JComboBox(quantity);
    			DefaultCellEditor editor = new DefaultCellEditor(box);
    			edit.add(editor);
    		
    		}
    		
    		DefaultTableModel defaultTableBook = new DefaultTableModel(bookData,col);
			tableBook = new JTable(defaultTableBook)
			{
				public TableCellEditor getCellEditor(int bookData, int col){
					
					int editColumn = convertColumnIndexToModel(col);
					
					if(editColumn == 4 && bookData < 6)
						return edit.get(bookData);
					else
						return super.getCellEditor(bookData,col);
					
				}
				
			};
			panelMiddle.add(new JScrollPane(tableBook));
			
			store = "Book";
			
	    	    	}
    	
    	
 
    		/**
    		 * Method CD
    		 */
    	public void cdsMethod(){
    		
    		String[] col = {"Title", "Price", "Performer","Available","Quantity"};
    		
    		for(CD cd: cds){
    			
    			cdData[cds.indexOf(cd)][0] = cd.getTitle();
    			cdData[cds.indexOf(cd)][1] = cd.getPrice();
    			cdData[cds.indexOf(cd)][2] = cd.getPerformer();
   				cdData[cds.indexOf(cd)][3] = cd.getAvailable();
  				cdData[cds.indexOf(cd)][4] = 0;
    			
  				String[] quantityCd = new String[cd.getAvailable()+1];
  				
  						for(int i = 0; i<=cd.getAvailable(); i++){
  							quantityCd[i] = Integer.toString(i);}
    		
  			
			JComboBox box = new JComboBox(quantityCd);
			DefaultCellEditor editor = new DefaultCellEditor(box);
			edit.add(editor);
    	}
    		
    		DefaultTableModel defaultTableCD = new DefaultTableModel(cdData,col);
    		tableCD = new JTable(defaultTableCD)
    		{
    			public TableCellEditor getCellEditor(int cdData, int col){
    				
    				int editColumn = convertColumnIndexToModel(col);
					
					if(editColumn == 4 && cdData < 6)
						return edit.get(cdData);
					else
						return super.getCellEditor(cdData,col);
    				
    				
    			}
    			
    		};
    		
    		panelMiddle.add(new JScrollPane(tableCD));
    			
    		store = "CD";
    	}
    	
    		/**
    		 * Method Movies
    		 */
    	public void moviesMethod(){
    		
    		String[] col = {"Title", "Price", "Director","Available","Quantity"};
    		
    		for (Movie movie: movies){
    			
    			movieData[movies.indexOf(movie)][0] = movie.getTitle();
    			movieData[movies.indexOf(movie)][1] = movie.getPrice();
    			movieData[movies.indexOf(movie)][2] = movie.getDirector();
    			movieData[movies.indexOf(movie)][3] = movie.getAvailable();
    			movieData[movies.indexOf(movie)][4] = 0;
    			
    			String[] quantityMovie = new String[movie.getAvailable()+1];
  				
					for(int j = 0; j<=movie.getAvailable(); j++){
						quantityMovie[j] = Integer.toString(j);}
					

					JComboBox box = new JComboBox(quantityMovie);
					DefaultCellEditor editor = new DefaultCellEditor(box);
					edit.add(editor);
    		}
					
					DefaultTableModel defaultTableMovie = new DefaultTableModel(movieData,col);
		    		tableMovie = new JTable(defaultTableMovie)
		    		{
		    			public TableCellEditor getCellEditor(int movieData, int col){
		    				
		    				int editColumn = convertColumnIndexToModel(col);
							
							if(editColumn == 4 && movieData <6 )
								return edit.get(movieData);
							else
								return super.getCellEditor(movieData,col);
		    				
		    				
		    			}
		    			
		    		};
		    		
		    		panelMiddle.add(new JScrollPane(tableMovie));
    		store = "Movies";
    		
    	}
    	
    	
    	/**
    	 * Method Design MenuBar
    	 */
    	public void designMenuBar(){
    		
    		
    		
    		JMenuBar menubar = new JMenuBar();
    		frame.setJMenuBar(menubar);
    		
    		JMenu menu = new JMenu("Menu");
    		menubar.add(menu);
    		
    		JMenuItem mediaSales = new JMenuItem("Media Sales");
    		menu.add(mediaSales);
    		mediaSales.addActionListener(this);
    		
    		JMenuItem statistics = new JMenuItem("Statistics");
    		menu.add(statistics);
    		statistics.addActionListener(this);
    		
    		JMenuItem rating = new JMenuItem("Rating");
    		menu.add(rating);
    		rating.addActionListener(this);
       		
    	}
    	
    	/**
    	 * Method Action Performed
    	 */
   	public void actionPerformed(ActionEvent e){
    		
    		String s = e.getActionCommand();
    		
    		if(s.equals("Media Sales")){
    			
    			panelTop.removeAll();
    			panelTop.revalidate();
    			panelTop.repaint();
    			panelMiddle.removeAll();
    			panelMiddle.revalidate();
    			panelMiddle.repaint();
    			panelTextArea.removeAll();
    			panelTextArea.revalidate();
    			panelTextArea.repaint();
    			
    			labelOne.setText("Choose Media");
    	        labelSecond = new JLabel("Welcome to Media Shop");
    			panelTop.add(mediaSalesBox);
    			panelTop.add(labelSecond);
    			
    		
    			
    			
    		}else if(s.equals("Statistics")){
    			
    			//labelOne.setText("Statististics");
    			
    			panelTop.removeAll();
    			panelTop.revalidate();
    			panelTop.repaint();
    			panelMiddle.removeAll();
    			panelMiddle.revalidate();
    			panelMiddle.repaint();
    			panelTextArea.removeAll();
    			panelTextArea.revalidate();
    			panelTextArea.repaint();
    			
    	         int bookSold=0;
    	         int cdSold=0;
    	         int movieSold=0;
    	         float total =0;
    	         
    	         
    	         
    	         for(Media media:itemsSold)
    	         {
    	          
    	          if(media instanceof Book)
    	          {
    	           
    	        	  bookSold+=media.selected;
    	           total+=media.selected*media.getPrice();
    	          }
    	          
    	          else if (media instanceof CD)
    	          {
    	           
    	        	  cdSold+=media.selected;
    	           total+=media.selected*media.getPrice();
    	          }
    	          else if (media instanceof Movie)
    	          {
    	           
    	           movieSold=media.selected;
    	           total+=media.selected*media.getPrice();
    	          }
    	          
    	          
    	         }
    	         output.setText("");
    	         output.append(" Books Sold: " +bookSold +" Cds Sold: " +cdSold +"  Movies Sold :" +movieSold +"Total Revenue  " + total);
    	         output.append(".\n");
    	         panelTextArea.add(output);
    		}
    			
    		else if(s.equals("Rating")){
    			
    			labelOne.setText("Rating");
    		}
    		}
    		
    	
        /**
         * 	Main Method program starts from here
         * @param args
         */
    	public static void main(String[] args){
    		
    		Gui obj = new Gui();
    		
    	} 	
}