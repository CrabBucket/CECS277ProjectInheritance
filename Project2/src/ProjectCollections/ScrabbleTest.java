package ProjectCollections;

import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Program to compare the efficiency of the HashMap and TreeMap objects.
 * Times the speed of the chosen Map's put() function, and the speed of its get() function.
 * Analysis is at the bottom of the source code file.
 * @author Alexander Dung
 *
 */
public class ScrabbleTest {
	public static void main(String[] args) {
		//print working directory for convenience
		String dir = System.getProperty("user.dir");
		System.out.println("Current Working Directory: " + dir);
		//declare 'dummy' maps
		Map<String, Integer> wordToScore; 
		Map<Character, Integer> letterToScore;
		//if user did not add a run argument, quit program
		if(args.length != 1) {
			System.out.println("Please enter \"hashmap\" or \"treemap\" as a run argument.");
			return;
		}
		//if user entered 'hashmap', initialize Maps as HashMaps
		if(args[0].toLowerCase().equals("hashmap")) {
			System.out.println("Using HashMaps.");
			wordToScore = new HashMap<String, Integer>();
			letterToScore = new HashMap<Character, Integer>();
		}
		//if user entered 'treemap', initialize Maps as TreeMaps
		else if(args[0].toLowerCase().equals("treemap")) {
			System.out.println("Using TreeMaps.");
			wordToScore = new TreeMap<String, Integer>();
			letterToScore = new TreeMap<Character, Integer>();
		}
		//if user entered anything else, quit program
		else {
			System.out.println("Please enter \"hashmap\" or \"treemap\" as a run argument.");
			return;
		}
		//find file for letters and their Scrabble values.
		File values = new File(dir, "/src/ProjectCollections/values.txt");
		//if file does not exist, quit program.
		if(!values.exists()) {
			System.out.println("File values.txt cannot be found! Please place values.txt in the above working directory!");
			return;
		}
		//find file for words whose Scrabble values to calculate
		File words = new File(dir, "/src/ProjectCollections/words.txt");
		//if file does not exist, quit program.
		if(!words.exists()) {
			System.out.println("File words.txt cannot be found! Please place words.txt in the above working directory!");
			return;
		}
		//create Scanners to read aforementioned files
		try(Scanner valIn = new Scanner(values); Scanner wordIn = new Scanner(words)){
			//start measuring time to add letter values
			long charStartTime = System.nanoTime();
			//read to the end of the file
			while(valIn.hasNext()) {
				//take in a letter and its Scrabble value
				String tempString = valIn.nextLine();
				//parse the character
				char tempChar = tempString.charAt(0);
				//parse the character's Scrabble value
				int tempInt = Integer.parseInt(tempString.substring(2));
				System.out.println(String.format("Parsed character %s and value %d.", tempChar, tempInt));
				//add the letter and its Scrabble value to the map, with the letter as the key
				letterToScore.put(tempChar, tempInt);
			}
			//end measurement, and print results
			long charEndTime = System.nanoTime();
			System.out.println("Time for loading chars and their values is: " + (charEndTime - charStartTime) + " nanoseconds.");
			System.out.println("End:" + charEndTime + "\nStart:" + charStartTime + "\n\n");
			
			//begin measuring time to add words and their Scrabble values
			long wordStartTime = System.nanoTime();
			ArrayList<String> wordList = new ArrayList<String>(25);
			//read to the end of the file
			while(wordIn.hasNext()) {
				//take in a word
				String tempString = wordIn.nextLine();
				//start accumulating its letter score by iterating through each character and using it as a key for the char-int map
				int tempInt = 0;
				for(char ch : tempString.toCharArray()) {
					tempInt += letterToScore.get(ch);
				}
				System.out.println(String.format("Processed word %s with value %d", tempString, tempInt));
				//add the word and its Scrabble value to the map, with the word as the key
				wordToScore.put(tempString, tempInt);
				wordList.add(tempString);
			}
			//end measurement, and print results
			long wordEndTime = System.nanoTime();
			System.out.println("Time for loading words and their values is: " + (wordEndTime - wordStartTime) + " nanoseconds.");
			System.out.println("End:" + wordEndTime + "\nStart:" + wordStartTime + "\n\n");
			//begin measuring time to find words and their Scrabble values
			long findStartTime = System.nanoTime();
			//iterate through each word read from file, print the words and its Scrabble value, accessing the value through the map
			for(String str : wordList) {
				System.out.println(String.format("Word: %-10s Value: %d points", str, wordToScore.get(str)));
			}
			//end measurement, and print results
			long findEndTime = System.nanoTime();
			System.out.println("Time for finding words and their values is: " + (findEndTime - findStartTime) + " nanoseconds.");
			System.out.println("End:" + wordEndTime + "\nStart:" + wordStartTime);
			System.out.println(String.format("Time 1: %-10d Time 2: %-10d Time 3: %-10d", (charEndTime - charStartTime), (wordEndTime - wordStartTime), (findEndTime - findStartTime)));	
		}
		catch(FileNotFoundException e) {
			System.out.println("File values.txt or words.txt cannot be found in working directory. Exiting program.");
			e.printStackTrace();
		}
	}
}

/* 	ANALYSIS
 * 	TREEMAP RESULTS (NANOSECONDS):
 * 		LOADING CHARS		LOADING STRINGS		ACCESSING INTS
 * 	1.	9053700				4531900				3058800
 * 	2.	9013500				4525200				3419800
 * 	3.	8638900				4905600				3317900
 * 	4.	9524900				4721300				2960900
 * 	5.	8787500				4702300				3167600
 * 	6.	8652200				4120700				3405700
 * 	7.	8291300				4799100				3407100
 * 	8.	8718300				4640200				3496300
 * 	9.	9734500				4509500				3329500
 * 10.	8680500				4043200				2312000
 * AVG:	8909530				4549900				3187560
 * 
 * 	HASHMAP RESULTS (NANOSECONDS):
 * 		LOADING CHARS		LOADING STRINGS		ACCESSING INTS
 * 	1.	9130400				4579400				3222800
 * 	2.	9231800				4153900				3509200
 * 	3.	8525000				4181200				3283400
 * 	4.	8132100				4722000				3554400
 * 	5.	8287000				4383400				3667100
 * 	6.	8528500				4484800				2486300
 * 	7.	8750600				4309500				3248700
 * 	8.	8619000				4251000				3013900
 * 	9.	8407800				4327700				2918000
 * 10.	8529000				4688100				3174800
 * AVG:	8614120				4408100				3207860
 * 	
 * 	COMPARISON
 * 				LOADING CHARS		LOADING STRINGS		ACCESSING INTS
 * 	TREEMAP	|	8909530				4549900				3187560
 * 	HASHMAP	|	8614120				4408100				3207860
 * 	WINNER	|	HASHMAP				HASHMAP				TREEMAP
 * 	
 * 	When it comes to loading data, the HashMap is more efficient. This is likely because the HashMap does not need to iterate through its data and make comparisons at each step like a TreeMap does when adding new data.
 * 	On the other hand, because the TreeMap is sorted, retrieving data with it is more efficient than with the HashMap.
 */
