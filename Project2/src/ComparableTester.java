import java.util.ArrayList;
import java.util.Collections;

public class ComparableTester {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		ArrayList<DessertItem> list = new ArrayList<DessertItem>();
		
		list.add(new Icecream("Cheapest", 32, 1));
		list.add(new Sundae("2",32,1,1));
		list.add(new Sundae("3",32,1,2));
		list.add(new Icecream("4", 32, 15));
		list.add(new Cookie("5", 32, 10, 500));
		list.add(new Cookie("6", 32, 10, 510));
		list.add(new Candy("Most Expensive", 32, 10, 50000));
		Collections.shuffle(list);
		// Candy() should have cost 0 so any other DessertItem should be larger
		DessertItem expensive = new Candy();
		
		for(DessertItem d:list) {
			expensive = DessertItem.max(expensive, d);
		}
		//Should print the most expensive dessert item, it does
		System.out.println(expensive.getName());
		System.out.println();
		Collections.shuffle(list);
		//Print objects shuffled.
		for(DessertItem d:list) {
			System.out.println(d.getName());
		}
		//Print objects sorted using Collections.sort
		Collections.sort(list);
		System.out.println();
		for(DessertItem d:list) {
			System.out.println(d.getName());
		}
	}

}
