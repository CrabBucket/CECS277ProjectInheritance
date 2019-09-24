package project;

public class Sundae extends Icecream {
	private float toppingCost;
	public Sundae(String name, int calories, float cost,float toppingCost) {
		super(name, calories, cost);
		this.toppingCost = toppingCost;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * 
	 * This might get stuck in a loop im not sure.
	 * 
	 */
	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return toppingCost+getCost();
	}
	
	@Override
	public String toString() {
		return "";
	}

}
