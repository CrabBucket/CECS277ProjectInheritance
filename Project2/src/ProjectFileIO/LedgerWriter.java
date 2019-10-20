package ProjectFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LedgerWriter{
	private PrintWriter write;
	
	public LedgerWriter() {
		try {
			this.write = new PrintWriter("sales.txt");
		} catch (FileNotFoundException e) {
			System.out.println("sales.txt does not exist.");
			e.printStackTrace();
		}
	}
	
	public LedgerWriter(String dest) {
		try {
			this.write = new PrintWriter(dest);
		} catch (FileNotFoundException e) {
			System.out.println(String.format("%s does not exist.", dest));
			e.printStackTrace();
		}
	}
	
	public void addNewSale(String sale) {
		//One liner to find the amount of occurrences of ';' in our sale
		int count = sale.length() - sale.replace(";", "").length();
		//verify that the entered data represent an actual sale - only service type and price are important.
		if(count != 3) {
			throw new IllegalArgumentException(); 
		//Split the sale into the correct amount of strings, we know we won't get an error with the array index because we insure we have 3 semicolons and thus 4 strings in the first if.
		}else if(sale.split(";")[1]=="") { //if the service is an empty string, throw error because a file with a blank name cannot be created.
			throw new IllegalArgumentException();
		}else if(!isValidPrice(sale.split(";")[2])){ //if the price is not a valid price, throw error.
			throw new IllegalArgumentException();
		}else if(!isValidDate(sale.split(";")[3])){ //if the date does not follow mm/dd/yyyy format, throw error
			throw new IllegalArgumentException();
		}else {
			write.println(sale);
		}
	}
	
	public void close() {
		write.close();
	}

	private boolean isValidPrice(String possiblePrice) {
		double testDouble = -1;
		try {
			testDouble = Double.parseDouble(possiblePrice); //if the String cannot be cast to a double, return false
		}
		catch(Exception e) {
			return false;
		}
		if(testDouble < 0) return false; //String can be cast to a double. therefore, we can check whether the price is valid.
		return true;
	}

	public static boolean isValidDate(String possibleDate) {
		if(possibleDate.length() != 10) return false; //if string doesn't fit mm/dd/yyyy length, is invalid
		else if(possibleDate.charAt(2) != '/' || possibleDate.charAt(5) != '/') return false; //if slashes aren't in correct place, is invalid
		boolean isInts = true;
		for(int index = 0; index < possibleDate.length(); index++) {
			if(index != 2 && index != 5 && (possibleDate.charAt(index) < '0' || possibleDate.charAt(index) > '9')) //if any non-slash chars are not integers, is invalid
				isInts = false;
		}
		return isInts;
	}
}
