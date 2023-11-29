import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String name;
	private double balance;
	private double bet;
	StringBuilder ScoreBoard = new StringBuilder();
	
	public Player () {
		this("",1000);
	}
	public Player(String name,int balance) {
		this.balance = balance;
		this.name = name;
		
	}
	
	public ArrayList<Integer> roll = new ArrayList<Integer>() {
		{
			add(0);
			add(0);
			add(0);
		}
	};
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
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
