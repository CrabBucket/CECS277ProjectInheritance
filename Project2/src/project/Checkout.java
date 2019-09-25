import java.util.ArrayList;

public class Checkout {
	private ArrayList<DessertItem> itemList;
	private float taxRate;
	
	/**
	 * Creates a Checkout instance with an empty list of DessertItem's
	 */
	public Checkout() {
		this.itemList = new ArrayList<DessertItem>();
		this.taxRate = 7.25f;
	}
	
	/**
	 * Creates a Checkout instance with an empty list of DessertItem's, and tax rate set to the argument
	 * @param taxRate
	 */
	public Checkout(float taxRate) {
		this.itemList = new ArrayList<DessertItem>();
		this.taxRate = taxRate;
	}
	
	/**
	 * Clears the Checkout to begin checking out a new set of items
	 */
	public void clear() {
		this.itemList.clear();
	}
	
	/**
	 * A DessertItem is added to the end of the list of items
	 * @param item DessertItem to add to the list
	 */
	public void enterItem(DessertItem item) {
		this.itemList.add(item);
	}
	
	/**
	 * Returns the number of DessertItem's in the list
	 * @return size of the list of DessertItems
	 */
	public int numberOfItems() {
		return this.itemList.size();
	}
	
	/**
	 * Returns total cost of items in cents (without tax)
	 * @return total cost of items in cents (without tax)
	 */
	public int totalCost() {
		int total = 0;
		for(DessertItem item : this.itemList) {
			total += item.getCost();
		}
		return total;
	}
	
	/**
	 * Returns total tax on items in cents
	 * @return total tax on items in cents
	 */
	public int totalTax() {
		return (int) (this.totalCost() * this.taxRate / 100);
	}
	
	/**
	 * Returns tax rate for this purchase
	 * @return tax rate for this purchase
	 */
	public double getTaxRate() {
		return (double)this.taxRate;
	}
	
	/**
	 * Changes the tax rate for this purchase
	 * @param taxRate tax rate for this purchase
	 */
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	
	/**
	 * Returns a String representing a receipt for the current list of items
	 * @return a String representing a receipt for the current list of DessertItem's with
	 * the name of the Dessert store, the items purchased, the tax and the total cost
	 */
	public String toString() {
		int receiptWidth = 30;					//max width of formatted String to return
		String toPrint = "  Simple Stuff Dessert Shoppe  \n  --------------------------  \n";
		for(int listIndex = 0; listIndex < itemList.size(); listIndex++) {
			toPrint += "\n" + itemList.get(listIndex);
		}	
		toPrint += String.format("%nTax%27.2f%n%n", this.totalTax()/100f);
		toPrint += String.format("Total Cost%20.2f", this.totalCost()/100f);
		return toPrint;
	}
	public static void main(String[] args) {
		Candy candy = new Candy("candyyycandyyycandyyycandyyycandyyy", 210, 1.5f, 11.00f);
		Cookie cookie = new Cookie("coookie", 250, 1, 2.5f);
		Sundae sundae = new Sundae("sunudae", 450, 1.50f, 20f);
		Checkout checkout = new Checkout();
		checkout.enterItem(candy);
		checkout.enterItem(sundae);
		checkout.enterItem(cookie);
		System.out.println(checkout);
	}
}


