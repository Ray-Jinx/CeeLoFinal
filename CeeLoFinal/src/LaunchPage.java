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

/** Description: 
 * @author: Kevin Ren, Nam Pham
 * @since: 12/2/2023
 */


public class LaunchPage implements ActionListener{
	
	JFrame frame = new JFrame();	
	
	JButton startButton = new JButton("Start Game");//Create buttons to start game
	JButton howToButton = new JButton("How to Play");//Create button of how to play
	Image backgroundImage;//Assign background image
	JLabel background;//Create label to put the backgournd image
	String userName;//Create user's name to input
	double userBalance = 0;

	
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

		ImageIcon backGround = new ImageIcon("rsc/Cee_LoTITLE (3).png"); //Create the image



		background = new JLabel("",backGround,JLabel.CENTER);//Set the background image to the JLabel
		background.setBounds(0,0, 1280,720);
		frame.setTitle("CeeLo");
		frame.getContentPane().add(background);
		
	}
	
	
	@Override
	/** Description: Performs action when a button is clicked
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {//If start button is clicked
			try {
				do {
					String userName = JOptionPane.showInputDialog("Enter Your Name");//Prompt enter your name
					double userBalance = Integer.parseInt(JOptionPane.showInputDialog("Enter Your Starting Balance"));//Prompt enter your balance
					if (!userName.isEmpty() || userBalance != 0) {//If user name and balance is correct
						GameWindow game = new GameWindow(userName,userBalance);//Start game window
						frame.dispose();
					}
				} while (userName.isEmpty() || userBalance == 0);
			} catch (Exception e1) {
				
			}
			
			}
		else if (e.getSource()==howToButton) {//If how to play button is clicked
			frame.dispose();//Close main page
			
			HowToPlay howTo = new HowToPlay();//Open how to play page
		}
		
	}
	
}
