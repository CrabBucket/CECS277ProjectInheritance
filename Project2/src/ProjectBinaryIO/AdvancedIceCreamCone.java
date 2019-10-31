package ProjectBinaryIO;

/*
   There are currently restriction on the construction of the cone: only one
   flavor of ice cream is allowed. */

import java.util.*;

/**
 * The Class AdvancedIceCreamCone.
 * This class is used to model the properties and behaviors of an ice cream cone.
 * @author Alexander Dung
 */
public class AdvancedIceCreamCone {
	
	/** The number of scoops. */
	private int numberOfScoops;
	
	/** The flavor. */
	private String flavor;
	
	/** The type of cone. */
	private String typeOfCone;
	
	/** The toppings. */
	private ArrayList<String> toppings = new ArrayList<String>();


	/**
	 * Instantiates a new ice cream cone.
	 */
	public AdvancedIceCreamCone() {
		numberOfScoops=1;
		flavor="vanilla";
		typeOfCone="regular";
	}

	/**
	 * Instantiates a new ice cream cone with specified qualities.
	 *
	 * @param ns the number of scoops
	 * @param flv the flavor of ice cream
	 * @param cone the type of cone
	 */
	public AdvancedIceCreamCone(int ns,String flv,String cone) {
		numberOfScoops=ns;
		flavor=flv;
		typeOfCone=cone;
	}

	/**
	 * Gets the number of scoops.
	 *
	 * @return the number of scoops
	 */
	public int getNumberOfScoops () {
		return numberOfScoops;
	}

	/**
	 * Gets the flavor of ice cream.
	 *
	 * @return the flavor of ice cream
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * Gets the type of cone.
	 *
	 * @return the type of cone
	 */
	public String getTypeOfCone() {
		return typeOfCone;
	}

	/**
	 * Increments the number of scoops of ice cream by one.
	 */
	public void addScoop() {
		System.out.println(String.format("%s cone: added a scoop.", this.flavor));
		numberOfScoops=numberOfScoops+1;
	}

	/**
	 * Sets the flavor of ice cream.
	 *
	 * @param flv the new flavor of ice cream
	 */
	public void setFlavor(String flv) {
		System.out.println(String.format("%s cone: set flavor to %s.", this.flavor, flv));
		flavor=flv;
	}

	/**
	 * Sets the type of cone.
	 *
	 * @param cone the new type of cone
	 */
	public void setTypeOfCone(String cone) {
		System.out.println(String.format("%s cone: set cone to %s.", this.flavor, cone));
		typeOfCone=cone;
	}

	/**
	 * Adds a topping.
	 *
	 * @param top the new topping
	 */
    public void addToppings(String top) {
		System.out.println(String.format("%s cone: added a topping - %s.", this.flavor, top));
		toppings.add(top);
	}

	/**
	 * Adds multiple toppings from a List.
	 *
	 * @param top the list of new toppings
	 */
    public void addToppings(List<String> top) {
		System.out.println(String.format("%s cone: added multiple toppings - %s.", this.flavor, top));
		toppings.addAll(top);
	}

	/**
	 * Gets the toppings currently on the ice cream cone.
	 *
	 * @return the toppings currently on the cone
	 */
	public ArrayList<String> getToppings () {
		return toppings;
	}
	
	/**
	 * Creates a Memento of the current ice cream cone's variables.
	 *
	 * @return the Memento of the current ice cream cone's variables
	 */
	public Memento createMemento() {
		return new Memento(this.numberOfScoops, this.flavor, this.typeOfCone, this.toppings);
	}
	
	/**
	 * Restores the state of the IceCreamCone based on the Memento parameter
	 *
	 * @param newState the Memento to set variables to
	 */
	public void restore(Memento newState) {
		this.numberOfScoops = newState.getScoops();
		this.flavor = newState.getFlavor();
		this.typeOfCone = newState.getCone();
		this.toppings = newState.getToppings();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("%d scoop(s) of %s ice cream on a %s cone, with toppings: %s", numberOfScoops, flavor, typeOfCone, toppings.toString());
	  }

}
