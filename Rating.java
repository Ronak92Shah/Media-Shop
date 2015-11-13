/**
 * 
 * @author Ronak Shah(4949773) and took help from Rabindra Sah.
 * @version 19 / 09 / 2014
 * 
 */

public class Rating {

	static int scores[] = new int[100];
	static int numberOfRating;
	
	/**
	 * This Method is being used to calculated AverageRating.
	 * @param score
	 * @return AverageRating
	 */
	
	public double getAverageRating(){
		
		double totalRating = 0;
		double averageRating = 0;
		
		for(int i = 0; i<(scores.length-1); i++){
			
		 int store;
		 store = scores[i]; 
			
		 totalRating += store;
		}
		
		 averageRating=totalRating/numberOfRating;
		 return averageRating;
		 	
	}
	
	/**
	 * This Method is being used to update rating.
	 * @param mediaRating
	 */
	
	public void updateRating(int mediaRating){
	// If scores is full then oldest one is yo be eliminated.
	//Took help from Rabindra Sah for this method.
		if(!(scores[99] == 0)){
			
			for(int i = 0; i <=scores.length ; i++){
				
				scores[i] = scores[i+1];
				
			}
		}
				
		for(int i = 0 ; i<= scores.length ; i++){
						
			if(scores[i] == 0){
				
				scores[i] = mediaRating; 
				break; //if we find the valid place in the scores so that we can fill in that and come out. 
			}			
	}
		
		numberOfRating = numberOfRating + 1;
		setScores(scores);
		setNumberOfRating(numberOfRating);
		}
/**
 * This Method is being used to get Scores.
 * @return scores
 */
	
	public int[] getScores() {
		return scores;
	}
	
	/**
	 * This method is used to set scores.
	 * @param scores
	 */
	
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	/**
	 * This method is used to get number of Rating.
	 * @return
	 */
	
	public int getNumberOfRating() {
		return numberOfRating;
	}
	
	/**
	 * This Method is used to set numberOfRating.
	 * @param numberOfRating
	 */
	
	public void setNumberOfRating(int numberOfRating) {
		this.numberOfRating = numberOfRating;
	}
}
