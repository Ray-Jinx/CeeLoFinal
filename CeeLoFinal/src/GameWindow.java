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

/** Description: 
 * @author: Kevin Ren, Nam Pham
 * @since: 12/2/2023
 */

public class GameWindow /* implements ActionListener*/ implements ActionListener{ 
	
	
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("HI");
	Image backgroundImage;
	JLabel background;
	private JTextField playerBet;
	private JButton btnBet = new JButton("Bet");
	private JLabel aDice1,aDice2,aDice3, aDice4,aDice5,aDice6;//Labels for each of the dice face. The first dice
	private JLabel bDice1,bDice2,bDice3, bDice4,bDice5,bDice6;//Labels for each of the dice face. The second dice
	private JLabel cDice1,cDice2,cDice3, cDice4,cDice5,cDice6;//Labels for each of the dice face. The third dice


	private JLabel lblPlayer_1,lblPlayer_2,lblPlayer_3,lblPlayer_4;//Label to display the player name for each players
	private JLabel lblBanker_1,lblBanker_2,lblBanker_3,lblBanker_4;//Label to display the banker (each player will be banker in cycles)
	private JLabel lblBets1,lblBets2,lblBets3;//Display "Bets:" by the computer players
	private JButton btnHome = new JButton("Home");//Create button to go back to main page
	private JButton btnRoll = new JButton("Roll");//Create button to roll the dice
	
	private String userName;//Create String to store the input of names by player
	private double userBalance;//Create double to store the input of balance by player
	private double theBet = 1000;//used for testing
	private JLabel lblBalanceP1,lblBalanceP2,lblBalanceP3,lblBalanceP4;//Create label to display balance for each player
	private int bankIndex = 0;//The index in which the order of how the bank moves
	private int[] playerIndex = {3,2,1,0};//The index in which the player moves
	private JLabel cpuBet1,cpuBet2,cpuBet3;//display the amount bets of the computers
	boolean sort = false;//Decide if we sort playerIndex
	ImageIcon diceFace1 = new ImageIcon("rsc/dice-six-faces-one.png");//Image of the dice face one
	Image image1 = diceFace1.getImage();
	Image Face1 = image1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face1 = new ImageIcon(Face1);
	
	ImageIcon diceFace2 = new ImageIcon("rsc/dice-six-faces-two.png");//Image of the dice face two
	Image image2 = diceFace2.getImage();
	Image Face2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face2 = new ImageIcon(Face2);
	
	ImageIcon diceFace3 = new ImageIcon("rsc/dice-six-faces-three.png");//Image of the dice face three
	Image image3 = diceFace1.getImage();
	Image Face3 = image3.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face3 = new ImageIcon(Face3);
	
	ImageIcon diceFace4 = new ImageIcon("rsc/dice-six-faces-four.png");//Image of the dice face four
	Image image4 = diceFace4.getImage();
	Image Face4 = image4.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face4 = new ImageIcon(Face4);
	
	ImageIcon diceFace5 = new ImageIcon("rsc/dice-six-faces-five.png");//Image of the dice face five
	Image image5 = diceFace5.getImage();
	Image Face5 = image5.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face5 = new ImageIcon(Face5);
	
	ImageIcon diceFace6 = new ImageIcon("rsc/dice-six-faces-six.png");//Image of the dice face six
	Image image6 = diceFace6.getImage();
	Image Face6 = image6.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	ImageIcon face6 = new ImageIcon(Face6);
	
	ImageIcon backGround = new ImageIcon("rsc/CeeLo_table (1).jpg");//Image of the background
	
	private Player[] players = new Player[4];//Initiate the Player class
	private int[] scores = new int[4];//Create a int array to store the scores of players
	private boolean roundEnd, continueRoll, continueGame;//Create if roundEnded, continue to roll or contiune to game

	
	
	/** Description: Initiate the gamewindow display all the GUI
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 *
	 * 
	 * @param String userName, double userBalance
	 */
	GameWindow(String userName, double userBalance){
		Random rand = new Random();
		this.players[0] = new Player(userName, userBalance);//Get user's name and balance into the players 
		this.players[1] = new Player("Jenny", rand.nextInt((int) (userBalance))+userBalance*.5);//Create computer's balance
		this.players[2] = new Player("Henry", rand.nextInt((int) (userBalance))+userBalance*.5);//Create computer's balance
		this.players[3] = new Player("Sean", rand.nextInt((int) (userBalance))+userBalance*.5);//Create computer's balance
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setTitle("CeeLo");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		btnRoll.setBounds(1056, 630, 105, 27);//Bond of the roll button
		btnRoll.addActionListener(this);
		frame.getContentPane().add(btnRoll);
		
		
		btnHome.setBounds(1153, 0, 105, 27);//Bond of the home button
		btnHome.addActionListener(this);
		frame.getContentPane().add(btnHome);
		
		cpuBet1 = new JLabel("1000"); //Initialize label for the computer's bet
		cpuBet1.setBounds(48, 211, 60, 17);
		cpuBet1.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet1);
		
		cpuBet2 = new JLabel("1000");//Initialize label for the computer's bet
		cpuBet2.setBounds(393, 96, 60, 17);
		cpuBet2.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet2);
		
		cpuBet3 = new JLabel("1000");//Initialize label for the computer's bet
		cpuBet3.setBounds(1079, 211, 60, 17);
		cpuBet3.setForeground(Color.WHITE);
		frame.getContentPane().add(cpuBet3);
		
		playerBet = new JTextField(); ////Initialize label for the user's bet
		playerBet.setText("1000");
		playerBet.setBounds(771, 633, 114, 21);
		frame.getContentPane().add(playerBet);
		playerBet.setColumns(10);
		
		btnBet = new JButton("Bet");//Create bet button
		btnBet.setBounds(897, 630, 105, 27);
		btnBet.addActionListener(this);
		frame.getContentPane().add(btnBet);
		
		
		lblPlayer_2 = new JLabel("player2");//Initialize label for the computer's name
		lblPlayer_2.setForeground(Color.WHITE);
		lblPlayer_2.setBounds(12, 182, 60, 17);
		frame.getContentPane().add(lblPlayer_2);
		
		lblPlayer_3 = new JLabel("player3");//Initialize label for the computer's name//Initialize label for the computer's name
		lblPlayer_3.setForeground(Color.WHITE);
		lblPlayer_3.setBounds(357, 70, 60, 17);
		frame.getContentPane().add(lblPlayer_3);
		
		lblPlayer_4 = new JLabel("player4");
		lblPlayer_4.setForeground(Color.WHITE);
		lblPlayer_4.setBounds(1043, 182, 60, 17);
		frame.getContentPane().add(lblPlayer_4);
		
		lblPlayer_1 = new JLabel("player1");//Initialize label for the player's name
		lblPlayer_1.setForeground(Color.RED);
		lblPlayer_1.setBounds(271, 573, 60, 17);
		frame.getContentPane().add(lblPlayer_1);
		
		
		
		lblBanker_1 = new JLabel("BANKER");//Initialize banker label for player1
		lblBanker_1.setForeground(Color.ORANGE);//Set color to orange for better visibility
		lblBanker_1.setBounds(185, 573, 60, 17);
		frame.getContentPane().add(lblBanker_1);
		lblBanker_1.setVisible(true);
		
		lblBanker_2 = new JLabel("BANKER");//Initialize banker label for player2
		lblBanker_2.setForeground(Color.ORANGE);//Set color to orange for better visibility
		lblBanker_2.setBounds(101, 182, 60, 17);
		frame.getContentPane().add(lblBanker_2);
		lblBanker_2.setVisible(false);
		
		lblBanker_3 = new JLabel("BANKER");//Initialize banker label for player3
		lblBanker_3.setForeground(Color.ORANGE);//Set color to orange for better visibility
		lblBanker_3.setBounds(429, 70, 60, 17);
		frame.getContentPane().add(lblBanker_3);
		lblBanker_3.setVisible(false);
		
		lblBanker_4 = new JLabel("BANKER");//Initialize banker label for player4
		lblBanker_4.setForeground(Color.ORANGE);//Set color to orange for better visibility
		lblBanker_4.setBounds(1115, 182, 60, 17);
		frame.getContentPane().add(lblBanker_4);
		lblBanker_4.setVisible(false);
		
		
		lblBets1 = new JLabel("Bets:");//Initialize the Bets indicator label for player one
		lblBets1.setForeground(Color.WHITE);//Set color to white for better visibility
		lblBets1.setBounds(12, 211, 60, 17);
		frame.getContentPane().add(lblBets1);
		
		lblBets2 = new JLabel("Bets:");//Initialize the Bets indicator label for player one
		lblBets2.setForeground(Color.WHITE);//Set color to white for better visibility
		lblBets2.setBounds(357, 96, 60, 17);
		frame.getContentPane().add(lblBets2);
		
		lblBets3 = new JLabel("Bets:");//Initialize the Bets indicator label for player one
		lblBets3.setForeground(Color.WHITE);//Set color to white for better visibility
		lblBets3.setBounds(1043, 211, 60, 17);
		frame.getContentPane().add(lblBets3);
		
		aDice1 = new JLabel("",face1,JLabel.CENTER);//Create label of the face one of the first dice, displays the image face1
		aDice1.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice1);
		aDice1.setVisible(false);

		aDice2 = new JLabel("",face2,JLabel.CENTER);//Create label of the face two of the first dice, displays the image face2
		aDice2.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice2);
		aDice2.setVisible(false);//Make it not visible until it is called

		
		aDice3 = new JLabel("",face3,JLabel.CENTER);//Create label of the face three of the first dice, displays the image face3
		aDice3.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice3);
		aDice3.setVisible(false);//Make it not visible until it is called

		aDice4 = new JLabel("",face4,JLabel.CENTER);//Create label of the face four of the first dice, displays the image face4
		aDice4.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice4);
		aDice4.setVisible(false);//Make it not visible until it is called

		aDice5 = new JLabel("",face5,JLabel.CENTER);//Create label of the face five of the first dice, displays the image face5
		aDice5.setBounds(280, 268, 141, 221);
		aDice5.setVisible(false);//Make it not visible until it is called

		aDice6 = new JLabel("",face6,JLabel.CENTER);//Create label of the face six of the first dice, displays the image face6
		aDice6.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(aDice6);
		aDice6.setVisible(false);//Make it not visible until it is called
		
		bDice1 = new JLabel("",face1,JLabel.CENTER);//Create label of the face one of the second dice, displays the image face1
		bDice1.setBounds(280, 268, 141, 221);
		frame.getContentPane().add(bDice1);
		bDice1.setVisible(false);//Make it not visible until it is called
		
		bDice2 = new JLabel("",face2,JLabel.CENTER);//Create label of the face two of the second dice, displays the image face2
		bDice2.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice2);
		bDice2.setVisible(false);//Make it not visible until it is called
		
		bDice3 = new JLabel("",face3,JLabel.CENTER);//Create label of the face three of the second dice, displays the image face3
		bDice3.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice3);
		bDice3.setVisible(false);//Make it not visible until it is called
		
		bDice4 = new JLabel("",face4,JLabel.CENTER);//Create label of the face four of the second dice, displays the image face4
		bDice4.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice4);
		bDice4.setVisible(false);//Make it not visible until it is called
		
		bDice5 = new JLabel("",face5,JLabel.CENTER);//Create label of the face five of the second dice, displays the image face5
		bDice5.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice5);
		bDice5.setVisible(false);//Make it not visible until it is called
		
		bDice6 = new JLabel("",face6,JLabel.CENTER);//Create label of the face six of the second dice, displays the image face6
		bDice6.setBounds(580, 268, 141, 221);
		frame.getContentPane().add(bDice6);
		bDice6.setVisible(false);//Make it not visible until it is called
		
		cDice1 = new JLabel("",face1,JLabel.CENTER);//Create label of the face one of the third dice, displays the image face1
		cDice1.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice1);
		cDice1.setVisible(false);//Make it not visible until it is called
		
		cDice2 = new JLabel("",face2,JLabel.CENTER);//Create label of the face two of the third dice, displays the image face2
		cDice2.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice2);
		cDice2.setVisible(false);//Make it not visible until it is called
		
		cDice3 = new JLabel("",face3,JLabel.CENTER);//Create label of the face three of the third dice, displays the image face3
		cDice3.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice3);
		cDice3.setVisible(false);//Make it not visible until it is called
		
		cDice4 = new JLabel("",face4,JLabel.CENTER);//Create label of the face four of the third dice, displays the image face4
		cDice4.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice4);
		cDice4.setVisible(false);//Make it not visible until it is called
		
		cDice5 = new JLabel("",face5,JLabel.CENTER);//Create label of the face five of the third dice, displays the image face5
		cDice5.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice5);
		cDice5.setVisible(false);//Make it not visible until it is called
		
		cDice6 = new JLabel("",face6,JLabel.CENTER);//Create label of the face six of the third dice, displays the image face6
		cDice6.setBounds(880, 268, 141, 221);
		frame.getContentPane().add(cDice6);
		cDice6.setVisible(false);//Make it not visible until it is called

		lblBalanceP2 = new JLabel("Balance: ");//Initiate the Balance indicator
		lblBalanceP2.setForeground(Color.WHITE);
		lblBalanceP2.setBounds(12, 247, 158, 17);
		frame.getContentPane().add(lblBalanceP2);
		
		lblBalanceP3 = new JLabel("Balance:");//Initiate the Balance indicator
		lblBalanceP3.setForeground(Color.WHITE);
		lblBalanceP3.setBounds(357, 125, 151, 17);
		frame.getContentPane().add(lblBalanceP3);
		
		lblBalanceP4 = new JLabel("Balance:");//Initiate the Balance indicator
		lblBalanceP4.setForeground(Color.WHITE);
		lblBalanceP4.setBounds(1043, 247, 158, 17);
		frame.getContentPane().add(lblBalanceP4);
		
		lblBalanceP1 = new JLabel("Balance: ");//Initiate the Balance indicator
		lblBalanceP1.setForeground(Color.WHITE);
		lblBalanceP1.setBounds(185, 635, 158, 17);
		frame.getContentPane().add(lblBalanceP1);
		
		
		

		
		
		background = new JLabel("",backGround,JLabel.CENTER);//Set the background image
		background.setBackground(Color.BLACK);
		background.setBounds(0,0, 1280,720);
		frame.getContentPane().add(background);
		
		disPlayBalance();//Call displayBalance menu to display the balance
		

	}
	
	
	
	/** Description: Display the balance, name and bets of the players
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 * 
	 * 
	 * 
	 */
	private void disPlayBalance(){
		/*The playerindex here moves with the player class's index
		The playerindex will return the position that the players are first in, this allows them to display
		the players in the same place.
		*/
		
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
	
	/** Description:  Rotate and cycles the banker
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 *
	 * 
	 * 
	 */
	public void moveBank(){
		/*
		 Moves the bank in cycle
		 */
		this.bankIndex++;
		if (bankIndex > 4) { //resets the index when it reaches 4
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

	/** Description: Displays the dice faces according to roll
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 * 
	 * 
	 * @param int playerIndex
	 */
	public void displayDice(int playerIndex){
		/*
		 * Displays each case of the roll
		 * 
		 */
		
		ArrayList<Integer> roll = players[playerIndex].getRoll();
		
		System.out.println("This is: "+roll.get(0)+roll.get(1)+roll.get(2));	
		//For the first dice
		if (roll.get(0) == 1) {
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice1.setVisible(true);//Only set face1 visible and all the other invisible

		
			
		} else if (roll.get(0) == 2) {
			aDice1.setVisible(false);
			aDice3.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice2.setVisible(true);//Only set face2 visible and all the other invisible

		

		} else if (roll.get(0) ==3) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice3.setVisible(true);//Only set face3 visible and all the other invisible

		

		} else if (roll.get(0) ==4) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice5.setVisible(false);
			aDice6.setVisible(false);
			aDice4.setVisible(true);//Only set face4 visible and all the other invisible

		

		} else if (roll.get(0) ==5) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice6.setVisible(false);
			aDice4.setVisible(false);
			aDice5.setVisible(true);//Only set face5 visible and all the other invisible
			
		} else if (roll.get(0) ==6) {
			aDice1.setVisible(false);
			aDice2.setVisible(false);
			aDice3.setVisible(false);
			aDice5.setVisible(false);
			aDice4.setVisible(false);
			aDice6.setVisible(true);//Only set face6 visible and all the other invisible
			
		} 
		//For the second dice
		if (roll.get(1) == 1) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice1.setVisible(true);//Only set face1 visible and all the other invisible
			

		} else if (roll.get(1) == 2) {
			bDice6.setVisible(false);
			bDice1.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice2.setVisible(true);//Only set face2 visible and all the other invisible
			

		} else if (roll.get(1) ==3) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice1.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice3.setVisible(true);//Only set face3 visible and all the other invisible
			
			

		} else if (roll.get(1) ==4) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice1.setVisible(false);
			bDice4.setVisible(true);//Only set face4 visible and all the other invisible
			
			
			
			
			

		} else if (roll.get(1) ==5) {
			bDice6.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice1.setVisible(false);
			bDice4.setVisible(false);
			bDice5.setVisible(true);//Only set face5 visible and all the other invisible
			
		} else if (roll.get(1) ==6) {
			bDice1.setVisible(false);
			bDice2.setVisible(false);
			bDice3.setVisible(false);
			bDice5.setVisible(false);
			bDice4.setVisible(false);
			bDice6.setVisible(true);//Only set face6 visible and all the other invisible
			
		} 
		//For the third dice
		if (roll.get(2) == 1) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice1.setVisible(true);//Only set face1 visible and all the other invisible
			
			

		} else if (roll.get(2) == 2) {
			cDice6.setVisible(false);
			cDice1.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice2.setVisible(true);//Only set face2 visible and all the other invisible
			
			

		} else if (roll.get(2) ==3) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice1.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice3.setVisible(true);//Only set face3 visible and all the other invisible
			

		} else if (roll.get(2) ==4) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice1.setVisible(false);
			cDice4.setVisible(true);//Only set face4 visible and all the other invisible
			

		} else if (roll.get(2) ==5) {
			cDice6.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice1.setVisible(false);
			cDice4.setVisible(false);
			cDice5.setVisible(true);//Only set face5 visible and all the other invisible
			
			

		} else if (roll.get(2) ==6) {
			cDice1.setVisible(false);
			cDice2.setVisible(false);
			cDice3.setVisible(false);
			cDice5.setVisible(false);
			cDice4.setVisible(false);
			cDice6.setVisible(true);//Only set face6 visible and all the other invisible
			
			

		} 
		SwingUtilities.updateComponentTreeUI(frame);
		frame.setVisible(true);
		
	}

	/** Description: Action performed button
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 * 
	 * 
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			//If the roll button is clicked:
			if (players[0].getBalance() < 0 || players[1].getBalance() < 0 || players[2].getBalance() < 0 || players[3].getBalance() < 0) {
				JOptionPane.showMessageDialog(null,"Game has ended! Someone lost all their money! ):","Game Ended!",JOptionPane.YES_OPTION);
				frame.dispose();//To check if there are negative balances in which case the game ends.
				LaunchPage home = new LaunchPage();//And we go back to home page
			}
			disPlayBalance();//Display balance
			try {//Try catch
				if (theBet > players[playerIndex[3]].getBalance()) {//If the bet is larger than the balance
					JOptionPane.showMessageDialog(null,"Your bet is invalid!","Invalid Bet",JOptionPane.YES_OPTION);
					playerBet.setText("0");
				} else {//If passes startgame with the bet and display new balance and move the banker to the next player
					startGame(theBet, playerIndex[3]);
					disPlayBalance();
					moveBank();
				}
				if (players[0].getBalance() < 0 || players[1].getBalance() < 0 || players[2].getBalance() < 0 || players[3].getBalance() < 0) {
					JOptionPane.showMessageDialog(null,"Game has ended! Someone lost all their money! ):","Game Ended!",JOptionPane.YES_OPTION);
					frame.dispose();//Checks if any of the players lost all their money
					LaunchPage home = new LaunchPage();//If so go back to home page game ended
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource()==btnHome) {//Check if the home button is clicked
			LaunchPage home = new LaunchPage();//If so go back to home page
			frame.dispose();
		} else if (e.getSource()==btnBet) {//Check if the bet button is clicked
			try {//Try catch
				theBet = Integer.parseInt(playerBet.getText());//Get the amount entered by the player in the bet text box
				if (theBet > players[playerIndex[3]].getBalance()) {//Check if the bet is valid
					JOptionPane.showMessageDialog(null,"Your bet is invalid!","Invalid Bet",JOptionPane.YES_OPTION);
					playerBet.setText("0");
					theBet = 0;
				} else {//If the bet is valid take the bet into the game
					theBet = Integer.parseInt(playerBet.getText());
				}
				System.out.println(theBet);
			} catch (Exception e2) {}
			
		}
		
	}	
	/** Description: Starts the game
	 * @author: Kevin Ren, Nam Pham
	 * @since: 12/2/2023
	 * 
	 * 
	 * 
	 * @param double playerBet, int playerIndex
	 */
		public void startGame(double playerBet, int playerIndex) throws InterruptedException {
			Random rand = new Random();
			players[playerIndex].setBet(playerBet);
			//Assign the balance to each player
			if (players[0].getBalance() > 0 && 
				players[1].getBalance() > 0 && 
				players[2].getBalance() > 0 && 
				players[3].getBalance() > 0) {
					for (int i = 0; i < 4; i++) {
						if (i != playerIndex) {
							players[i].setBet(rand.nextInt((int) (players[i].getBalance()*0.5)));//Create the bet for computer players
						}
					}
					disPlayBalance();//display the balance
				}
			do {
				round();//start the round
				/*
				 * For each round we move the player in cycle
				 * the first player in the players array is always the banker
				 * he then most to the last place of the array
				 * the next player takes his place in the array and becomes the banker
				 */
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
				
			} while (//Loop until someone loses their money
					players[0].getBalance() > 0 && 
					players[1].getBalance() > 0 && 
					players[2].getBalance() > 0 && 
					players[3].getBalance() > 0 &&
					continueGame
					);
			
		}
		
		/** Description: getPlayerBalance from Player class
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 */
		
		public double getPlayerBalance(int playerIndex) {
			return players[playerIndex].getBalance();//return player's balance
		}
		
		/** Description: Get the player's name from the player class
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 */
		public String getPlayerName(int playerIndex) {
			return players[playerIndex].getName();//returns player name
		}
		
		/** Description: Get the player's bet from the player class
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 */
		public double getPlayerBet(int playerIndex) {
			return players[playerIndex].getBet();//returns player bet
		}
		
		/** Description: Returns roundEnd
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @return roundEnd
		 */
		public boolean getRoundEnd() {
			return roundEnd;//returns roundEnd
		}
		/** Description: Returns continueRoll
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * @return continueRoll
		 */
		public boolean getContinueRoll() {
			return continueRoll;//returns continueRoll
		}
		/** Description: Set continue game
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param boolean cont
		 */
		public void setContinueGame(boolean cont) {
			continueGame = cont;//assign contineeGame with cont
		}
		
		/** Description: Set Continue roll
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param boolean cont
		 */
		public void setContinueRoll(boolean cont) {
			continueRoll = cont;//assign continueRoll with cont
		}
		
		/** Description: Play out a round
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 */
		private void round() {
			/*
			 * Start the round
			 * compares who loses and wins
			 * takes the bet away from losing players and into the winning player balance
			 */
			for (int i = 0; i < 4; i++) {
				players[i].roll();
			}
			roundRoll(0);
			displayDice(playerIndex[3]);
			disPlayBalance();
			//Banker
			if (scores[0] == 0 || scores[0] == 10 || scores[0] == 12 || scores[0] == 13 || scores[0] == 1) {//Checks instant losing condition
				for (int i = 1; i < 4; i++) {//Take away their money and give it to the winner
					players[0].withdraw(players[i].getBet());
					players[i].deposit(players[i].getBet());
				}
			} else if (scores[0] == 7 || scores[0] == 8 || scores[0] == 9 || scores[0] == 6) {//Checks instant winning condition
				for (int i = 1; i < 4; i++) {//Take away their money and give it to the winner
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
					
				if (scores[3] == 13) {//Checks for score conditions
					scores[3] = 4;//Assign them to a value to be used to check winning condition
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
			compareScore(1);//Compare all the rolls
			compareScore(2);
			compareScore(3);
			}
			for (int i = 0; i < 4; i++) {
				System.out.println(players[i].toString() + "\nScore: " + scores[i] + "\n");
			}
		}
		
		/** Description: Compares the score of each player
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 */
		private void compareScore(int playerIndex) {//Compare the socre (winning conditions)
			
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
		
		/** Description: Get the score of players
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 * @return score
		 */
		
		private int getScore(Player player) {//Get the scores of layers
			int score;
			ArrayList<Integer> roll = player.getRoll();//Check for how much scores players are getting from the dice roll
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
		
		/** Description: Rolls all the dice for ths round
		 * @author: Kevin Ren, Nam Pham
		 * @since: 12/2/2023
		 * 
		 * 
		 * 
		 * @param int playerIndex
		 */
		
		private void roundRoll(int playerIndex) { //Roll for each player
			int tries = 0;//Each players get three tries if rolled zero points
			do {
				scores[playerIndex] = getScore(players[playerIndex]);
				if (scores[playerIndex] == 0) {
					players[playerIndex].roll();
					tries++;
				}
			} while (scores[playerIndex] == 0 && tries != 3);//Each players get three tries per roll, if it doesnt exceeds three tries and points is not zero
			scores[playerIndex] = getScore(players[playerIndex]);
		}
}
