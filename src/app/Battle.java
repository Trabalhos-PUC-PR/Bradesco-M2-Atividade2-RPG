package app;

import entity.Char;
import entity.DiceRoll;
import items.Weapon;

public class Battle {

	public static void main(String[] args) {
		Char hero = new Char("Sir Gallahad", 14, 5, 80);
		Char monster = Char.goblinFactory();

		hero.setWeapon(new Weapon("Exo blade", new DiceRoll(2, 5)));
		monster.setWeapon(new Weapon("Flames of ruin", new DiceRoll(2, 3)));

		while (hero.isAlive() && monster.isAlive()) {
			if (hero.isDying() && hero.hasPotion()) {
				hero.heal();
			} else {
				hero.attack(monster);
			}
			if (monster.isAlive()) {
				if (monster.isDying() && monster.hasPotion()) {
					monster.heal();
				} else {
					monster.attack(hero);
				}
			}
		}

		if (hero.isAlive()) {
			System.out.printf("%s wins!", hero.getName());
		} else {
			System.out.printf("%s wins!", monster.getName());
		}

	}

}
