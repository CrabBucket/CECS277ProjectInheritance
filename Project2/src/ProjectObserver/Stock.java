package ProjectObserver;

import java.util.Observable;

public class Stock extends Observable{
	private String stockName;
	
	public Stock() {
		this.stockName = "UNKNOWN";
	}
	
	public Stock(String name) {
		this.stockName = name;
	}
	
	public String getName() {
		return this.stockName;
	}
	
	public void updateStock() {
		this.setChanged();
	}
	
	public String toString() {
		return "Stock: " + this.stockName;
	}
}
