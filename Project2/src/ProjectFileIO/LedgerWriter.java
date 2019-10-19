package ProjectFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LedgerWriter{
	private PrintWriter write;
	
	public LedgerWriter() {
		try {
			this.write = new PrintWriter("sales.txt");
		} catch (FileNotFoundException e) {
			System.out.println("This should never happen lol");
			e.printStackTrace();
		}
	}
	
	public LedgerWriter(String dest) {
		try {
			this.write = new PrintWriter(dest);
		} catch (FileNotFoundException e) {
			System.out.println("This should never happen lol");
			e.printStackTrace();
		}
	}
	
	public void addNewSale(String sale) {
		//One liner to find the amount of occurrences of ';' in our sale
		int count = sale.length() - sale.replace(";", "").length();
		if(count!=3) {
			throw new IllegalArgumentException();
		}else if(sale.split(";")[1]=="") { //Split the sale into the correct amount of strings, we know we won't get an error with the array index because we insure we have 3 semicolons and thus 4 strings in the first if.
			throw new IllegalArgumentException();
		}else {
			write.println(sale);
		}
	}
	public void close() {
		write.close();
	}
	
	
	
}
