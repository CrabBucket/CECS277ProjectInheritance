package ProjectBinaryIO;

/**
 * 
 * @author Guy
 *
 */
public class IceCreamTester {
	public static void main(String[] args) {
		CareTaker saver = new CareTaker();
		AdvancedIceCreamCone cone1 = new AdvancedIceCreamCone();
		AdvancedIceCreamCone cone2 = new AdvancedIceCreamCone();
		cone2.addScoop();
		cone2.setFlavor("choco");
		saver.saveMemento(cone1.createMemento());
		Memento temp = cone2.createMemento();
		saver.saveMemento(temp);
		cone2.addScoop();
		temp = cone2.createMemento();
		saver.saveMemento(temp);
		AdvancedIceCreamCone cone3 = new AdvancedIceCreamCone();
		cone3.restore((Memento)saver.readMemento());
		System.out.println(cone3);
		cone3.restore((Memento)saver.readMemento());
		System.out.println(cone3);
		cone3.restore((Memento)saver.readMemento());
		System.out.println(cone3);
	}
}
