package ProjectFileIO;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Console UI for a ledger-writing program.
 * Prompts the user to either enter a new sale into the ledger or to quit the program and organize the ledger into multiple files by service type.
 * Gets user input for menu choices and sale information.
 * @author Alexander Dung
 *
 */
public class LedgerUI {
	private Scanner uInput;
	private LedgerWriter writer;
	private LedgerOrganizer organizer;
	
	/**
	 * Default constructor - attempts to initialize a LedgerWriter and LedgerOrganizer to a file sales.txt in the working directory.
	 * If it throws an error, lets the user know.
	 */
	public LedgerUI() {
		//Initialize Scanner for user input.
		this.uInput = new Scanner(System.in);
		try {
			//Try to initialize the writer and organizer. Print file destination for quality of life.
			File destFile = new File("sales.txt");
			System.out.println("New file (master ledger) created in:" + destFile.getAbsolutePath());
			this.writer = new LedgerWriter();
			this.organizer = new LedgerOrganizer("sales.txt");
		}
		catch(FileNotFoundException e) {
			//This shouldn't happen unless the directory is read-only.
			System.out.println("sales.txt cannot be created for some reason.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Prompts user for their menu choice.
	 * Records input and validates. If input is valid, returns it.
	 * Otherwise, prompts user again until a valid input is entered.
	 * Valid inputs are 1 and 2.
	 * 
	 * @return int 1 or 2, reflecting user menu choice
	 */
	public int promptMenuChoice() {
		//Print menu prompt.
		System.out.println("Main Menu\n1) Add new sale\n2) Organize ledger and quit");
		//Prepare to record user input.
		int userInput = 0;
		boolean inputIsValid = false;
		//Begin user input loop.
		while(!inputIsValid) {
			//Only record user input if it is an integer.
			if(uInput.hasNextInt()) {
				//User input is an integer, so record.
				userInput = uInput.nextInt();
				//If user input is a valid menu choice, break from loop.
				if(userInput == 1 || userInput == 2) inputIsValid = true;
				//Because nextInt() is used, must clear buffer after use.
				uInput.nextLine();
			}
			//If user input is not an integer, ignore and print reminder.
			else {
				System.out.println("Please enter a valid menu choice - 1 or 2.");
				uInput.nextLine();
			}
		}
		return userInput;
	}
	
	/**
	 * Prompts user for input on data for a new sale to write to the master ledger.
	 * Prompts for buyer's name, then service type, then price, then date.
	 * Records input for each then concatenates them into a single String, each input split by a semicolon(;).
	 * Then returns that String.
	 * @return String containing non-validated data for a new sale to write into the master ledger.
	 */
	public String promptNewSale() {
		//Create list of what to prompt user.
		String[] currentPrompt = {"buyer's name", "service", "price", "date (MM/DD/YYYY with leading zeroes)"};
		//Prepare to record user input.
		String sale = "";
		int currentPromptStage = 0;
		//Begin prompting loop.
		while(currentPromptStage < 4) {
			//Print prompt for current data required.
			System.out.println(String.format("Please enter the %s for this new sale:", currentPrompt[currentPromptStage]));
			//Record all data into a single String, separated by a semicolon.
			sale += uInput.nextLine() + ";";
			//After user enters any data, prompt for next piece of data.
			currentPromptStage++;
		}
		//Return saved user input, without the extraneous semicolon at the end.
		return sale.substring(0, sale.length() - 1);
	}
	
	/**
	 * Begins loop prompting user to either input data for a new sale or to quit the program and organize sales from the master.
	 * If user inputs a sale, also lets them know whether the sale was processed correctly and written into the ledger, or not.
	 * If user chooses to organize the ledger, creates new ledgers for each service type and writes into them.
	 */
	public void beginMenu() {
		boolean userContinues = true;
		//Begin prompting loop.
		while(userContinues) {
			//Prompt user for menu choice.
			switch(promptMenuChoice()) {
				//If user chooses menu option 1, prompt user for sale info. If sale info is valid, will write to master ledger.
				case 1:
					try {
						this.writer.addNewSale(this.promptNewSale());
						System.out.println("Sale processed correctly.");
					}
					//If invalid, let user know. Nothing happens.
					catch(InvalidSaleException e) {
						System.out.println("Sale processed incorrectly.");
					}
					break;
				//If user chooses menu option 2, end writing to master ledger, then organize data by service type.
				case 2:
					System.out.println("Goodbye.");
					this.writer.close();
					this.organizer.organize();
					this.organizer.close();
					userContinues = false;
					break;
				//If user enters an invalid menu choice, let them know. This typically should not happen.
				default:
					System.out.println("Menu choice invalid.");
			}
		}
	}

}
