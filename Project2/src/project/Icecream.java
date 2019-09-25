public class Icecream extends DessertItem {
	private float cost;
	
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

	@Override
	public DessertItem max(DessertItem item) {
		return null;
	}
	
	public static void main(String[] args) {
		Icecream thing = new Icecream("12345 12345 12345 12345 12345 ", 210, 10.5f);
		System.out.println(thing);
	}

}
