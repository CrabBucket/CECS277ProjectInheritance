package ProjectClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VendingMachineUI {
	public static ArrayList<Coin> createCoins(int n,int d, int q, int dlr){
		CoinFactory cf = new CoinFactory();
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for(int i = 0;i<n;i++) {
			coins.add(cf.getCoin("Nickel"));
		}
		for(int i = 0;i<d;i++) {
			coins.add(cf.getCoin("Dime"));
		}
		for(int i = 0;i<q;i++) {
			coins.add(cf.getCoin("Quarter"));
		}
		for(int i = 0;i<dlr;i++) {
			coins.add(cf.getCoin("Dollar"));
		}
		return coins;
	}
	public static void main(String args[]) throws IOException {
		// Instantiate all my classes.
		boolean quit = false;
		CoinFactory cf = new CoinFactory();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		VendingMachine vm = new VendingMachine();
		Person per = new Person();
		// Get the starting money
		while(true) {
			boolean validinput = true;
			try {
				System.out.println("How many nickels do you have?");
				int nick = Integer.parseInt(buffer.readLine());
				System.out.println("How many dimes do you have?");
				int dime = Integer.parseInt(buffer.readLine());
				System.out.println("How many quarters do you have?");
				int quar = Integer.parseInt(buffer.readLine());
				System.out.println("How many dollars do you have?");
				int dlr = Integer.parseInt(buffer.readLine());
				per = new Person(createCoins(nick,dime,quar,dlr));
			}catch(Exception e) {
			System.out.println("Invalid number");
			validinput = false;
			}
			if(validinput) {
				break;
			}
		}
		System.out.println(per);
		
		
		// Main loops that prompts user for input
		while(true) {
			System.out.println("S)how products  I)nsert coin  B)uy  O)perator Menu  Q)uit");
			String input = buffer.readLine().toLowerCase();
			//After we prompt the user we go into the main decision tree we always go back to.
			switch(input) {
			//Shows the products in the vending machine.
			case "s":
				System.out.println(vm.showProducts());
				break;
			//Prompts the user to enter a number then branches based on the number the pick.
			case "i":
				System.out.println(
						"1) Nickel\n" + 
						"2) Dime\n" + 
						"3) Quarter\n" + 
						"4) Dollar\n");
				String coinchoice = buffer.readLine();
				
				//Attempts to add a coin based on the coin they selected.
				switch(coinchoice) {
					case "1":
						if(per.removeCoin("Nickel")) {
							vm.insertCoin("Nickel");
						}else {
							System.out.println("You have no nickels.");
						}
					break;
					case "2":
						if(per.removeCoin("Dime")) {
							vm.insertCoin("Dime");
						}else {
							System.out.println("You have no dimes.");
						}
					break;
					case "3":
						if(per.removeCoin("Quarter")) {
							vm.insertCoin("Quarter");
						}else {
							System.out.println("You have no quarters.");
						}
					break;
					case "4":
						if(per.removeCoin("Dollar")) {
							vm.insertCoin("Dollar");
						}else {
							System.out.println("You have no dollars.");
						}
					break;
					
					
				}
				break;
			// Controls the logic for buying an item, shows products then trys to match user input item to a name in the product list.
			case "b":
				System.out.println(vm.showProducts());
				System.out.println("Input the name of the product you wish to purchase.");
				String item = buffer.readLine();
				try {
					ArrayList<Coin> temp = vm.purchaseProduct(vm.indexOf(item), per);
					if(temp.size()>0) {
						System.out.println("Not enough coins inserted, returning money.");
						for(Coin c:temp) per.addCoin(c.getName());
					}else {
						System.out.println("Purchase complete");
					}
				}catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Invalid Product name");
				}
						
				
				
				break;
			//Opens up the operator menu Creates new menu which allows the removal of coins, adding products and displaying the contents of the entire vending machine.
			case "o":
				System.out.println("A)dd Product T)ake Coins S)how Contents");
				String operatorbranch = buffer.readLine();
				//Branches based on user input
				switch(operatorbranch.toLowerCase()) {
					//Goes through the process of adding a product
					case "a":
						System.out.println("Name of product:");
						String name = buffer.readLine();
						try {
							System.out.println("Value of the product:");
							double value = Double.parseDouble(buffer.readLine());
							System.out.println("Amount:");
							int amount = Integer.parseInt(buffer.readLine());
							if(amount<=0) {
								throw new IOException();
							}
							vm.addProduct(new Product(name,value,amount));
						} catch (Exception e) {
							System.out.println("Invalid product, enter a value in the form X.X.. and an integer amount greater than 0");
						}
						break;
					// Prints out the amount of coins and then removes the from the machine and adds them to the person.
					case "t":
						System.out.println(String.format("You got $%.2f worth of coins!", vm.balance()));
						for(Coin c:vm.takeCoins()) per.addCoin(c.getName());
						break;
					//Uses the vms toString to show contents.
					case "s":
						System.out.println(vm);
						break;
				}
				break;
			//Quits main decision branch
			case "q":
				quit = true;
				break;
			//Secret case to load machine with some products so I don't have to type as much.
			case "loadmachine":
				vm.addProduct(new Product("Water",1,10));
				vm.addProduct(new Product("Cheetos",1.25,1));
				vm.addProduct(new Product("Monster",1.65,15));
			
			}
			if(quit) {
				break;
			}
		}
	}
}
