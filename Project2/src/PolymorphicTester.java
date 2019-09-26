import java.util.ArrayList;

public class PolymorphicTester {

	public static void main(String[] args) {
		ArrayList<DessertItem> listI = new ArrayList<DessertItem>();
		ArrayList<DessertItem> listC = new ArrayList<DessertItem>();
		ArrayList<DessertItem> listCndy = new ArrayList<DessertItem>();
		ArrayList<DessertItem> listS = new ArrayList<DessertItem>();
		ArrayList<ArrayList<DessertItem>> master = new ArrayList<ArrayList<DessertItem>>();
		master.add(listI);
		master.add(listC);
		master.add(listCndy);
		master.add(listS);
		
		
		
		listI.add(new Icecream("Cheapest", 32, 1));
		listS.add(new Sundae("2",32,1,1));
		listS.add(new Sundae("3",32,1,2));
		listI.add(new Icecream("4", 32, 15));
		listC.add(new Cookie("5", 32, 10, 500));
		listC.add(new Cookie("6", 32, 10, 510));
		listCndy.add(new Candy("7", 32, 10, 50000));
		listCndy.add(new Candy("Most Expensive", 32, 10, 50000));
		// Uses compareTo with every combination in master  This should be sufficient to show polymorphism works on every combo.
		//compareTo uses  getCost on all the objects in every combinations
		for(ArrayList<DessertItem> list:master) {
			for(DessertItem d: list) {
				System.out.println(d.getName() + " compared to:");
				for(ArrayList<DessertItem> sub:master) {
					
					for(DessertItem e: sub) {
						System.out.println(e.getName()+ " evaluates to: " + d.compareTo(e));
					}
				}
				System.out.println();
			
			}
		}
		
		
		
		
		

	}

}
