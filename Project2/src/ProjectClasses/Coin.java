package ProjectClasses;

/**
 * Represents a stack of a single type of coin.
 * Stores the value of the coin, the name of the coin, and the number of coins in the stack.
 * Contains a method that returns the total value of the stack.
 * @author Alexander Dung
 *
 */
public class Coin {
	private double value;
	private String name;
	private int amount;
	
	/**
	 * Default constructor, simple placeholder/null coin.
	 */
	public Coin() {
		this.name = "Unknown Coin";
		this.value = 0;
		this.amount = 0;
	}
	
	/**
	 * Constructor for a Coin with no given amount. Assumes amount is one.
	 * @param name to give the coin
	 * @param value of the coin
	 */
	public Coin(String name, double value) {
		this.name = name;
		this.value = value;
		this.amount = 1;
	}
	
	/**
	 * Constructor for a Coin with specified name, value, and amount.
	 * @param name of the coin
	 * @param value of the coin
	 * @param amount of coins in the stack
	 */
	public Coin(String name, double value, int amount) {
		this.name = name;
		this.value = value;
		this.amount = amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * Calculates the total value of all the Coins in this stack.
	 * @return total value calculated by the product of value and amount.
	 */
	public double calculateTotalValue() {
		return this.value * this.amount;
	}
	
	@Override
	public String toString() {
		return String.format("Stack of %s, containing %d coins valued at $%.2f each.", this.name, this.amount, this.value);
	}
	
	public static void main(String[] args) {
		Coin coiny = new Coin("coiny", 1f, 100);
		Coin coino = new Coin("coino", 10f);
		Coin un = new Coin();
		System.out.println(coiny);
		System.out.println(coino);
		System.out.println(un);
	}

}

