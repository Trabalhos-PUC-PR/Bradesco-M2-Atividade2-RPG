package app;

import entity.Char;
import entity.DiceRoll;
import items.Weapon;

public class Battle {

	public static void main(String[] args) {
		Char hero = new Char("Sir Gallahad", 5, 0, 10000000);
		Char monster = new Char("SCAL", 10, 0, 100000000);
//		Char monster = Char.goblinFactory();
		
		hero.setWeapon(new Weapon("Exo blade", new DiceRoll(50, 500)));
		monster.setWeapon(new Weapon("Flames of ruin", new DiceRoll(20, 100)));
		
		while(hero.isAlive() && monster.isAlive()) {
			hero.attack(monster);
			if(monster.isAlive()) {
				monster.attack(hero);	
			}
		}
		
		if(hero.isAlive()) {
			System.out.printf("%s wins!",hero.getName());
		}else {
			System.out.printf("%s wins!",monster.getName());	
		}
		
	}

}
