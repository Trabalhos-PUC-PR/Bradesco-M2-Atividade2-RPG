package entity;

import java.util.Random;
import interfaces.Rollable;

public class DiceRoll implements Rollable {

	private static Random random;

	private int dices;
	private int faces;
	private int bonus;

	public DiceRoll() {
		random = new Random();
		dices = 1;
		faces = 20;
		bonus = 0;
	}
	
	public DiceRoll(int faces) {
		random = new Random();
		this.dices = 1;
		this.faces = faces;
		this.bonus = 0;
	}
	
	public DiceRoll(int dices, int faces) {
		random = new Random();
		this.dices = dices;
		this.faces = faces;
		this.bonus = 0;
	}
	
	public DiceRoll(int dices, int faces, int bonus) {
		random = new Random();
		this.dices = dices;
		this.faces = faces;
		this.bonus = bonus;
	}

//	public static Random getRandom() {
//		return random;
//	}

	public int getDices() {
		return dices;
	}

	public int getFaces() {
		return faces;
	}

	public int getBonus() {
		return bonus;
	}

	public int roll() {
		int totalSum = 0;
		for (int i = 0; i < dices; i++) {
			int roll = random.nextInt(faces) + 1;
			totalSum += roll;
		}
		totalSum += bonus;

		return totalSum;
	}

	@Override
	public String toString() {
		return dices + "D" + faces + ((bonus != 0) ? ((bonus>0)?"+"+bonus:bonus) : "");
	}

}
