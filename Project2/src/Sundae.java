/**
 * Sundae
 * 
 * A child class of Icecream with an extra parameter for topping cost.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 */
public class Sundae extends Icecream {
	private float toppingCost;
	
	public Sundae(){
		super("Unknown sundae", 0, 1f);
		this.toppingCost = 1f;
	}
	
	public Sundae(String name, int calories, float cost, float toppingCost) {
		super(name, calories, cost);
		this.toppingCost = toppingCost;
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public float getCost() {
		return toppingCost + super.getCost();
	}
	
	/**
	 *{@inheritDoc}
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
