package ProjectFileIO;

/**
 * Tester for the Ledger program.
 * Runs on a console UI, using user input from their keyboard.
 * Arguments not needed on program start, though user input is required during run-time.
 * @author Alexander Dung
 *
 */
public class LedgerTester {
	/**
	 * Initialize a LedgerUI and begin program loop.
	 * @param args unused program start arguments
	 */
	public static void main(String[] args) {
		LedgerUI ledger = new LedgerUI();
		ledger.beginMenu();
	}
}
