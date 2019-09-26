/**
 * Ice Cream
 * 
 * A child class of DessertItem with an extra parameter for cost.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 */
public class Icecream extends DessertItem {
	private float cost;
	
	public Icecream(){
		super("Unknown ice cream", 0);
		this.cost = 1f;
	}
	
	public Icecream(String name, int calories, float cost) {
		super(name, calories);
		this.cost = cost;
	}

	/**
	 * Returns information about the object in the form of a String.
	 * String is formatted to fit a "receipt" that is 30 characters wide.
	 */
	@Override
	public String toString() {
		String toReturn = "";
		String itemName = this.name;
		if(itemName.length() > 24) {
			String newName = "";
			int linesRequired = itemName.length()/24;
			for(int lines = 0; lines < linesRequired; lines++) {
				newName += itemName.substring(24 * lines, 24 * (lines + 1)) + "\n";
			}
			newName += itemName.substring(24 * linesRequired);
			itemName = newName;
			int extraChars = 30 - itemName.length() % 25;
			toReturn += String.format("%-25s %" + extraChars + ".2f", itemName, this.getCost());
		}
		else {
			toReturn += String.format("%-25s %5.2f", itemName, this.getCost());
		}
		return toReturn;
	}

	@Override
	public float getCost() {
		return cost;
	}

	@Override
	public int getCalories() {
		return calories;
	}
	
	public static void main(String[] args) {
		Icecream thing = new Icecream("12345 12345 12345 12345 12345 ", 210, 10.5f);
		System.out.println(thing);
	}

}
