package ProjectObserver;

/**
 * Class that contains the main method to test the Stock, Trade, and Trade classes.
 * Specifically, tests all constructors, the Stock class's inheritance of Observable, and Trader's implementation of Observer.
 * @author Thomas McSwain
 *
 */
public class StockMarket {
	
	/**
	 * The main method. Command line arguments are irrelevant.
	 * @param args console arguments, unused.
	 */
	public static void main(String[] args) {
		//create three Stocks
		Stock apple = new Stock("AAPL");
		Stock microsoft = new Stock("MSFT");
		Stock amazon = new Stock("AMZN");
		
		//create Traders for use with Stocks
		Trader amy = new Trader("Amy");
		Trader zach = new Trader("Zach");
		Trader josh = new Trader("Josh");
		
		//add Traders to Stocks.
		apple.addObserver(amy);
		apple.addObserver(zach);
		
		microsoft.addObserver(zach);
		microsoft.addObserver(josh);
		
		amazon.addObserver(amy);
		amazon.addObserver(zach);
		amazon.addObserver(josh);

		//test Stocks' notifyObservers() method among multiple Stocks.
		apple.updateStock();
		System.out.println("\n\nAmy is making a trade for AAPL.");
		apple.notifyObservers(new Trade("Amy", apple.getName(), 100, true));
		apple.updateStock();
		System.out.println("\n\nZach is making a trade for AAPL.");
		apple.notifyObservers(new Trade("Zach", apple.getName(), 200, false));
		apple.updateStock();
		System.out.println("\n\nAmy is making a trade for AAPL.");
		apple.notifyObservers(new Trade("Amy", apple.getName(), 150, false));
		
		microsoft.updateStock();
		System.out.println("\n\nJosh is making a trade for MSFT.");
		microsoft.notifyObservers(new Trade("Josh", microsoft.getName(), 150, false));
		microsoft.updateStock();
		System.out.println("\n\n Josh is making a trade for MSFT.");
		microsoft.notifyObservers(new Trade("Josh", microsoft.getName(), 150, false));
		microsoft.updateStock();
		System.out.println("\n\n Zach is making a trade for MSFT.");
		microsoft.notifyObservers(new Trade("Zach", microsoft.getName(), 150, false));
		
		amazon.updateStock();
		System.out.println("\n\n Amy is making a trade for AMZN.");
		amazon.notifyObservers(new Trade("Amy", amazon.getName(), 100, false));
		
		//test deleteObserver(), add new Trader by default constructor.
		System.out.println("\n\nAmy is no longer following AMZN.\nA new trader is now following AMZN.");
		amazon.deleteObserver(amy);
		amazon.addObserver(new Trader());
		
		//test Trade default constructor.
		amazon.updateStock();
		System.out.println("\n\nAn unknown trade has been made.");
		amazon.notifyObservers(new Trade());
		amazon.updateStock();
		System.out.println("\n\nZach is making a trade for AMZN.");
		amazon.notifyObservers(new Trade("Zach", amazon.getName(), 150, true));
	}

}
