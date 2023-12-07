import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GameWindow implements ActionListener{
	
	
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	Image backgroundImage;
	JLabel background;
	private JTextField playerBet;
	private JButton btnBet = new JButton("Bet");
	private JLabel aDice1,aDice2,aDice3, aDice4,aDice5,aDice6;
	private JLabel bDice1,bDice2,bDice3, bDice4,bDice5,bDice6;
	private JLabel cDice1,cDice2,cDice3, cDice4,cDice5,cDice6;


	private JLabel lblPlayer_1,lblPlayer_2,lblPlayer_3,lblPlayer_4;
	private JLabel lblBanker_1,lblBanker_2,lblBanker_3,lblBanker_4;
	private JLabel lblBets1,lblBets2,lblBets3;
	private JButton btnHome = new JButton("Home");
	private JButton btnRoll = new JButton("Roll");
	
	private String userName;
	private double userBalance;
	private double theBet = 1000;
	private JLabel lblBalanceP1,lblBalanceP2,lblBalanceP3,lblBalanceP4;
	private int bankIndex = 0;
	private int[] playerIndex = {3,2,1,0};
	private JLabel cpuBet1,cpuBet2,cpuBet3;
	boolean sort = false;
	ImageIcon diceFace1 = new ImageIcon("rsc/dice-six-faces-one.png");
	Image image1 = diceFace1.getImage();
	Image Face1 = image1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face1 = new ImageIcon(Face1);
	
	ImageIcon diceFace2 = new ImageIcon("rsc/dice-six-faces-two.png");
	Image image2 = diceFace2.getImage();
	Image Face2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face2 = new ImageIcon(Face2);
	
	ImageIcon diceFace3 = new ImageIcon("rsc/dice-six-faces-three.png");
	Image image3 = diceFace1.getImage();
	Image Face3 = image3.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face3 = new ImageIcon(Face3);
	
	ImageIcon diceFace4 = new ImageIcon("rsc/dice-six-faces-four.png");
	Image image4 = diceFace4.getImage();
	Image Face4 = image4.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face4 = new ImageIcon(Face4);
	
	ImageIcon diceFace5 = new ImageIcon("rsc/dice-six-faces-five.png");
	Image image5 = diceFace5.getImage();
	Image Face5 = image5.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face5 = new ImageIcon(Face5);
	
	ImageIcon diceFace6 = new ImageIcon("rsc/dice-six-faces-six.png");
	Image image6 = diceFace6.getImage();
	Image Face6 = image6.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face6 = new ImageIcon(Face6);
	
	ImageIcon backGround = new ImageIcon("rsc/CeeLo_table (1).jpg");
	
	private Player[] players = new Player[4];
	private int[] scores = new int[4];
	private boolean roundEnd, continueRoll, continueGame;

	
	
	GameWindow(String userName, double userBalance){
		Random rand = new Random();
		this.players[0] = new Player(userName, userBalance);
		this.players[1] = new Player("Jenny", rand.nextInt((int) (userBalance))+userBalance*.5);
		this.players[2] = new Player("Henry", rand.nextInt((int) (userBalance))+userBalance*.5);
		this.players[3] = new Player("Sean", rand.nextInt((int) (userBalance))+userBalance*.5);
		
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
		btnBet.addActionListener(this);
		frame.getContentPane().add(btnBet);
		
		
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
		
		aDice1 = new JLabel("",face1,JLabel.CENTER);
		aDice1.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice1);
		aDice1.setVisible(false);

		aDice2 = new JLabel("",face2,JLabel.CENTER);
		aDice2.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice2);
		aDice2.setVisible(false);

		
		aDice3 = new JLabel("",face3,JLabel.CENTER);
		aDice3.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice3);
		aDice3.setVisible(false);

		aDice4 = new JLabel("",face4,JLabel.CENTER);
		aDice4.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice4);
		aDice4.setVisible(false);

		aDice5 = new JLabel("",face5,JLabel.CENTER);
		aDice5.setBounds(280, 268, 141, 221);
		aDice5.setVisible(false);

		aDice6 = new JLabel("",face6,JLabel.CENTER);
		aDice6.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice6);
		aDice6.setVisible(false);
		
		bDice1 = new JLabel("",face1,JLabel.CENTER);
		bDice1.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(bDice1);
		bDice1.setVisible(false);
		
		bDice2 = new JLabel("",face2,JLabel.CENTER);
		bDice2.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice2);
		bDice2.setVisible(false);
		
		bDice3 = new JLabel("",face3,JLabel.CENTER);
		bDice3.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice3);
		bDice3.setVisible(false);
		
		bDice4 = new JLabel("",face4,JLabel.CENTER);
		bDice4.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice4);
		bDice4.setVisible(false);
		
		bDice5 = new JLabel("",face5,JLabel.CENTER);
		bDice5.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice5);
		bDice5.setVisible(false);
		
		bDice6 = new JLabel("",face6,JLabel.CENTER);
		bDice6.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice6);
		bDice6.setVisible(false);
		
		cDice1 = new JLabel("",face1,JLabel.CENTER);
		cDice1.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice1);
		cDice1.setVisible(false);
		
		cDice2 = new JLabel("",face2,JLabel.CENTER);
		cDice2.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice2);
		cDice2.setVisible(false);
		
		cDice3 = new JLabel("",face3,JLabel.CENTER);
		cDice3.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice3);
		cDice3.setVisible(false);
		
		cDice4 = new JLabel("",face4,JLabel.CENTER);
		cDice4.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice4);
		cDice4.setVisible(false);
		
		cDice5 = new JLabel("",face5,JLabel.CENTER);
		cDice5.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice5);
		cDice5.setVisible(false);
		
		cDice6 = new JLabel("",face6,JLabel.CENTER);
		cDice6.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice6);
		cDice6.setVisible(false);

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
		
		
		

		
		
		background = new JLabel("",backGround,JLabel.CENTER);
		background.setBackground(Color.BLACK);
		background.setBounds(0,0, 1280,720);
		frame.getContentPane().add(background);
		
		disPlayBalance();
		

	}
	
	
	
	
	private void disPlayBalance(){
		
		
		lblBalanceP1.setText("Balance: " + players[playerIndex[3]].getBalance());
		lblBalanceP2.setText("Balance: " + players[playerIndex[2]].getBalance());
		lblBalanceP3.setText("Balance: " + players[playerIndex[1]].getBalance());
		lblBalanceP4.setText("Balance: " + players[playerIndex[0]].getBalance());
		lblPlayer_1.setText(players[playerIndex[3]].getName());
		lblPlayer_2.setText(players[playerIndex[2]].getName());
		lblPlayer_3.setText(players[playerIndex[1]].getName());
		lblPlayer_4.setText(players[playerIndex[0]].getName());
		
		cpuBet1.setText(""+players[playerIndex[2]].getBet());
		cpuBet2.setText(""+players[playerIndex[1]].getBet());
		cpuBet3.setText(""+players[playerIndex[0]].getBet());
		
		
		
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
	
	public void displayDice(int playerIndex){
		ArrayList<Integer> roll = players[playerIndex].getRoll();
		
		System.out.println("This is: "+roll.get(0)+roll.get(1)+roll.get(2));	
		
		if (roll.get(0) == 1) {
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice1.setVisible(true);

			System.out.print("1y");
			
		} else if (roll.get(0) == 2) {
			aDice1.setVisible(false);
			aDice3.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice2.setVisible(true);

			System.out.print("2y");

		} else if (roll.get(0) ==3) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice3.setVisible(true);

			System.out.print("3y");

		} else if (roll.get(0) ==4) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice4.setVisible(true);

			System.out.print("4y");

		} else if (roll.get(0) ==5) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice6.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(true);
			System.out.print("5y");

		} else if (roll.get(0) ==6) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice5.setVisible(false);
			aDice4.setVisible(false);
			aDice6.setVisible(true);
			System.out.print("6y");
		} 
		
		if (roll.get(1) == 1) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice1.setVisible(true);
			

		} else if (roll.get(1) == 2) {
			bDice6.setVisible(false);
			bDice1.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice2.setVisible(true);
			

		} else if (roll.get(1) ==3) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice1.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice3.setVisible(true);
			
			

		} else if (roll.get(1) ==4) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice1.setVisible(false);
			bDice4.setVisible(true);
			
			
			
			
			

		} else if (roll.get(1) ==5) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice1.setVisible(false);
			bDice4.setVisible(false);
			bDice5.setVisible(true);
			
		} else if (roll.get(1) ==6) {
			bDice1.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice6.setVisible(true);
			
		} 
		
		if (roll.get(2) == 1) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice1.setVisible(true);
			
			

		} else if (roll.get(2) == 2) {
			cDice6.setVisible(false);
			cDice1.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice2.setVisible(true);
			
			

		} else if (roll.get(2) ==3) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice1.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice3.setVisible(true);
			

		} else if (roll.get(2) ==4) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice1.setVisible(false);
			cDice4.setVisible(true);
			

		} else if (roll.get(2) ==5) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice1.setVisible(false);
			cDice4.setVisible(false);
			cDice5.setVisible(true);
			
			

		} else if (roll.get(2) ==6) {
			cDice1.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice6.setVisible(true);
			
			

		} 
		SwingUtilities.updateComponentTreeUI(frame);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			if (players[0].getBalance() < 0 || players[1].getBalance() < 0 || players[2].getBalance() < 0 || players[3].getBalance() < 0) {
				JOptionPane.showMessageDialog(null,"Game has ended! Someone lost all their money! ):","Game Ended!",JOptionPane.YES_OPTION);
				frame.dispose();
				LaunchPage home = new LaunchPage();
			}
			disPlayBalance();
			try {
				if (theBet > players[playerIndex[3]].getBalance()) {
					JOptionPane.showMessageDialog(null,"Your bet is invalid!","Invalid Bet",JOptionPane.YES_OPTION);
					playerBet.setText("0");
				} else {
					startGame(theBet, playerIndex[3]);
					disPlayBalance();
					moveBank();
				}
				if (players[0].getBalance() < 0 || players[1].getBalance() < 0 || players[2].getBalance() < 0 || players[3].getBalance() < 0) {
					JOptionPane.showMessageDialog(null,"Game has ended! Someone lost all their money! ):","Game Ended!",JOptionPane.YES_OPTION);
					frame.dispose();
					LaunchPage home = new LaunchPage();
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource()==btnHome) {
			LaunchPage home = new LaunchPage();
			frame.dispose();
		} else if (e.getSource()==btnBet) {
			try {
				theBet = Integer.parseInt(playerBet.getText());
				if (theBet > players[playerIndex[3]].getBalance()) {
					JOptionPane.showMessageDialog(null,"Your bet is invalid!","Invalid Bet",JOptionPane.YES_OPTION);
					playerBet.setText("0");
					theBet = 0;
				} else {
					theBet = Integer.parseInt(playerBet.getText());
				}
				System.out.println(theBet);
			} catch (Exception e2) {}
			
		}
		
	}	
		public void startGame(double playerBet, int playerIndex) throws InterruptedException {
			Random rand = new Random();
			players[playerIndex].setBet(playerBet);
			if (players[0].getBalance() > 0 && 
				players[1].getBalance() > 0 && 
				players[2].getBalance() > 0 && 
				players[3].getBalance() > 0) {
					for (int i = 0; i < 4; i++) {
						if (i != playerIndex) {
							players[i].setBet(rand.nextInt((int) (players[i].getBalance()*0.5)));
						}
					}
					disPlayBalance();
				}
			do {
				round();
				Player temp = players[0];
				for (int i = 0; i < 3 ; i++) {
					players[i] = players[i+1];
				}
				players[3] = temp;
				
				int temp2 = this.playerIndex[0];
				for (int i = 0; i < 3 ; i++) {
					this.playerIndex[i] = this.playerIndex[i+1];
				}
				this.playerIndex[3] = temp2;
				/*
				if (players[0].getBalance() > 0 && 
					players[1].getBalance() > 0 && 
					players[2].getBalance() > 0 && 
					players[3].getBalance() > 0) {
					for (int i = 1; i < 4; i++) {
						players[i].setBet(rand.nextInt((int) (players[i].getBalance())));
					}
				}
				*/
				
			} while (
					players[0].getBalance() > 0 && 
					players[1].getBalance() > 0 && 
					players[2].getBalance() > 0 && 
					players[3].getBalance() > 0 &&
					continueGame
					);
			
		}
		
		public double getPlayerBalance(int playerIndex) {
			return players[playerIndex].getBalance();
		}
		
		public String getPlayerName(int playerIndex) {
			return players[playerIndex].getName();
		}
		
		public double getPlayerBet(int playerIndex) {
			return players[playerIndex].getBet();
		}
		
		public boolean getRoundEnd() {
			return roundEnd;
		}
		
		public boolean getContinueRoll() {
			return continueRoll;
		}
		
		public void setContinueGame(boolean cont) {
			continueGame = cont;
		}
		
		public void setContinueRoll(boolean cont) {
			continueRoll = cont;
		}
		
		private void round() {
			for (int i = 0; i < 4; i++) {
				players[i].roll();
			}
			roundRoll(0);
			displayDice(playerIndex[3]);
			disPlayBalance();
			//Banker
			if (scores[0] == 0 || scores[0] == 10 || scores[0] == 12 || scores[0] == 13 || scores[0] == 1) {
				for (int i = 1; i < 4; i++) {
					players[0].withdraw(players[i].getBet());
					players[i].deposit(players[i].getBet());
				}
			} else if (scores[0] == 7 || scores[0] == 8 || scores[0] == 9 || scores[0] == 6) {
				for (int i = 1; i < 4; i++) {
					players[0].deposit(players[i].getBet());
					players[i].withdraw(players[i].getBet());
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				roundRoll(1);
				displayDice(playerIndex[2]);
				disPlayBalance();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				roundRoll(2);
				displayDice(playerIndex[1]);
				disPlayBalance();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				roundRoll(3);
				displayDice(playerIndex[0]);
				disPlayBalance();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
				if (scores[3] == 13) {
					scores[3] = 4;
				}
				if (scores[1] == 13) {
					scores[1] = scores[2];
				} 
				if (scores[2] == 13) {
					scores[2] = scores[3];
					if (scores[1] == 13) {
						scores[1] = scores[2];
					}
				}
				if (scores[1] == 12) {
					scores[1] = 3;
				}
				if (scores[3] == 12) {
					scores[3] = scores[2];
				}
				if (scores[2] == 12) {
					scores[2] = scores[1];
				}
			compareScore(1);
			compareScore(2);
			compareScore(3);
			}
			for (int i = 0; i < 4; i++) {
				System.out.println(players[i].toString() + "\nScore: " + scores[i] + "\n");
			}
		}
		
		private void compareScore(int playerIndex) {
			
			if (scores[playerIndex] == 8) {
				players[0].withdraw(players[playerIndex].getBet()*3);
				players[playerIndex].deposit(players[playerIndex].getBet()*3);
			} else if (scores[playerIndex] == 7) {
				players[playerIndex].withdraw(players[0].getBet()*5);
				players[playerIndex].deposit(players[playerIndex].getBet()*5);
			} else if (scores[playerIndex] == 9) {
				players[playerIndex].withdraw(players[0].getBet()*2);
				players[playerIndex].deposit(players[playerIndex].getBet()*2);
			} else if (scores[playerIndex] == 10) {
				players[0].deposit(players[playerIndex].getBet()*2);
				players[playerIndex].withdraw(players[playerIndex].getBet()*2);
			} else if (scores[playerIndex] == 0) {
				players[0].deposit(players[playerIndex].getBet());
				players[playerIndex].withdraw(players[playerIndex].getBet());
			} else if (scores[playerIndex] < scores[0]) {
				players[0].deposit(players[playerIndex].getBet());
				players[playerIndex].withdraw(players[playerIndex].getBet());
			} else if (scores[playerIndex] > scores[0]) {
				players[0].withdraw(players[playerIndex].getBet());
				players[playerIndex].deposit(players[playerIndex].getBet());		
			}
			
			
		}
		
		private int getScore(Player player) {
			int score;
			ArrayList<Integer> roll = player.getRoll();
			if (roll.get(0) == 1 && roll.get(1) == 1 && roll.get(2) == 1) {
				score = 7; //111
			} else if (roll.get(0) == roll.get(1) && roll.get(2) == roll.get(1)) {
				score = 8; //all same
			} else if (roll.get(0) == 4 && roll.get(1) == 5 && roll.get(2) == 6){
				score = 9; //456
			} else if (roll.get(0) == 1 && roll.get(1) == 2 && roll.get(2) == 3) {
				score = 10; //123
			} else if (roll.get(0) == 3 && roll.get(1) == 4 && roll.get(2) == 6) {
				score = 6; //Musashi
			} else if (roll.get(0) == 1 && roll.get(1) == 3 && roll.get(2) == 5){
				score = 12; //odds
			} else if (roll.get(0) == 2 && roll.get(1) == 4 && roll.get(2) == 6){
				score = 13; //evens
			} else if (roll.get(0) == roll.get(1)){
				score = roll.get(2); //normal
			} else if (roll.get(1) == roll.get(2)){
				score = roll.get(0); //normal
			} else {
				score = 0;
			}
			return score;
		} 
		
		private void roundRoll(int playerIndex) { //Roll for each player
			int tries = 0;
			do {
				scores[playerIndex] = getScore(players[playerIndex]);
				if (scores[playerIndex] == 0) {
					players[playerIndex].roll();
					tries++;
				}
			} while (scores[playerIndex] == 0 && tries != 3);
			scores[playerIndex] = getScore(players[playerIndex]);
		}
}
