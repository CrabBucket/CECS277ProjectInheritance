package ProjectClasses;

import java.util.ArrayList;
/**
 * Represents Vending machine stores products and coins,
 * Also contains methods to run the functions of a vending machine
 * @author Thomas McSwain
 *
 */
public class VendingMachine {
	
	private ArrayList<Product> products;
	private ArrayList<Coin> balance;
	private ArrayList<Coin> buffer;
	private CoinFactory cf;
	/**
	 * Default constructor that instantiates the products and the balance as an empty list.
	 */
	public VendingMachine() {
		products = new ArrayList<Product>();
		cf = new CoinFactory();
		buffer = new ArrayList<Coin>();
		balance = new ArrayList<Coin>();
	}
	/**
	 * Constructor that takes in ArrayLists that become the products and coins.
	 * @param products
	 * @param coins
	 */
	public VendingMachine(ArrayList<Product> products, ArrayList<Coin> coins) {
		this.products = products;
		cf = new CoinFactory();
		buffer = new ArrayList<Coin>();
		balance = new ArrayList<Coin>();
	}
	/**
	 * Emptys the buffer of coins
	 */
	public void emptyBuffer() {
		buffer.clear();
	}
	/**
	 * Takes a coin object and adds its amount to the amount of the current coin
	 * @param coin
	 */
	public void insertCoin(String coin) {
		buffer.add(cf.getCoin(coin));
	}
	/**
	 * adds a new product to products
	 * @param product The product to be added
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	/**
	 * Returns the total monetary amount of the Coins in the balance
	 * @return
	 */
	public double balance() {
		double sum = 0;
		for(Coin c:balance) {
			sum+=c.getValue();
		}
		return sum;
	}
	/**
	 * Returns the total monetary amount of the Coins in the buffer
	 * @return
	 */
	public double totalValue() {
		double sum = 0;
		for(Coin c:buffer) {
			sum+=c.getValue();
		}
		return sum;
	}
	public ArrayList<Coin> takeCoins(){
		ArrayList<Coin> temp = balance;
		balance.clear();
		return temp;
	}
	/**
	 * Returns the index of the Item with specified name
	 * @param name Item you are looking for.
	 * @return Index of the item in products.
	 */
	public int indexOf(String name) {
		for(int i = 0;i<products.size();i++) {
			if(products.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Purchase product checks if the person has entered enough coins in to the machine to purchase the selected product.
	 * If they have it adds all the coins in the buffer into the balance then empties the buffer. It then returns true.
	 * If they don't have enough coins in the machine it returns false and does nothing.
	 * @param index Index of the product intended for purchase
	 * @param person Person purchasing the product
	 * @return Boolean reflecting whether the purchase was successful.
	 */
	public boolean purchaseProduct(int index,Person person) {
		double removemoney = products.get(index).getPrice();
		if(totalValue()>=removemoney) {
			if(products.get(index).getAmount()==1) {
				person.takeProduct(products.remove(index));
			}else {
				//Sets products = products -1
				person.takeProduct(products.get(index).decrementAmount());
			}
			for(Coin c:buffer) { balance.add(cf.getCoin(c.getName()));}
			emptyBuffer();
			return true;
		}
		return false;
	}
	
	public String showProducts() {
		String temp = "";
		if(products.size()>0) {
			temp = temp + "Products in the vending machine:\n\n";
			for(Product p:products) { temp = temp + p.toString() + "\n";}
		}else {
			temp = temp + "There are no products in the vending Machine\n\n";
		}
		return temp;
	}
	public String toString() {
		String temp = "";
		temp = temp + showProducts();
		if(balance.size()>0) {
			temp = temp + "Coins in the vending machine's balance:\n\n";
			for(Coin c:balance) { temp = temp + c.toString() + "\n";}
		}else {
			temp = temp + "There are no Coins in the vending machine's balance\n\n";
		}
		if(buffer.size()>0) {
			temp = temp + "Coins inserted in the vending machine so far:\n\n";
			for(Coin c:buffer) { temp = temp + c.toString() + "\n";}
		}else {
			temp = temp + "There have been no coins inserted in the vending machine\n\n";
		}
		return temp;
		
	}
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		CoinFactory cf = new CoinFactory();
		Person p1 = new Person();
		vm.addProduct(new Product("chips", 0.75f, 10));
		vm.addProduct(new Product("chocolate",1.2f));
		vm.addProduct(new Product("Soda",1,100));
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		
		vm.insertCoin("Dime");
		System.out.println(vm.toString());
		System.out.println(vm.purchaseProduct(0, p1));
		System.out.println(p1);
		
	}
	
	
}
