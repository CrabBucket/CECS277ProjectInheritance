package ProjectFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Organizes and creates a ledger for each service then writes the sales associated with the service to the
 * @author Thomas McSwain
 */
public class LedgerOrganizer {
	private HashMap<String,LedgerWriter> map;
	private File master;
	private Scanner scan;
	
	
	/** 
	 * Looks for filename if it exists it creates the LedgerOrganizer if not throws FileNotFoundException
	 * @param filename filename that points to the master ledger
	 * @throws FileNotFoundException Thrown when it cannot find the master ledger
	 */
	public LedgerOrganizer(String filename) throws FileNotFoundException {
		master = new File(filename);
		//if master doesnt exist throw exception
		if(!master.exists()) {
			throw new FileNotFoundException();
		}else {
			//else create init the scanner
			scan = new Scanner(master);
		}
		// Init empty has map
		map = new HashMap<String,LedgerWriter>();
	}
	
	/**
	 * Goes through the master ledger writing each sale to the associated service ledger
	 */
	public void organize() {
		//While the ledger has more sales
		while(scan.hasNext()) {
			// Store the sale to line
			String line = scan.nextLine();
			// Grab the service name from the sale
			String service = line.split(";")[1];
			//If the service is already in the key we simply write to that services LedgerWriter
			if(map.containsKey(service)) {
				map.get(service).addNewSale(line);
			}else {
				//Else we add a new ledgerwriter to the map associated with the service the write teh sale to that ledger
				map.put(service, new LedgerWriter(service+".txt"));
				map.get(service).addNewSale(line);
			}
		}
	}
	/**
	 * Closes all the LedgerWriters in our map.
	 */
	public void close() {
		//HashMaps for each function takes in a lambda expression and does said expression all key,value pairs.
		//So my lambda takes the (service,writer) pair then just does writer.close() to close all the writers.
		map.forEach((service,writer) -> writer.close());
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		LedgerOrganizer lo = new LedgerOrganizer("sales.txt");
		lo.organize();
		lo.close();
	}
}
