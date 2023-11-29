
public class Player {


	
	private int score;
	private int balance;
	private String name;
	StringBuilder ScoreBoard;
		
	
	public Player () {
		score = 0;
		balance = 1000;
		name = "";
		ScoreBoard = new StringBuilder();
	}
	
	
	public Player(String Name,int Balance) {
		score = 0;
		balance = Balance;
		name = Name;
		
	}
	
	public String getName() {
		return name;
		
	}
	
	public int getScore() {
		return score;
	}	
	
	public int getBalance() {
		return balance;
		
	}
	

	


}
