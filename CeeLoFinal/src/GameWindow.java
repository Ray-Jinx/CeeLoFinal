import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameWindow {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	
	GameWindow(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
