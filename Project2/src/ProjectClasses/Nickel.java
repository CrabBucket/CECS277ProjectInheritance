package ProjectClasses;
/**
 * 	Coin that represents a nickel.
 * @author Thomas McSwain
 *
 */
public class Nickel implements Coin {
	private  double value;
	private  String name;
	
	public Nickel() {
		value = 0.05;
		name = "Nickel";
	}
	



	@Override
	/** Returns value of the coin
	 * @return Returns 0.05
	 */
	public double getValue() {
		// TODO Auto-generated method stub
		return value;

	}

	@Override
	/** Returns name of coin
	 * @return Returns "Nickel"
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	/**
	 * Returns a formatted string of this coin
	 * @return Formatted string
	 */
	@Override
	public String toString() {
		return String.format("A %s",name);
	}

}
