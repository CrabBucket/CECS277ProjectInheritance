package ProjectObserver;

import java.util.Observable;

/**
 * Represents stock for a company that can be traded for.
 * Extends the Java standard library's Observable interface for use with Traders.
 * @author Alexander Dung
 *
 */
public class Stock extends Observable{
	private String stockName;
	
	/**
	 * Default constructor, initializes this Stock's name to UNKNOWN.
	 */
	public Stock() {
		this.stockName = "UNKNOWN";
	}
	
	/**
	 * Constructor that initializes this Stock's name to the argument.
	 * @param name to set the Stock's name to
	 */
	public Stock(String name) {
		this.stockName = name;
	}
	
	/**
	 * Gets this stock's name and returns it.
	 * @return String this stock's name
	 */
	public String getName() {
		return this.stockName;
	}
	
	/**
	 * Sets this Stock's inherited hasChanged() so that notifyObservers() can be called.
	 */
	public void updateStock() {
		this.setChanged();
	}
	
	public String toString() {
		return "Stock: " + this.stockName;
	}
}
