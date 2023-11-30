import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GameWindow {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	Image backgroundImage;
	JLabel background;
	private JTextField textField;
	private JButton btnBet;
	private JLabel dice1,dice2,dice3;
	private JLabel lblPlayer_1,lblPlayer_2,lblPlayer_3,lblPlayer_4;
	private JLabel lblBanker;
	private JLabel lblBets1,lblBets2,lblBets3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	GameWindow(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBounds(1056, 630, 105, 27);
		frame.getContentPane().add(btnRoll);
		textField = new JTextField();
		textField.setText("1000");
		textField.setBounds(771, 633, 114, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBet = new JButton("Bet");
		btnBet.setBounds(897, 630, 105, 27);
		frame.getContentPane().add(btnBet);
		
		dice1 = new JLabel("dice1");
		dice1.setBounds(380, 268, 60, 17);
		frame.getContentPane().add(dice1);
		
		dice2 = new JLabel("dice2");
		dice2.setBounds(597, 268, 60, 17);
		frame.getContentPane().add(dice2);

		dice3 = new JLabel("dice3");
		dice3.setBounds(800, 268, 60, 17);
		frame.getContentPane().add(dice3);
		
		lblPlayer_2 = new JLabel("player2");
		lblPlayer_2.setForeground(Color.WHITE);
		lblPlayer_2.setBounds(12, 182, 60, 17);
		frame.getContentPane().add(lblPlayer_2);
		
		lblPlayer_3 = new JLabel("player3");
		lblPlayer_3.setForeground(Color.WHITE);
		lblPlayer_3.setBounds(357, 70, 60, 17);
		frame.getContentPane().add(lblPlayer_3);
		
		lblPlayer_4 = new JLabel("player4");
		lblPlayer_4.setForeground(Color.WHITE);
		lblPlayer_4.setBounds(1043, 182, 60, 17);
		frame.getContentPane().add(lblPlayer_4);
		
		lblPlayer_1 = new JLabel("player1");
		lblPlayer_1.setForeground(Color.WHITE);
		lblPlayer_1.setBounds(271, 573, 60, 17);
		frame.getContentPane().add(lblPlayer_1);
		
		
		
		lblBanker = new JLabel("BANKER");
		lblBanker.setForeground(Color.ORANGE);
		lblBanker.setBounds(185, 573, 60, 17);
		frame.getContentPane().add(lblBanker);
		
		lblBets1 = new JLabel("Bets:");
		lblBets1.setForeground(Color.WHITE);
		lblBets1.setBounds(12, 211, 60, 17);
		frame.getContentPane().add(lblBets1);
		
		lblBets2 = new JLabel("Bets:");
		lblBets2.setForeground(Color.WHITE);
		lblBets2.setBounds(357, 96, 60, 17);
		frame.getContentPane().add(lblBets2);
		
		lblBets3 = new JLabel("Bets:");
		lblBets3.setForeground(Color.WHITE);
		lblBets3.setBounds(1043, 211, 60, 17);
		frame.getContentPane().add(lblBets3);
		
		textField_1 = new JTextField();
		textField_1.setText("100");
		textField_1.setBounds(56, 211, 114, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("100");
		textField_2.setBounds(394, 94, 114, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("100");
		textField_3.setBounds(1080, 211, 114, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		ImageIcon backGround = new ImageIcon("/home/kevinren/Documents/CeeLoFinal/CeeLoFinal/rsc/CeeLo_table (1).jpg");
		background = new JLabel("",backGround,JLabel.CENTER);
		background.setBounds(0,0, 1280,720);
		frame.getContentPane().add(background);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void moveBank(){
		
		
	}
}
