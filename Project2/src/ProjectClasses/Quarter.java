package ProjectClasses;
/**
 * 	Coin that represents a nickel.
 * @author Thomas McSwain
 *
 */
public class Quarter implements Coin {

	private  double value;
	private  String name;
	
	public Quarter() {
		value = 0.25;
		name = "Quarter";
	}
	



	@Override
	/** Returns value of the coin
	 * @return Returns 0.25
	 */
	public double getValue() {
		// TODO Auto-generated method stub
		return value;

	}
	
	@Override
	/** Returns name of coin
	 * @return Returns "Quarter"
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
