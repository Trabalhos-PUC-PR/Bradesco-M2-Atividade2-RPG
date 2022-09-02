package items;

import entity.DiceRoll;

public class Potion {

	private int restaurativePower;
	private DiceRoll totalRestored;
	
	public Potion() {
		this.restaurativePower = 10;
		this.totalRestored = new DiceRoll(1, 6);
	}
	
	public boolean isEmpty() {
		return restaurativePower==0;
	}
	
	public int chug() {
		int chugSize = totalRestored.roll();
		if(chugSize >= restaurativePower) {
			chugSize = restaurativePower;
			restaurativePower = 0;
		} else {
			restaurativePower -= chugSize;
		}
		return chugSize;
	}
	
}
