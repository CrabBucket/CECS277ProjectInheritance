package ProjectClasses;

/**
 * Represents a product to be sold at a vending machine.
 * Stores the price of the product, the name of the product, and the number of units of the product.
 * Contains methods to decrement and increment the amount of units.
 * @author Alexander Dung
 *
 */
public class Product {
	private String name;
	private double price;
	private int amount;
	
	/*
	 * Default constructor for a Product. Creates a functional but ineffectual product.
	 */
	public Product() {
		this.name = "Unknown Product";
		this.price = 0f;
		this.amount = 0;
	}
	
	/*
	 * Constructor for a product with specified name and price, and unspecified amount. Assumes that only 1 product is added.
	 * @param name of the product added
	 * @param price of a single unit of the product
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.amount = 1;
	}
	
	/*
	 * Constructor for a product with specified name, price, and amount.
	 * @param name of the product added
	 * @param price of a single unit of the product
	 * @param amount of units of the product
	 */
	public Product(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int newAmount) {
		this.amount = newAmount;
	}
	
	/**
	 * Increments amount of units by 1.
	 */
	public void incrementAmount() {
		this.amount++;
	}
	
	/**
	 * Decrements amount of units by 1. Returns a single Prodcut of the same name and price.
	 * @return A single product with the same name and price.
	 */
	public Product decrementAmount() {
		this.amount--;
		return new Product(this.name,this.price);
	}
	
	@Override
	public String toString() {
		return String.format("%s @ $%.2f/un.%n%d un.%n", this.name, this.price, this.amount);
	}
	
	public static void main(String args[]) {
		Product proddy = new Product("proddy", 10f, 10);
		Product proddo = new Product("proddo", 5.22f);
		Product un = new Product();
		System.out.println(proddy);
		System.out.println(proddo);
		System.out.println(un);
	}

}
