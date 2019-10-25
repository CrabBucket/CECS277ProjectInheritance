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
	private int numberOfScoops;
	private String flavor;
	private String typeOfCone;
	private ArrayList<String> toppings = new ArrayList<String>();
	
	public Memento(int ns, String flv, String cone) {
		this.numberOfScoops = ns;
		this.flavor = flv;
		this.typeOfCone = cone;
		this.toppings = new ArrayList<String>();
	}
	
	public Memento(int ns, String flv, String cone, ArrayList<String> tp) {
		this.numberOfScoops = ns;
		this.flavor = flv;
		this.typeOfCone = cone;
		this.toppings = tp;
	}
	
	public int getScoops() {
		return this.numberOfScoops;
	}
	
	public String getFlavor() {
		return this.flavor;
	}
	
	public String getCone() {
		return this.typeOfCone;
	}
	
	public ArrayList<String> getToppings(){
		return this.toppings;
	}
}
