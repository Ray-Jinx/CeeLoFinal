import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class LaunchPage implements ActionListener{
	
	JFrame frame = new JFrame();	
	JButton startButton = new JButton("Start Game");
	JButton howToButton = new JButton("How to Play");
	Image backgroundImage;
	JLabel background;

	
	LaunchPage(){
		
		startButton.setBounds(590,449,125,40);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		howToButton.setBounds(1143,12,125,40);
		howToButton.setFocusable(false);
		howToButton.addActionListener(this);
		howToButton.setBackground(Color.BLACK);
		howToButton.setForeground(Color.WHITE);
		frame.getContentPane().add(startButton);
		frame.getContentPane().add(howToButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		ImageIcon backGround = new ImageIcon("/home/kevinren/Documents/CeeLoFinal/CeeLoFinal/rsc/Cee_LoTITLE (3).png");
		background = new JLabel("",backGround,JLabel.CENTER);
		background.setBounds(0,0, 1280,720);
		frame.getContentPane().add(background);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			String name = JOptionPane.showInputDialog("Enter Your Name");
			String value = JOptionPane.showInputDialog("Enter Your Starting value");
			
			frame.dispose();
			GameWindow game = new GameWindow();
			}
		else if (e.getSource()==howToButton) {
			frame.dispose();
			HowToPlay howTo = new HowToPlay();
		}
	}
}
