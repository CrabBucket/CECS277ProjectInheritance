package project;

public class Candy extends DessertItem {
	private float weight;
	private float priceDensity;
	public Candy(String name,int calories,float weight,float priceDensity) {
		super(name,calories);
		this.weight = weight;
		this.priceDensity = priceDensity;
	}
	
	public String toString() {
		return "";
	}
	@Override
	public float getCost() {
		
		return weight*priceDensity;
	}

	@Override
	public int getCalories() {
		
		return Math.round(calories*weight);
	}

	@Override
	public DessertItem max(DessertItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
