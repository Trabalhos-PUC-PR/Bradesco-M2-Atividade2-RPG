package entity;

import java.util.Random;

import items.Weapon;

public class Char {

	private static Random random;

	private String name;
	private int skill;
	private int defense;
	private int life;
	private Weapon weapon;

	public Char(String name, int skill, int defense, int life) {
		random = new Random();
		this.name = name;
		this.skill = skill;
		this.defense = defense;
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public int getSkill() {
		return skill;
	}

	public int getDefense() {
		return defense;
	}

	public int getLife() {
		return life;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public boolean isAlive() {
		return life > 0;
	}

	public static Char goblinFactory() {
		String[] names = {"Glitz", "Gobutta", "Gobrob", "Robson"};
		String[] titles = {", the best there is", " born to fight", ", he who talks too much", " the mastermind"};
		
		String name = names[random.nextInt(names.length)] + titles[random.nextInt(titles.length)];
		int skill = 10+random.nextInt(6);
		int defense = 3+random.nextInt(8);
		int life = 30+random.nextInt(21);
		
		return new Char(name, skill, defense, life);
	}
	
	public void attack(Char target) {
		// temos 3D6's aqui
		DiceRoll dice = new DiceRoll(3, 6);
		int roll = dice.roll();
		int goal = skill - target.getDefense();
		if (roll <= goal) {

			String weaponName = weapon != null ? weapon.getName() : "Bare Hands";
			
			int damage = weaponName=="Bare Hands" ? 1 :weapon.roll();
			target.takeDamage(damage);
			
			System.out.printf("%s attacks %s with his %s, for %d damage! %s's Life: %d\n", name, target.getName(), weaponName, damage,
					target.getName(), target.getLife());
		} else {
			System.out.printf("%s tries to attack %s, but he misses!\n", name, target.getName());
		}
	}

	private void takeDamage(int value) {
		life -= value;
		if (life < 0) {
			life = 0;
		}
	}

}
