package ProjectClasses;

/**
 * Represents a stack of a single type of coin.
 * Stores the value of the coin, the name of the coin, and the number of coins in the stack.
 * Contains a method that returns the total value of the stack.
 * @author Alexander Dung
 *
 */
public interface Coin {

	
	/**
	 * Compares equality of this coin and another coin.
	 * @param c The coin being compare to
	 * @return True if the two coins are equal else false.
	 */
	double getValue();
	String getName();
	String toString();
	

}

