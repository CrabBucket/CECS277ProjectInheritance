package ProjectObserver;

public class Trade {
	private String name, stock;
	private double value;
	private boolean buying;
	
	public Trade() {
		this.name = "Unknown trader";
		this.stock = "Unknown stock";
		this.value = 0.00;
		this.buying = false;
	}
	
	public Trade(String iName, String iStock, double iValue, boolean iBuying) {
		this.name = iName;
		this.stock = iStock;
		this.value = iValue;
		this.buying = iBuying;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getStock() {
		return this.stock;
	}
	
	public double getValue() {
		return this.value;
	}
	
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
