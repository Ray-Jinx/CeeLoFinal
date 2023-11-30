import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HowToPlay/* implements ActionListener*/ implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	JButton btnGoBack = new JButton("Back");
	HowToPlay(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setText("There are also some special rolls:\n\nTriple: Automatic win of three times your bet.\n1-1-1: Automatic win of five times your bet.\n4-5-6: Automatic win of two times your bet.\n1-2-3: Automatic loss of two times your bet.\n6-3-4: Known as \"Musashi\", has a value of 6.\n1-3-5: All-Odds. Your total is 3, unless you are the second or third roller, in which case, your roll is the same amount of the one before you.\n2-4-6: All-Evens. Your total is 4, unless you are the first or second roller, in which case, your roll is the same amount of the one after you.\nMissing the Pot: This happens by very low chance. This results in an automatic loss.\n");
		txtrHi.setBounds(12, 185, 777, 196);
		frame.getContentPane().add(txtrHi);
		
		JLabel lblHowToPlay = new JLabel("How To Play");
		lblHowToPlay.setBounds(12, 0, 187, 26);
		frame.getContentPane().add(lblHowToPlay);
		
		JTextPane txtpnToBeginPlay = new JTextPane();
		txtpnToBeginPlay.setText("To begin play, each player (not the banker) places their bets, the maximum on each roll being 1000 for each player. The banker rolls to establish what's to beat, and then each of the players rolls to try to beat the banker. Everyone who rolls gets three attempts to make a viable set, but once a set is made, they can no longer roll. Typical play is looking for a pair in two of your three dice. When you get a pair, the third die is your \"points\", so if you roll a 2, 2, and 3, your points are 3. Getting a 1 is an automatic loss, and a 6 is an automatic win. If after three rolls you cannot make a viable set, then you get \"No point\" and it's an automatic loss. If the banker ever gets an automatic win or loss, the round ends there and play moves to the next banker.");
		txtpnToBeginPlay.setBounds(12, 38, 777, 216);
		frame.getContentPane().add(txtpnToBeginPlay);
		
		
		btnGoBack.setBounds(1149, 0, 105, 27);
		frame.getContentPane().add(btnGoBack);
		frame.setVisible(true);
		btnGoBack.setFocusable(false);
		btnGoBack.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnGoBack) {
			frame.dispose();
			LaunchPage launch = new LaunchPage();
			}
}
}

