import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String name;
	private double balance;
	private double bet;
	
	public ArrayList<Integer> roll = new ArrayList<Integer>() {
		{
			add(0);
			add(0);
			add(0);
		}
	};
	
	
	public void roll() {
		Random rand = new Random();
		for (int i = 0; i < roll.size(); i++) {
			roll.set(i, rand.nextInt(6) + 1);
		}
		sort(roll.size());
	}
	
	private void sort(int n) 
    {
		if (n == 1) return;
		int count = 0; 
		for (int i = 0; i < n - 1; i++) {
			if (roll.get(i) > roll.get(i + 1)) {
				int temp = roll.get(i);
				roll.set(i, i + 1);
				roll.set(i + 1, temp);
				count++; 
            }
		}
		if (count == 0) return;
        sort(n - 1); 
    }
}

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