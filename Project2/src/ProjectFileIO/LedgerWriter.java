package ProjectFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Writers and Validates Sales to a ledger sales.txt
 * @author Thomas McSwain
 */
public class LedgerWriter{
	private PrintWriter write;
	
	
	/** 
	 * Initializes LedgerWriter to sales.txt
	 */
	public LedgerWriter() {
		try {
			this.write = new PrintWriter("sales.txt");
		} catch (FileNotFoundException e) {
			System.out.println("sales.txt does not exist.");
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * /** 
	 * Initializes LedgerWriter to dest
	 *
	 * @param dest Filename of the ledger
	 */
	public LedgerWriter(String dest) {
		try {
			this.write = new PrintWriter(dest);
		} catch (FileNotFoundException e) {
			System.out.println(String.format("%s does not exist.", dest));
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * Validates then adds a new sale to the ledger
	 * @param sale Sale to be added.
	 */
	public void addNewSale(String sale) {
		//One liner to find the amount of occurrences of ';' in our sale
		int count = sale.length() - sale.replace(";", "").length();
		//Verify that the entered data represent an actual sale - no real need to check payer name.
		if(count != 3) {
			throw new IllegalArgumentException(); 
		}
		//Split the sale into the correct amount of strings, we know we won't get an error with the array index because we insure we have 3 semicolons and thus 4 strings in the first if.
		//If the service is an empty string, throw error because a file with a blank name cannot be created.
		else if(sale.split(";")[1]=="") { 
			throw new IllegalArgumentException();
		}
		//If the price is not a valid price, throw error.
		else if(!isValidPrice(sale.split(";")[2])){ 
			throw new IllegalArgumentException();
		}
		//If the date does not follow mm/dd/yyyy format, throw error.
		else if(!isValidDate(sale.split(";")[3])){ 
			throw new IllegalArgumentException();
		}
		//All tests have been passed, therefore sale is valid and is written into ledger.
		else{
			write.println(sale);
		}
	}
	/**
	 * Closes printwriter
	 */
	public void close() {
		write.close();
	}

	
	/** 
	 * Returns true if possiblePrice can be parsed as a double
	 * @param possiblePrice String to be parsed
	 * @return boolean True if possiblePrice can be parsed as a double otherwise false.
	 */
	private boolean isValidPrice(String possiblePrice) {
		double testDouble = -1;
		//If the String cannot be cast to a double, return false. Otherwise, continue.
		try {	
			testDouble = Double.parseDouble(possiblePrice); 
		}
		catch(Exception e) {
			return false;
		}
		//String can be cast to a double. Therefore, we can check whether the price is valid (a positive number, or 0).
		if(testDouble < 0) return false; 
		return true;
	}

	
	/** 
	 * Checks if possibleDate is a valid date
	 * @param possibleDate Date to be checked
	 * @return boolean True if possibleDate is a valid date false otherwise.
	 */
	public static boolean isValidDate(String possibleDate) {
		//Require all dates to follow the mm/dd/yyyy format
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//Set SimpleDateFormat to not allow unrealistic dates
		dateFormat.setLenient(false);
		//If the Date can be created with the SimpleDateFormat, then the date is valid. Return true.
		try {
			Date testDate = dateFormat.parse(possibleDate);
			return true;
		}
		//If an error is thrown, it is invalid. Return false.
		catch(ParseException e) {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(isValidDate(""));
		System.out.println(isValidDate("01/01/2001"));
		System.out.println(isValidDate("1/10/2012"));
		System.out.println(isValidDate("13/01/2000"));
		System.out.println(isValidDate("12/32/2000"));
	}
}
