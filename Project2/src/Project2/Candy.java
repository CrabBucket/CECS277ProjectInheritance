package Project2;
/**
 * Candy
 * 
 * A child class of DessertItem with extra parameters for weight in pounds and product price per pound.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 */
public class Candy extends DessertItem {
	private float weight;
	private float priceDensity;
	
	public Candy(){
		super("Unknown candy", 0);
		this.weight = 1f;
		this.priceDensity = 1f;
	}
	public Candy(String name, int calories, float weight, float priceDensity) {
		super(name,calories);
		this.weight = weight;
		this.priceDensity = priceDensity;
	}
	
	/**
	 * Returns information about the object in the form of a String.
	 * String is formatted to fit a "receipt" that is 30 characters wide.
	 */
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%.2f lbs. @ %.2f /lb.%n", this.weight, this.priceDensity);
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
		return weight * priceDensity;
	}

	@Override
	public int getCalories() {
		return Math.round(calories*weight);
	}

	public static void main(String[] args) {
		Candy candy = new Candy("something taffy", 210, 1.5f, 2.00f);
		System.out.println(candy);
	}
}
