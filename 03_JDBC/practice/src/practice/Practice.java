package practice;

public class Practice {

	public static void main(String[] args) {
	      
	      int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
	      int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
	      
	      int[] answer1 = solution(score1);
	      int[] answer2 = solution(score2);
	      
	      // [1, 2, 4, 3]
	      for(int i : answer1) 
	         System.out.print(i + " ");
	      
	      System.out.println();
	      
	      // [4, 4, 6, 2, 2, 1, 7]
	      for(int i : answer2)
	         System.out.print(i + " ");
	   }
	   
	   public static int[] solution(int[][] score) {
	      int[] answer = new int[score.length];
	      int[] sum = new int[score.length];
	      int rank =1;
	      
	      for(int i=0; i<score.length; i++) {
	    	  sum[i] = (score[i][0] + score[i][1]);
	      }
	      for(int i=0; i<score.length; i++) {
	    	 rank =1;
	    	 for(int r =0; r<score.length; r++) {
	    		 if(sum[i]<sum[r]) {
	    			 rank++;
	    	
	    		 }
	    		 
	    	 }
	    	 answer[i] = rank;
	      }

	        return answer;
	   }
}
