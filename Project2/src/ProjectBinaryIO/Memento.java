package ProjectBinaryIO;

import java.util.ArrayList;
import java.io.Serializable;


/**
 * Memento saves the fields of AdvancedIceCreamCone and has mutators for stored fields.
 * Also implements Serializable for use with CareTaker to write into storage.
 * @author Alexander Dung
 *
 */
public class Memento implements Serializable{
	
	/** The number of scoops. */
	private int numberOfScoops;
	
	/** The flavor. */
	private String flavor;
	
	/** The type of cone. */
	private String typeOfCone;
	
	/** The toppings. */
	private ArrayList<String> toppings = new ArrayList<String>();
	
	/**
	 * Instantiates a new memento with empty topppings.
	 *
	 * @param ns the ns
	 * @param flv the flv
	 * @param cone the cone
	 */
	public Memento(int ns, String flv, String cone) {
		this.numberOfScoops = ns;
		this.flavor = flv;
		this.typeOfCone = cone;
		this.toppings = new ArrayList<String>();
	}
	
	/**
	 * Instantiates a new memento with given toppings.
	 *
	 * @param ns the ns
	 * @param flv the flv
	 * @param cone the cone
	 * @param tp the tp
	 */
	public Memento(int ns, String flv, String cone, ArrayList<String> tp) {
		this.numberOfScoops = ns;
		this.flavor = flv;
		this.typeOfCone = cone;
		this.toppings = tp;
	}
	
	/**
	 * Gets the scoops.
	 *
	 * @return the scoops
	 */
	public int getScoops() {
		return this.numberOfScoops;
	}
	
	/**
	 * Gets the flavor.
	 *
	 * @return the flavor
	 */
	public String getFlavor() {
		return this.flavor;
	}
	
	/**
	 * Gets the cone.
	 *
	 * @return the cone
	 */
	public String getCone() {
		return this.typeOfCone;
	}
	
	/**
	 * Gets the toppings.
	 *
	 * @return the toppings
	 */
	public ArrayList<String> getToppings(){
		return this.toppings;
	}
}
