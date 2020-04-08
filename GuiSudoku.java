import javax.swing.*;
import java.awt.*;

class GuiSudoku extends JPanel{
	
	public static int[][] board = new int[][] {
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
	
	public static JTextField[][] cells = new JTextField[board.length][board.length];
	public static JFrame frame = new JFrame("Sudoku Solver");
	
    public static void main(String args[]){
	  	  frame.setLayout(new GridLayout(board.length, board.length));
	  	  draw(board, cells, frame);
	  	  frame.addKeyListener(new Keyboard());
	  	  frame.setFocusable(true);
	  	  
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
    
    public static boolean solve(int[][] board, JTextField[][] cells) {
		boolean noZeros = true;
		int row = 0;
		int col = 0;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					
					noZeros = false;
					break;
				}
			}
			
			if(!noZeros) {
				break;
			}
		}
		
		if(noZeros) {
			return true;
		}
		
		for(int num = 1; num <= board.length; num++) {
			if(isPossible(board, row, col, num)) {
				board[row][col] = num;
				cells[row][col].setText(String.valueOf(num));
				
				if(solve(board, cells)) {
					return true;
				}
				
				else {
					board[row][col] = 0;
					cells[row][col].setText("0");
				}
			}
		}
		
		return false;
		
	}
    
    public static boolean isPossible(int[][] board, int row, int col, int num) {
		int sqrtBoard = (int) Math.sqrt(board.length);
		int beginRow = row - row % sqrtBoard;
		int beginCol = col - col % sqrtBoard;
		
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		for(int j = 0; j < board.length; j++) {
			if(board[j][col] == num) {
				return false;
			}
		}
		
		for(int a = beginRow; a < beginRow + sqrtBoard; a++) {
			for(int b = beginCol; b < beginCol + sqrtBoard; b++) {
				if(board[a][b] == num) {
					return false;
				}
			}
		}
		
		return true;
		
	}
      
}
