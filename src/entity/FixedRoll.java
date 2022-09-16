package entity;

import interfaces.Rollable;

public class FixedRoll implements Rollable{

	private int[] values;
	private int position;
	
	public FixedRoll(int ... values) {
		this.values = values;
		this.position = 0;
	}
	
	@Override
	public int roll() {
		int aux = values[position];
		position = (position+1) % values.length;
		return aux;
	}

}
