import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener{
	
	JFrame frame = new JFrame();	
	JButton startButton = new JButton("Start Game");
	JButton howToButton = new JButton("How to Play");
	Image backgroundImage;
	
	LaunchPage(){
		
		startButton.setBounds(578,600,125,40);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		howToButton.setBounds(578,500,125,40);
		howToButton.setFocusable(false);
		howToButton.addActionListener(this);
		frame.add(startButton);
		frame.add(howToButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setLayout(null);
		frame.setVisible(true);
		backgroundImage = new ImageIcon("CeeLo_title.png").getImage();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			frame.dispose();
			GameWindow game = new GameWindow();
			}
		else if (e.getSource()==howToButton) {
			frame.dispose();
			HowToPlay howTo = new HowToPlay();
		}
	}
}
