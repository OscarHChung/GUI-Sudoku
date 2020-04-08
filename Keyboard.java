import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{
	boolean going = true;
	
	public void keyPressed(KeyEvent event) {
		
		if(going) {
			if(event.getKeyCode() == 32) {
				if(GuiSudoku.solve(GuiSudoku.board, GuiSudoku.cells)) {
					System.out.println("Here is the solution to this Sudoku");
				}
				else {
					System.out.println("No Solution");
				}
			}
			going = false;
		}
	}
}
