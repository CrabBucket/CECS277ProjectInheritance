package ProjectClasses;

import java.util.ArrayList;
/**
 * Represents a person that can operate a VendingMachine.
 * Contains a "purse" of stacks of Coins, and a place to hold Products.
 * Has methods to take a Product and to give Coins.
 * @author Alexander Dung
 *
 */
public class Person {
	private ArrayList<Coin> purse;
	private ArrayList<Product> held;
	private CoinFactory cf;
	/**
	 * Default constructor for a Person. Has no Coins or held products.
	 */
	public Person() {
		this.purse = new ArrayList<Coin>();
		this.held = new ArrayList<Product>();
		this.cf = new CoinFactory();
	}
	
	/**
	 * Constructor for a Person with a specified set of Coins. Assumes no Products are held.
	 * @param purse list of stacks of Coins held by Person
	 */
	public Person(ArrayList<Coin> purse) {
		this.purse = purse;
		this.held = new ArrayList<Product>();
		this.cf = new CoinFactory();
	}
	
	/**
	 * Constructor for a Person with a specified set of Coins and Products held.
	 * @param purse list of stacks of Coins held by Person
	 * @param held Products held by Person
	 */
	public Person(ArrayList<Coin> purse, ArrayList<Product> held) {
		this.purse = purse;
		this.held = held;
		this.cf = new CoinFactory();
	}
	
	/**
	 * Adds product to the Person's held items.
	 * First checks if a Product with the same name is already held. If so, increment that by argument Product's amount.
	 * If not, then adds the argument Product to held items.
	 * @param toAdd product to add to the Person's held items.
	 */
	public void takeProduct(Product toAdd) {
		boolean isAdded = false;
		for(int index = 0; index < this.held.size(); index++) {
			if(toAdd.getName().contentEquals(held.get(index).getName())) {
				for(int counter = 0; counter < toAdd.getAmount(); counter++) {
					held.get(index).incrementAmount();
				}
				isAdded = true;
				break;
			}
		}
		if(!isAdded) {
			held.add(toAdd);
		}
	}
	
	/**
	 * Searches through purse for Coin whose name matches the argument String, then decrements that Coin's amount.
	 * @param name name of the Coin to decrement
	 */
	public boolean removeCoin(String name) {
		for(Coin c:purse) {
			if(c.getName().equalsIgnoreCase(name)) {
				purse.remove(c);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Searches through purse for Coin whose name matches the argument String, then increments that Coin's amount.
	 * @param name name of the Coin to increment
	 */
	public void addCoin(String name) {
		purse.add(cf.getCoin(name));
	}
	
	public String toString() {
		String toReturn = "";
		toReturn += "Purse contains:\n";
		for(int index = 0; index < this.purse.size(); index++) {
			toReturn += purse.get(index) + "\n";
		}
		toReturn += "\nHeld products:\n";
		for(int index = 0; index < this.held.size(); index++) {
			toReturn += held.get(index);
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		CoinFactory cf = new CoinFactory();
		coins.add(cf.getCoin("Quarter"));
		coins.add(cf.getCoin("Dollar"));
		coins.add(cf.getCoin("Nickel"));
		ArrayList<Product> prods = new ArrayList<Product>();
		prods.add(new Product("chips", 0.75f, 10));
		prods.add(new Product("chocolate", 1.0f));
		prods.add(new Product());
		Person persony = new Person(coins, prods);
		persony.takeProduct(new Product("chips", 0.75f, 2));
		persony.removeCoin("quarter");
		persony.addCoin("dollar");
		System.out.println(persony);
	}

}
