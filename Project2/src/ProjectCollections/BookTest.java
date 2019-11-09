package ProjectCollections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;

/**
 * Program to compare the efficiency of the HashSet and TreeSet objects.
 * Times the speed of the Sets' add() and contains() functions.
 * Analysis is at the bottom of the source code file.
 * @author Alexander Dung
 *
 */
public class BookTest {
	public static void main(String[] args) {
		//print working directory for convenience
		String dir = System.getProperty("user.dir");
		System.out.println("Current Working Directory: " + dir);
		//declare "dummy" Set
		Set<String> set;
		//if user did not enter one argument, quit program
		if(args.length != 1) {
			System.out.println("Please enter \"hashset\" or \"treeset\" to use this program.");
			return;
		}
		//if user entered 'hashset', change dummy Set to HashSet
		if(args[0].toLowerCase().equals("hashset")) {
			System.out.println("Using HashSet.");
			set = new HashSet<String>();
		}
		//if user entered 'treeset', change dummy Set to TreeSet
		else if(args[0].toLowerCase().equals("treeset")) {
			System.out.println("Using TreeSet.");
			set = new TreeSet<String>();
		}
		//if user entered anything else, quit program
		else {
			System.out.println("Please enter \"hashset\" or \"treeset\" to use this program.");
			return;
		}
		//find file that contains text to read into Set
		File textFile = new File(dir, "/src/ProjectCollections/alice.txt");
		//if file does not exist, quit program
		if(!textFile.exists()) {
			System.out.println("File alice.txt cannot be found! Please place alice.txt in the above working directory!");
			return;
		}
		//create Scanner for aforementioned file
		try(Scanner text = new Scanner(textFile)){
			//start measuring time to add all words from the file
			long readStartTime = System.nanoTime();
			//read words one-by-one into the Set, removing all non alphabet characters and setting to lowercase to prevent technical duplicates
			while(text.hasNext()) {
				set.add(text.next().replaceAll("[^a-zA-Z]", "").toLowerCase());
			}
			//end measurement, and print results
			long readEndTime = System.nanoTime();
			System.out.println("Time for reading all of the book is: " + (readEndTime - readStartTime) + " nanoseconds.");
			System.out.println("Set contains: " + set);
			//start measuring time to find a word in the Set 100 times
			System.out.println("Attempting to find the word \"drunk\" in the set 100 times...");
			long findStartTime = System.nanoTime();
			//find one word 100 times, and print whether the word is present in the Set each time
			for(int count = 0; count < 100; count++) {
				System.out.println(set.contains("drunk"));
			}
			//end measurement, and print results
			long findEndTime = System.nanoTime();
			System.out.println("Time for finding \"drunk\" 100 times is: " + (findEndTime - findStartTime) + " nanoseconds.");
			System.out.println(String.format("Time 1: %-10d Time 2: %-10d", (readEndTime - readStartTime), (findEndTime - findStartTime)));
		}
		catch(FileNotFoundException e) {
			System.out.println("File alice.txt could not be found in the working directory. Exiting program.");
			e.printStackTrace();
		}
	}
}

/*	ANALYSIS
 * 	TREESET RESULTS (NANOSECONDS):
 * 		LOADING STRINGS		FINDING STRINGS
 *	1.	267018900			6025100
 *	2.	299306300			5255900
 *	3.	286127100			6202900
 *	4.	272433200			5542900
 *	5.	277584200			6218100
 *	6.	292649500			5600200
 *	7.	242119900			5886400
 *	8.	244337900			6676300
 *	9.	274947300			5312800
 * 10.	284953700			6052200
 * AVG:	274147800			5877280
 * 
 * HASHSET RESULTS (NANOSECONDS):
 * 		LOADING STRINGS		FINDING STRINGS
 *	1.	225379700			6099700
 *	2.	251796300			5269000
 *	3.	235698500			6405300
 *	4.	219703600			10866700
 *	5.	192031600			5255700
 *	6.	258150300			5936000
 *	7.	260046800			5994800
 *	8.	275650700			5817600
 *	9.	235280500			5974100
 * 10.	246340300			6439000
 * AVG:	240007830			6405790
 * 
 * COMPARISON
 * 				LOADING STRINGS		FINDING STRINGS
 * TREESET	|	274147800			5877280
 * HASHSET	|	240007830			6405790
 * WINNER	|	HASHSET				TREESET
 * 
 * Similarly to the Scrabble test between the HashMap and TreeMap, the HashSet is faster in loading data likely because it does not have to iterate through its data like the TreeMap does.
 * On the other hand, because the TreeMap is sorted, accessing and searching through its data is faster than the HashMap.
 * 
 */
