import javax.swing.*;
import java.awt.*;

class GuiPractice extends JPanel{
	
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
		  
		  setup(board);
    }
    
    public static void setup(int[][] board) {
  	  JTextField[][] cells = new JTextField[board.length][board.length];
  	  JFrame frame = new JFrame("Sudoku Solver");
  	  frame.setLayout(new GridLayout(board.length, board.length));
  	  draw(board, cells, frame);
  	  
  	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  frame.setSize(600, 600);
  	  frame.setVisible(true);
  	  
    }
    
    public static void draw(int[][] board, JTextField[][] cells, JFrame frame) {
    	frame.setVisible(false);
    	for(int i = 0; i < board.length; i++) {
    		  for(int j = 0; j < board.length; j++) {
    			  cells[i][j] = new JTextField();
    			  frame.add(cells[i][j]);
    			  cells[i][j].setEditable(false);
    			  cells[i][j].setText(String.valueOf(board[i][j]));
    			  
    			  cells[i][j].setHorizontalAlignment(JTextField.CENTER);
    			  cells[i][j].setFont(new Font("Courier", Font.BOLD, 20));
    		  }
    	  }
    }
      
}