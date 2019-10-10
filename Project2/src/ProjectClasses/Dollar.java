package ProjectClasses;

public class Dollar implements Coin {

	private  double value;
	private  String name;
	
	public Dollar() {
		value = 1.00;
		name = "Dollar";
	}
	



	@Override
	/** Returns value of the coin
	 * @return Returns 1.00
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
