import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {	
	
	private Player[] players = new Player[4];
	private int[] scores = new int[4];
	private boolean roundEnd, continueRoll, continueGame;

	public Game(String userName, double userBalance) {
		Random rand = new Random();
		players[0] = new Player(userName, userBalance);
		players[1] = new Player("Jenny", rand.nextInt((int) (userBalance))+userBalance*.5);
		players[2] = new Player("Henry", rand.nextInt((int) (userBalance))+userBalance*.5);
		players[3] = new Player("Sean", rand.nextInt((int) (userBalance))+userBalance*.5);
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
			}
		do {
			roundEnd = false;
			round();
			roundEnd = true;
			Player temp = players[0];
			for (int i = 0; i < 3 ; i++) {
				players[i] = players[i+1];
			}
			players[3] = temp;
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
			roundRoll(1);
			roundRoll(2);
			roundRoll(3);
				
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
