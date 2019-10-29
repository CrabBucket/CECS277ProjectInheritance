package ProjectBinaryIO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Guy
 *
 */
public class IceCreamTester {
	public static void main(String[] args) {
		CareTaker saver = new CareTaker();
		String[] rndToppings = {"chocolate chips", "caramel", "chocolate syrup", "almonds", "peanuts", "sprinkles", "gummy bears", "graham cracker crumbs", "oreo crumbs", "strawberry syrup"};
		String[] coneTypes = {"regular", "sugar", "waffle"};
		//instantiate a cone of each flavor, each set to default besides flavor
		AdvancedIceCreamCone vnlaCone = new AdvancedIceCreamCone();
		AdvancedIceCreamCone chocCone = new AdvancedIceCreamCone(1, "chocolate", "regular");
		AdvancedIceCreamCone mintCone = new AdvancedIceCreamCone(1, "mint", "regular");
		//make sure setFlavor works
		AdvancedIceCreamCone stbrCone = new AdvancedIceCreamCone();
		stbrCone.setFlavor("strawberry");
		
		//Begin messing with vanilla cone
		
		vnlaCone.addScoop();
		ArrayList<String> toppingsToAdd = new ArrayList<String>();
		for(int index = 0; index < rndToppings.length; index++) {
			if(index % 2 == 0)toppingsToAdd.add(rndToppings[index]);
		}
		//add random toppings to vanilla cone
		vnlaCone.addToppings(toppingsToAdd);
		//set vanilla cone's cone type randomly
		vnlaCone.setTypeOfCone(coneTypes[(int)(Math.random() * 3)]);
		//vanilla cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(vnlaCone.createMemento());
		
		//Begin messing with chocolate cone
		
		//3 times, add a scoop and a random topping to chocolate cone.
		for(int count = 0; count < 3; count++) {
			chocCone.addScoop();
			chocCone.addToppings(rndToppings[(int)(Math.random() * rndToppings.length)]);
		}
		//chocolate cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(chocCone.createMemento());
		
		//Begin messing with mint cone
		
		//5 times, add a scoop and a topping to mint cone
		for(int index = 0; index < 5; index++) {
			mintCone.addScoop();
			mintCone.addToppings(rndToppings[index]);
		}
		//set cone to waffle
		mintCone.setTypeOfCone(coneTypes[2]);
		//mint cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(mintCone.createMemento());
		
		//Begin messing with strawberry cone
		
		toppingsToAdd.clear();
		toppingsToAdd.addAll(Arrays.asList(rndToppings));
		stbrCone.addToppings(toppingsToAdd);
		stbrCone.setTypeOfCone(coneTypes[1]);
		//Strawberry cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(stbrCone.createMemento());

		//indecisive person chooses a flavor.
		String[] flavors = {"vanilla", "chocolate", "mint", "strawberry"};
		String chosenFlavor = flavors[(int)(Math.random() * 4)];
		System.out.println("Chosen flavor: " + chosenFlavor);
		
		AdvancedIceCreamCone temp = new AdvancedIceCreamCone();
		//with chosen flavor, read all saved cones for correct flavor.
		boolean coneFound = false;
		//while chosen flavor cone is not found:
		while(!coneFound) {
			//read cone from file
			temp.restore(saver.readMemento());
			//if cone that was read is the correct flavor, end loop. else, continue loop
			if(temp.getFlavor().equals(chosenFlavor)) coneFound = true;
		}
		System.out.println("Chosen cone: " + temp);
		//calculate price - $3.50 base price, $0.35 per topping, $0.20 per extra scoop
		double price = (temp.getToppings().size() * 0.35) + (0.2 * (temp.getNumberOfScoops() - 1)) + 3.50;
		System.out.println(String.format("Price of cone: $%.2f", price));
	}
}
