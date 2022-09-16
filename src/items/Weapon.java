package items;

import entity.DiceRoll;
import interfaces.Rollable;

public class Weapon {

	private String name;
	private Rollable damage;
	public static final Weapon FISTS = new Weapon("Bare Hands", new DiceRoll(0, 1, 1));

	public Weapon(String name, Rollable damage) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("A name must be provided!");
		}
		this.name = name;
		if (damage == null) {
			throw new IllegalArgumentException("Damage cannot be null!");
		}
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public Rollable getDamage() {
		return damage;
	}

	public int roll() {
		return damage.roll();
	}

	@Override
	public String toString() {
		return String.format("%s (%d)", name, roll());
	}

}
