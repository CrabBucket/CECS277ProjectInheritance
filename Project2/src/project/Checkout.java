package project;

import java.util.ArrayList;

public class Checkout {
	public ArrayList<DessertItem> itemList;
	public float taxRate;
	
	public Checkout(float taxRate) {
		this.taxRate = taxRate;
	}
	
	public void clear() {
		itemList = new ArrayList<DessertItem>();
	}
	
	public void enterItem(DessertItem item) {
		itemList.add(item);
	}
	
	public int numberOfItems() {
		return itemList.size();
	}
	
	public String toString() {
		return "";
	}
	
	public int totalCost() {
		float sum = 0;
		for(DessertItem d : itemList) {
			sum+=d.getCost();
		}
		return Math.round(sum);
	}
	
	public int totalTax() {
		return 0;
	}
	
	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
}
