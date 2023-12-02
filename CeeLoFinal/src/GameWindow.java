import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GameWindow implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	Image backgroundImage;
	JLabel background;
	private JTextField playerBet;
	private JButton btnBet;
	private JLabel dice1,dice2,dice3;
	private JLabel lblPlayer_1,lblPlayer_2,lblPlayer_3,lblPlayer_4;
	private JLabel lblBanker_1,lblBanker_2,lblBanker_3,lblBanker_4;
	private JLabel lblBets1,lblBets2,lblBets3;
	private JButton btnHome = new JButton("Home");
	private JButton btnRoll = new JButton("Roll");
	private Game game;
	private String userName;
	private double userBalance;
	private JLabel lblBalanceP1,lblBalanceP2,lblBalanceP3,lblBalanceP4;
	private int bankIndex = 0;
	private int[] playerIndex = {3,2,1,0};
	private JLabel cpuBet1,cpuBet2,cpuBet3;

	
	
	GameWindow(String userName, double userBalance){
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		btnRoll.setBounds(1056, 630, 105, 27);
		btnRoll.addActionListener(this);
		frame.getContentPane().add(btnRoll);
		
		
		btnHome.setBounds(1153, 0, 105, 27);
		btnHome.addActionListener(this);
		frame.getContentPane().add(btnHome);
		
		cpuBet1 = new JLabel("1000");
		cpuBet1.setBounds(48, 211, 60, 17);
		cpuBet1.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet1);
		
		cpuBet2 = new JLabel("1000");
		cpuBet2.setBounds(393, 96, 60, 17);
		cpuBet2.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet2);
		
		cpuBet3 = new JLabel("1000");
		cpuBet3.setBounds(1079, 211, 60, 17);
		cpuBet3.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet3);
		
		playerBet = new JTextField();
		playerBet.setText("1000");
		playerBet.setBounds(771, 633, 114, 21);
		frame.getContentPane().add(playerBet);
		playerBet.setColumns(10);
		
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
		lblPlayer_1.setForeground(Color.RED);
		lblPlayer_1.setBounds(271, 573, 60, 17);
		frame.getContentPane().add(lblPlayer_1);
		
		
		
		lblBanker_1 = new JLabel("BANKER");
		lblBanker_1.setForeground(Color.ORANGE);
		lblBanker_1.setBounds(185, 573, 60, 17);
		frame.getContentPane().add(lblBanker_1);
		lblBanker_1.setVisible(true);
		
		lblBanker_2 = new JLabel("BANKER");
		lblBanker_2.setForeground(Color.ORANGE);
		lblBanker_2.setBounds(101, 182, 60, 17);
		frame.getContentPane().add(lblBanker_2);
		lblBanker_2.setVisible(false);
		
		lblBanker_3 = new JLabel("BANKER");
		lblBanker_3.setForeground(Color.ORANGE);
		lblBanker_3.setBounds(429, 70, 60, 17);
		frame.getContentPane().add(lblBanker_3);
		lblBanker_3.setVisible(false);
		
		lblBanker_4 = new JLabel("BANKER");
		lblBanker_4.setForeground(Color.ORANGE);
		lblBanker_4.setBounds(1115, 182, 60, 17);
		frame.getContentPane().add(lblBanker_4);
		lblBanker_4.setVisible(false);
		
		
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
		
		
		
		
		lblBalanceP2 = new JLabel("Balance: ");
		lblBalanceP2.setForeground(Color.WHITE);
		lblBalanceP2.setBounds(12, 247, 158, 17);
		frame.getContentPane().add(lblBalanceP2);
		
		lblBalanceP3 = new JLabel("Balance:");
		lblBalanceP3.setForeground(Color.WHITE);
		lblBalanceP3.setBounds(357, 125, 151, 17);
		frame.getContentPane().add(lblBalanceP3);
		
		lblBalanceP4 = new JLabel("Balance:");
		lblBalanceP4.setForeground(Color.WHITE);
		lblBalanceP4.setBounds(1043, 247, 158, 17);
		frame.getContentPane().add(lblBalanceP4);
		
		lblBalanceP1 = new JLabel("Balance: ");
		lblBalanceP1.setForeground(Color.WHITE);
		lblBalanceP1.setBounds(185, 635, 158, 17);
		frame.getContentPane().add(lblBalanceP1);
		
		
		
		
		ImageIcon backGround = new ImageIcon("/home/kevinren/Documents/CeeLoFinal/CeeLoFinal/rsc/CeeLo_table (1).jpg");
		background = new JLabel("",backGround,JLabel.CENTER);
		background.setBackground(Color.BLACK);
		background.setBounds(0,0, 1280,720);
		frame.getContentPane().add(background);
		
		
		
		
		
		this.game = new Game(userName, userBalance);
		disPlayBalance(game);
		
		
		
		
		
		
		
		

	}
	
	
	
	
	private void disPlayBalance(Game game){
		
		lblBalanceP1.setText("Balance: " + game.getPlayerBalance(playerIndex[3]));
		lblBalanceP2.setText("Balance: " + game.getPlayerBalance(playerIndex[2]));
		lblBalanceP3.setText("Balance: " + game.getPlayerBalance(playerIndex[1]));
		lblBalanceP4.setText("Balance: " + game.getPlayerBalance(playerIndex[0]));
		lblPlayer_1.setText(game.getPlayerName(playerIndex[3]));
		lblPlayer_2.setText(game.getPlayerName(playerIndex[2]));
		lblPlayer_3.setText(game.getPlayerName(playerIndex[1]));
		lblPlayer_4.setText(game.getPlayerName(playerIndex[0]));
		//lblBets1.setText();
		//lblBets2.setText();
		//lblBets3.setText();
		
		int temp = playerIndex[0];
		for (int i = 0; i < 3 ; i++) {
			this.playerIndex[i] = this.playerIndex[i+1];
		}
		this.playerIndex[3] = temp;
	}
	
	
	public void moveBank(){
		this.bankIndex++;
		if (bankIndex > 4) {
			this.bankIndex = 1;
		}
		if (bankIndex == 1) {
			lblBanker_1.setVisible(true);
			lblBanker_4.setVisible(false);
		} else if (bankIndex == 2) {
			lblBanker_2.setVisible(true);
			lblBanker_1.setVisible(false);
		} else if (bankIndex == 3) {
			lblBanker_3.setVisible(true);
			lblBanker_2.setVisible(false);
		} else if (bankIndex == 4) {
	
			lblBanker_4.setVisible(true);
			lblBanker_3.setVisible(false);
		}
		
		
		System.out.println(bankIndex);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			
			game.startGame();
			disPlayBalance(game);
			moveBank();
		} else if (e.getSource()==btnHome) {
			LaunchPage home = new LaunchPage();
			frame.dispose();
		} else if (e.getSource()==btnBet) {
			double theBet = Integer.parseInt(playerBet.getText());
			
		}
		
	}
}
