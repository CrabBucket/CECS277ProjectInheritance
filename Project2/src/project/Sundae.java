public class Sundae extends Icecream {
	private float toppingCost;
	
	public Sundae(String name, int calories, float cost, float toppingCost) {
		super(name, calories, cost);
		this.toppingCost = toppingCost;
	}
	
	/**
	 *
	 */
	@Override
	public float getCost() {
		return toppingCost + super.getCost();
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sundae thing = new Sundae("sundae thing", 210, 15.001f, 1.00f);
		System.out.println(thing + "\n" + thing.getCost());
	}

}
