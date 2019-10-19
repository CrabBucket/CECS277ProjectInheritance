package ProjectFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LedgerOrganizer {
	private HashMap<String,LedgerWriter> map;
	private File master;
	private Scanner scan;
	
	public LedgerOrganizer(String filename) throws FileNotFoundException {
		master = new File(filename);
		if(!master.exists()) {
			throw new FileNotFoundException();
		}else {
			scan = new Scanner(master);
		}
		map = new HashMap<String,LedgerWriter>();
	}
	
	
	public void organize() {
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String service = line.split(";")[1];
			if(map.containsKey(service)) {
				map.get(service).addNewSale(line);
			}else {
				map.put(service, new LedgerWriter(service+".txt"));
				map.get(service).addNewSale(line);
			}
		}
	}
	public void close() {
		//HashMaps foreach function takes in a lambda expression and does said expression all key,value pairs.
		//So my lambda takes the (service,writer) pair then just does writer.close() to close all the writers.
		map.forEach((service,writer) -> writer.close());
	}
	public static void main(String[] args) throws FileNotFoundException {
		LedgerOrganizer lo = new LedgerOrganizer("sales.txt");
		lo.organize();
		lo.close();
	}
}
