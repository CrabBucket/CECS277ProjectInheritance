package project;

public class Cookie extends DessertItem {
	private int dozens;
	private float pricePer;
	public Cookie(String name, int calories,int dozens, float pricePer) {
		super(name, calories);
		this.dozens = dozens;
		this.pricePer = pricePer;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "";
	}
	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return pricePer*dozens*12;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		return calories*12*dozens;
	}

	@Override
	public DessertItem max(DessertItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
