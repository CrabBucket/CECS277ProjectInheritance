package ProjectObserver;

import java.util.Observable;
import java.util.Observer;

public class Trader implements Observer{
	private String name;
	private double buyThreshold, sellThreshold;
	
	
	public Trader() {
		this.name = "Unknown Trader";
		this.buyThreshold = 100;
		this.sellThreshold = 110;
	}
	
	public Trader(String traderName, double buy, double sell) {
		this.name = traderName;
		this.buyThreshold = buy;
		this.sellThreshold = sell;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public boolean wantsToBuy(double value) {
		return value < this.buyThreshold;
	}
	
	public boolean wantsToSell(double value) {
		return value > this.sellThreshold;
	}
	
	public void update(Observable stock, Object arg) {
		System.out.println(String.format("%s has received a notification: %n    %s", this.name, (Trade) arg));
	}
}
