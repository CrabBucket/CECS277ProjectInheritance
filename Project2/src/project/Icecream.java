package project;

public class Icecream extends DessertItem {
	private float cost;
	
	public Icecream(String name, int calories,float cost) {
		super(name, calories);
		this.cost = cost;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "";
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		return calories;
	}

	@Override
	public DessertItem max(DessertItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
