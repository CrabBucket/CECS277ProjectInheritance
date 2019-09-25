/**
 * <h1>Dessert Item</h1>
 * A dessert item with methods for comparison between them.
 * 
 * @author Thomas McSwain
 * @version 1.0
 * @since 2019-09-24
 * 
 */
public abstract class DessertItem implements Comparable<DessertItem> {
	protected String name;
	protected int calories;
	
	/**
	 * Gets the total cost of the DessertItem
	 * @return An Integer that represents the total cost of the item.
	 */
	public abstract float getCost();
	
	/**
	 * Gets the total calories of the DessertItem
	 * @return An Integer that represents the total calories of the item.
	 */
	public abstract int getCalories();
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public abstract DessertItem max(DessertItem item);
	
	/**
	 * Default constructor that instantiates nonsense values for name and calories.
	 */
	public DessertItem(String name,int calories) {
		this.name = name;
		this.calories = calories;
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
	 * @param Dessert Item we are comparing to.
	 * @return -1,0,1 depending on if this DessertItem is <,=,> DessertItem d
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
