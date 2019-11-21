package ProjectObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents a stock trader that can follow certain stocks.
 * Implements Java standard library's Observer class for use with the Stock class.
 * @author Alexander Dung
 *
 */
public class Trader implements Observer{
	private String name;
	
	
	/**
	 * Default constructor, sets all values to reflect a "default" trader.
	 */
	public Trader() {
		this.name = "Unknown Trader";
	}
	
	/**
	 * Sets Trader name, to the argument.
	 * @param traderName name to give this Trader
	 */
	public Trader(String traderName) {
		this.name = traderName;
	}
	
	/**
	 * Gets this Trader's name and returns it as a String.
	 * @return String this Trader's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets this Trader's name to the argument String.
	 * @param newName the new name to give this Trader
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void update(Observable stock, Object arg) {
		System.out.printf("%n%s has received a notification: %n    %s", this.name, (Trade) arg);
	}
}
