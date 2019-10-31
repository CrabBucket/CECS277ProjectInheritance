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
 * Instantiates a new advanced ice cream cone.
 */
//the default constructor creates a one scoop, vanilla ice cream cone using the regular type of cone and no toppings
	public AdvancedIceCreamCone() {
		numberOfScoops=1;
		flavor="vanilla";
		typeOfCone="regular";
	}

/**
 * Instantiates a new advanced ice cream cone.
 *
 * @param ns the ns
 * @param flv the flv
 * @param cone the cone
 */
/*this constructor lets you create an ice cream code to your liking. It takes in three parameters:
  the number of scoops, the flavor of the ice cream and the type of cone */
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
//this method returns the number of scoops in the cone
	public int getNumberOfScoops () {
		return numberOfScoops;
	}

/**
 * Gets the flavor.
 *
 * @return the flavor
 */
//this method returns the ice cream flavor
	public String getFlavor() {
		return flavor;
	}

/**
 * Gets the type of cone.
 *
 * @return the type of cone
 */
//this method returns the type of cone
	public String getTypeOfCone() {
		return typeOfCone;
	}

/**
 * Adds the scoop.
 */
//this method allows you to add one scoop of ice cream at a time
	public void addScoop() {
		System.out.println(String.format("%s cone: added a scoop.", this.flavor));
		numberOfScoops=numberOfScoops+1;
	}

/**
 * Sets the flavor.
 *
 * @param flv, the new flavor
 */
//this method allows you to change the ice cream flavor
	public void setFlavor(String flv) {
		System.out.println(String.format("%s cone: set flavor to %s.", this.flavor, flv));
		flavor=flv;
	}

/**
 * Sets the type of cone.
 *
 * @param cone, the new type of cone
 */
//this method allows you to change the type of cone
	public void setTypeOfCone(String cone) {
		System.out.println(String.format("%s cone: set cone to %s.", this.flavor, cone));
		typeOfCone=cone;
	}

/**
 * Adds the toppings.
 *
 * @param top, the topping you want to add
 */
//this method allows you to add  toppings
    public void addToppings(String top) {
		System.out.println(String.format("%s cone: added a topping - %s.", this.flavor, top));
		toppings.add(top);
	}

/**
 * Adds the toppings.
 *
 * @param top the topping arraylist you want to add.
 */
//this method allows you to add toppings from an ArrayList
    public void addToppings(List<String> top) {
		System.out.println(String.format("%s cone: added multiple toppings - %s.", this.flavor, top));
		toppings.addAll(top);
	}

/**
 * Gets the toppings.
 *
 * @return the toppings
 */
//this method returns a String with a list of the toppings
	public ArrayList<String> getToppings () {
		return toppings;
	}
	
	/**
	 * Creates the memento.
	 *
	 * @return the memento
	 */
	public Memento createMemento() {
		return new Memento(this.numberOfScoops, this.flavor, this.typeOfCone, this.toppings);
	}
	
	/**
	 * Restores the state of the IceCreamCone based on the memento parameter
	 *
	 * @param newState the new state
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
//this method overrides the inherited toString()
	public String toString() {
		return String.format("%d scoop(s) of %s ice cream on a %s cone, with toppings: %s", numberOfScoops, flavor, typeOfCone, toppings.toString());
	  }

}
