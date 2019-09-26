/**
 * Cookie
 * 
 * A child class of DessertItem with an extra parameter for number and price per dozen.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 */
public class Cookie extends DessertItem {
	private int number;
	private float pricePer;
	
	public Cookie(){
		super("Unknown cookie", 0);
		this.number = 1;
		this.pricePer = 1f;
	}
	/**
	 * 
	 *{@inheritDoc}
	 *@param number number of cookies to buy
	 *@param pricePer price per dozen of cookies
	 */
	public Cookie(String name, int calories, int number, float pricePer) {
		super(name, calories);
		this.number = number;
		this.pricePer = pricePer;
	}
		
	/**
	 * Returns information about the object in the form of a String.
	 * String is formatted to fit a "receipt" that is 30 characters wide.
	 */
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%d @ %.2f /dz.%n", this.number, this.pricePer);
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
		return pricePer * number / 12;
	}

	@Override
	public int getCalories() {
		return calories * number / 12;
	}

	
	public static void main(String[] args) {
		Cookie cookie = new Cookie("123451234512345123451234", 10, 1, 2.1f);
		Cookie cookie2 = new Cookie("Cookie Cookie Cookie Cookie Cookie Cookie Cookie Cookie Cookie Cookie ", 10, 1, 2.1f);
		System.out.println(cookie);
		System.out.println(cookie2);
		System.out.println("123456789 123456789 123456789 ");
		System.out.println("12345\n".length());
	}

}
