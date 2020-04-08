import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{
	
	public void keyPressed(KeyEvent event) {
		boolean going = true;
		if(going) {
			if(event.getKeyCode() == 32) {
				System.out.println("spacebar");
			}
			going = false;
		}
	}
}
