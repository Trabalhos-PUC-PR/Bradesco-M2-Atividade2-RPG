package entity;

import java.util.Random;

import items.Potion;
import items.Weapon;

public class Char {

	private static Random random;

	private String name;
	private int skill;
	private int defense;
	private int life;
	private int InitialLife;
	private Weapon weapon;
	private Potion potion;

	public Char(String name, int skill, int defense, int life) {
		random = new Random();
		this.name = name;
		this.skill = skill;
		this.defense = defense;
		this.life = life;
		this.InitialLife = life;
	}

	private void addPotion() {
		this.potion = new Potion();
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
		if(weapon == null) {
			this.weapon = Weapon.FISTS;
			return;
		}
		this.weapon = weapon;
	}

	public boolean isAlive() {
		return life > 0;
	}

	public static Char goblinFactory() {
		String[] names = {"Glitz", "Gobutta", "Gobrob", "Robson"};
		String[] titles = {", the big", " the ogre", ", the stupid", " the mastermind"};
		
		String name = names[random.nextInt(names.length)] + titles[random.nextInt(titles.length)];
		int skill = 10+random.nextInt(6);
		int defense = 3+random.nextInt(8);
		int life = 30+random.nextInt(21);
		
		Char aux = new Char(name, skill, defense, life);
		aux.addPotion();
		return aux;
	}
	
	public boolean isDying() {
		return (life <= 2) || (life <= InitialLife*.25);
	}
	
	public boolean hasPotion() {
		return potion !=null;
	}
	
	public void heal() {
		if(potion == null) {
			return;
		}
		if(potion.isEmpty()) {
			System.out.printf("And as %s sticks his hand to help himself to a good chug of healing potion, the flask was empty!\n", name);
			System.out.printf("so %s discarts his empty flask!\n", name);
			potion = null;
		} else {
			int heal = potion.chug();
			System.out.printf("%s drinks the HEALING POTION, and recovers %d health points\n", name, heal);
			life+=heal;
		}
	}
	
	public void attack(Char target) {
		DiceRoll dice = new DiceRoll(3, 6);
		int roll = dice.roll();
		int goal = skill - target.getDefense();
		if (roll <= goal) {
			String weaponName = weapon != null ? weapon.getName() : "Bare Hands";
			
			int damage = weaponName=="Bare Hands" ? 1 : weapon.roll();
			target.takeDamage(damage);
			
			System.out.printf("%s attacks %s with his %s (%d atk) %s's Life: %d\n", name, target.getName(), weaponName, damage,
					target.getName(), target.getLife());
		} else {
			System.out.printf("%s misses his attack!\n", name, target.getName());
		}
	}

	private void takeDamage(int value) {
		life -= value;
		if (life < 0) {
			life = 0;
		}
	}

}
