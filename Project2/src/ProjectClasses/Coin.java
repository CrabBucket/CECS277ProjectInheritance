package ProjectClasses;

/**
 * Coin interface that goes between all the coins
 * Requires you to have a getValue() getName() and toString() to be a coin
 *
 */
public interface Coin {

	
	/**
	 * returns the monetary value of the coin
	 * @return returns the value as a double
	 */
	double getValue();
	/**
	 * returns the name of the coin
	 * @return Name of coin
	 */
	String getName();
	/**
	 * String representation of coin
	 * @return A coin
	 */
	String toString();
	

}

