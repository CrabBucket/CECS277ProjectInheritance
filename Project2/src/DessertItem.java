/**
 * Dessert Item
 * 
 * A dessert item with methods for comparison between them.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 */
public abstract class DessertItem implements Comparable<DessertItem> {
	protected String name;
	protected int calories;
	/**
	 * Default consructor
	 */
	public DessertItem() {
		this.name = "";
		this.calories = -0;
	}
	
	/**
	 * Dessert Item
	 * 
	 * @param  name Name of the item
	 * @param calories Amount of calories per item or weight or dozen depending on the child.
	 */
	public DessertItem(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	
	/**
	 * Gets the total cost of the DessertItem
	 * @return An Integer that represents the total cost of the item in cents.
	 */
	public abstract float getCost();
	
	/**
	 * Gets the total calories of the DessertItem
	 * @return An Integer that represents the total calories of the item.
	 */
	public abstract int getCalories();
	
	/**
	 * Returns the most expensive of two objects. If they cost the same it returns the first.
	 * @param item1 First object to be compared
	 * @param item2 Second object to be compared
	 * @return  The object that costs more.
	 */
	public static DessertItem max(DessertItem item1,DessertItem item2) {
		if(item1.compareTo(item2) >= 1) {
			return item1;
		}
		else {
			return item2;
		}
	}
	
	/**
	 * Gets the name of the dessert item.
	 * @return A string that contains the dessert name.
	 */
	public final String getName() {
		return name;
	}
		
	/**
	 * Returns -1,0,1 depending if the the total cost of this object is less than, equal to, or greater than DessertItem d.
	 * @param d Dessert Item we are comparing to.
	 * @return -1,0,1 depending on if this DessertItem is &lt;,=,&gt; DessertItem d
	 */
	public int compareTo(DessertItem d) {
		if(this.getCost() < d.getCost()) {
			return -1;
		}
		else if(this.getCost() > d.getCost()) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
}
