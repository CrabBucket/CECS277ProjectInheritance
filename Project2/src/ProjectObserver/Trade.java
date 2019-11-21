package ProjectObserver;

/**
 * Represents a record of a stock trade.
 * Contains the name of the trader, the name of the stock traded, the type of trade, and the value at which the stock was traded.
 * @author Alexander Dung
 *
 */
public class Trade {
	private String name, stock;
	private double value;
	private boolean buying;
	
	/**
	 * Default constructor, sets all data to reflect the trade being unknown.
	 */
	public Trade() {
		this.name = "Unknown trader";
		this.stock = "Unknown stock";
		this.value = 0.00;
		this.buying = false;
	}
	
	/**
	 * Constructor, initializes stock trader name, stock name, value of stock, and trade type to args.
	 * @param iName name of the stock trader who made the trade
	 * @param iStock name of the stock that the trade was made for
	 * @param iValue value at which the stock was traded
	 * @param iBuying reflects whether the stock was bought or sold
	 */
	public Trade(String iName, String iStock, double iValue, boolean iBuying) {
		this.name = iName;
		this.stock = iStock;
		this.value = iValue;
		this.buying = iBuying;
	}
	
	/**
	 * Gets the name of the trader for this trade and returns it.
	 * @return String the name of the Trade's trader
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the name of the stock this trade is for and returns it.
	 * @return String the name of the Trade's stock
	 */
	public String getStock() {
		return this.stock;
	}
	
	/**
	 * Gets the value of the stock at the time of the trade and returns it.
	 * @return double the value of the Trade's stock at the time of trade
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Returns a boolean reflecting whether the trade is a stock purchase or a stock sale, where true is a purchase and false is a sale.
	 * @return boolean whether the trade is a purchase or not
	 */
	public boolean isBuying() {
		return this.buying;
	}
	
	public String toString() {
		String buyOrSell = "";
		if(this.buying) buyOrSell = "bought";
		else buyOrSell = "sold";
		return String.format("Trader %s has %s $%.2f of stock for %s.", this.name, buyOrSell, this.value, this.stock);
	}
}
