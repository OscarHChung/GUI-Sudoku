import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

class Main{
	   
      public static void main(String args[]){
    	  int[][] board = new int[][] {
			  { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
			  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
			  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
		  };
		  int boardLength = board.length;
		  
		  guiWindowOpen(board, boardLength);
	
//		  if(sudokuSolver(board, boardLength)) {
//			  guiWindowOpen(board, boardLength);
//			  //TODO
//		  }
//		  else {
//			  System.out.println("No Solution");
//		  }
     }
    
	public static void guiWindowOpen(int[][] board, int boardLength) {
    	 ArrayList<JButton> buttonList = new ArrayList<JButton>();
    	 
    	 JFrame frame = new JFrame("Sudoku Solver");
   	  	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	  	 frame.setSize(boardLength*100,boardLength*100);
   	  	 
   	  	 for(int i = 0; i < boardLength; i++) {
   	  		 for(int j = 0; j < boardLength; j++) {
   	  			 JButton setButton = new JButton(String.valueOf(board[i][j]));
   	  			 buttonList.add(setButton);
   	  		 }
   	  	 }
   	  	 frame.setVisible(true);
     }
}