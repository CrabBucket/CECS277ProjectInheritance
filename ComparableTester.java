package project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Comparable Tester
 * 
 * A tester for the classes: Checkout, DessertItem, Candy, Cookie, Icecream, and Sundae.
 * Tests the implemented Comparable interface and methods implemented from DessertItem.
 * 
 * @author Alexander Dung
 * @version 1.0
 * @since 2019-09-25
 */

public class ComparableTester {
	private static String divider = "\n------------------------------------------------------------------------------------------------------\n";
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		Checkout defaultCheckout = new Checkout();
		//Candy Test
		System.out.println(divider + "CANDY TEST:");
		Candy candy1 = new Candy("Salt Water Taffy", 160, 1.5f, 2.00f);
		Candy candy2 = new Candy("Chocolate Rocks", 200, 2.1f, 2.00f);
		defaultCheckout.enterItem(candy1);
		defaultCheckout.enterItem(candy2);
		System.out.printf("%n%s%n%n%s calories: %d%n", candy1, candy1.getName(), candy1.getCalories());
		System.out.printf("%n%s%n%n%s calories: %d%n", candy2, candy2.getName(), candy2.getCalories());
		
		//Cookie Test
		System.out.println(divider + "COOKIE TEST:");
		Cookie cookie1 = new Cookie("Chocolate Chip Cookie", 2400, 4, 2.00f);
		Cookie cookie2 = new Cookie("Creme Sandwich Cookie", 1600, 6, 2.00f);
		defaultCheckout.enterItem(cookie1);
		defaultCheckout.enterItem(cookie2);
		System.out.printf("%n%s%n%n%s calories: %d%n", cookie1, cookie1.getName(), cookie1.getCalories());
		System.out.printf("%n%s%n%n%s calories: %d%n", cookie2, cookie2.getName(), cookie2.getCalories());
		
		//Ice Cream Test
		System.out.println(divider + "ICE CREAM TEST:");
		Icecream icecream1 = new Icecream("Rocky Road Cone", 450, 3.50f);
		Icecream icecream2 = new Icecream("Strawberry Bowl", 350, 3.00f);
		defaultCheckout.enterItem(icecream1);
		defaultCheckout.enterItem(icecream2);
		System.out.printf("%n%s%n%n%s calories: %d%n", icecream1, icecream1.getName(), icecream1.getCalories());
		System.out.printf("%n%s%n%n%s calories: %d%n", icecream2, icecream2.getName(), icecream2.getCalories());
		
		//Sundae Test
		System.out.println(divider + "SUNDAE TEST:");
		Sundae sundae1 = new Sundae("Chocolate Chip Sundae with Chocolate Chip Topping", 600, 4.50f, 0.75f);
		Sundae sundae2 = new Sundae("Cookies and Cream Sundae with Caramel Topping", 670, 4.50f, 0.75f);
		defaultCheckout.enterItem(sundae1);
		defaultCheckout.enterItem(sundae2);
		System.out.printf("%n%s%n%n%s calories: %d%n", sundae1, sundae1.getName(), sundae1.getCalories());
		System.out.printf("%n%s%n%n%s calories: %d%n", sundae2, sundae2.getName(), sundae2.getCalories());
		
		//Output Receipt
		System.out.println(divider + "Output Receipt:");
		System.out.println(defaultCheckout);
		
		//Max Test with same DessertItem Types
		System.out.println(divider + "Max Test With Same DessertItem Types:");
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", candy1.getName(), candy1.getCost(), candy2.getName(), candy2.getCost(), DessertItem.max(candy1,  candy2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", cookie1.getName(), cookie1.getCost(), cookie2.getName(), cookie2.getCost(), DessertItem.max(cookie1,  cookie2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", icecream1.getName(), icecream1.getCost(), icecream2.getName(), icecream2.getCost(), DessertItem.max(icecream1,  icecream2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", sundae1.getName(), sundae1.getCost(), sundae2.getName(), sundae2.getCost(), DessertItem.max(sundae1,  sundae2).getName());
		
		//Max Test with different DessertItem Types
		System.out.println(divider + "Max Test With Different DessertItem Types:");
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", candy1.getName(), candy1.getCost(), sundae2.getName(), sundae2.getCost(), DessertItem.max(candy1,  sundae2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", cookie1.getName(), cookie1.getCost(), candy2.getName(), candy2.getCost(), DessertItem.max(cookie1,  candy2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", icecream1.getName(), icecream1.getCost(), cookie2.getName(), cookie2.getCost(), DessertItem.max(icecream1,  cookie2).getName());
		System.out.printf("%nGreatest of %s with price $%.2f and %s with price $%.2f: %s", sundae1.getName(), sundae1.getCost(), icecream2.getName(), icecream2.getCost(), DessertItem.max(sundae1,  icecream2).getName());
		
		//Sorting Test
		ArrayList<DessertItem> list = new ArrayList<DessertItem>();
		list.add(candy1);
		list.add(candy2);
		list.add(cookie1);
		list.add(cookie2);
		list.add(icecream1);
		list.add(icecream2);
		list.add(sundae1);
		list.add(sundae2);
		Collections.shuffle(list);
		//Print objects shuffled.
		System.out.println(divider + "The Unsorted DessertList is:\n");
		for(DessertItem d:list) {
			System.out.println(d.getName() + " at price $" + d.getCost());
		}
		//Print objects sorted using Collections.sort
		Collections.sort(list);
		System.out.println(divider + "The Sorted DessertList is:\n");
		for(DessertItem d:list) {
			System.out.println(d.getName() + " at price $" + d.getCost());
		}
	}

}
