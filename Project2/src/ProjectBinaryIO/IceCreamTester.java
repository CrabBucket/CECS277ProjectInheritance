package ProjectBinaryIO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tester that uses a single AdvancedIceCreamCone
 * Saves the state of that Cone after we are done editing
 * Can restore the state of the Cone at the end from file
 * So we can read any of our cones.
 * 
 * @author Alexander Dung
 *
 */
public class IceCreamTester {
	public static void main(String[] args) {
		CareTaker saver = new CareTaker();
		String[] rndToppings = {"chocolate chips", "caramel", "chocolate syrup", "almonds", "peanuts", "sprinkles", "gummy bears", "graham cracker crumbs", "oreo crumbs", "strawberry syrup"};
		String[] coneTypes = {"regular", "sugar", "waffle"};
		//instantiate a cone of each flavor, each set to default besides flavor
		AdvancedIceCreamCone Cone = new AdvancedIceCreamCone();
		//AdvancedIceCreamCone chocCone = new AdvancedIceCreamCone(1, "chocolate", "regular");
		//AdvancedIceCreamCone mintCone = new AdvancedIceCreamCone(1, "mint", "regular");
		//make sure setFlavor works
		//AdvancedIceCreamCone strCone = new AdvancedIceCreamCone();
		//stbrCone.setFlavor("strawberry");
		
		//Begin messing with vanilla cone
		
		Cone.addScoop();
		ArrayList<String> toppingsToAdd = new ArrayList<String>();
		for(int index = 0; index < rndToppings.length; index++) {
			if(index % 2 == 0)toppingsToAdd.add(rndToppings[index]);
		}
		//add random toppings to vanilla cone
		Cone.addToppings(toppingsToAdd);
		//set vanilla cone's cone type randomly
		Cone.setTypeOfCone(coneTypes[(int)(Math.random() * 3)]);
		//vanilla cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(Cone.createMemento());
		Cone = new AdvancedIceCreamCone(1, "chocolate", "regular");
		//Begin messing with chocolate cone
		
		//3 times, add a scoop and a random topping to chocolate cone.
		for(int count = 0; count < 3; count++) {
			Cone.addScoop();
			Cone.addToppings(rndToppings[(int)(Math.random() * rndToppings.length)]);
		}
		//chocolate cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(Cone.createMemento());
		
		//Begin messing with mint cone
		Cone = new AdvancedIceCreamCone(1, "mint", "regular");
		//5 times, add a scoop and a topping to mint cone
		for(int index = 0; index < 5; index++) {
			Cone.addScoop();
			Cone.addToppings(rndToppings[index]);
		}
		//set cone to waffle
		Cone.setTypeOfCone(coneTypes[2]);
		//mint cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(Cone.createMemento());
		
		//Begin messing with strawberry cone
		Cone = new AdvancedIceCreamCone();
		Cone.setFlavor("strawberry");
		
		toppingsToAdd.clear();
		toppingsToAdd.addAll(Arrays.asList(rndToppings));
		Cone.addToppings(toppingsToAdd);
		Cone.setTypeOfCone(coneTypes[1]);
		//Strawberry cone is finalized, so save a Memento to file with CareTaker.
		saver.saveMemento(Cone.createMemento());

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
