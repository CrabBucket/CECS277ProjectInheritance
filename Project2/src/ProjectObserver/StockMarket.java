package ProjectObserver;

import java.util.ArrayList;

public class StockMarket {
	
	public static void main(String[] args) {
		Stock apple = new Stock("AAPL");
		Stock microsoft = new Stock("MSFT");
		Stock amazon = new Stock("AMZN");
		
		Trader amy = new Trader("Amy", 100, 120);
		Trader zach = new Trader("Zach", 120, 150);
		Trader josh = new Trader("Josh", 100, 115);
		
		apple.addObserver(amy);
		apple.addObserver(zach);
		
		microsoft.addObserver(zach);
		microsoft.addObserver(josh);
		
		amazon.addObserver(amy);
		amazon.addObserver(zach);
		amazon.addObserver(josh);

		apple.updateStock();
		apple.notifyObservers(new Trade("Amy", apple.getName(), 100, true));
		apple.updateStock();
		apple.notifyObservers(new Trade("Zach", apple.getName(), 200, false));
		apple.updateStock();
		apple.notifyObservers(new Trade("Amy", apple.getName(), 150, false));
		
		microsoft.updateStock();
		microsoft.notifyObservers(new Trade("Josh", microsoft.getName(), 150, false));
		microsoft.updateStock();
		microsoft.notifyObservers(new Trade("Josh", microsoft.getName(), 150, false));
		microsoft.updateStock();
		microsoft.notifyObservers(new Trade("Zach", microsoft.getName(), 150, false));
		
		amazon.updateStock();
		amazon.notifyObservers(new Trade("Amy", amazon.getName(), 100, false));
		amazon.deleteObserver(amy);
		amazon.updateStock();
		amazon.notifyObservers(new Trade("Josh", amazon.getName(), 200, true));
		amazon.updateStock();
		amazon.notifyObservers(new Trade("Zach", amazon.getName(), 150, true));
	}

}
