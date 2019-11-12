package ProjectCollections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


/**
 * Program to test the speed of linkdlists vs arraylists.
 * 
 * Uses the idea that the shortest time it takes use .add .get and to iterate is probably the cpu time.
 * 
 * Taking averages for anything besides the last test would also average out the wait time of the OS scheduling other tasks
 * during the process.
 * 
 * @author Thomas McSwain
 *
 */
public class ScavengerHunt {
	
	/**
	 * The main method.
	 * 
	 * Runs everything and takes in a command line arg to pick between linkedlists and arraylists.
	 * @param args args[0] is taken as the command line flag to determine wheterh to use arraylist or linked lists.
	 */
	public static void main(String args[]) {
		List<List<String>> teamlist;
		List<String> list;
		// Used once to due to how profile it's easier to just reassign teamlist.
		boolean isLinkedList = false;
		//Checks to make sure they only used a single command line input.
		if(args.length != 1) {
			System.out.println("Please enter only \"ArrayList\" or \"LinkedList\" to use this program.");
			return;
		}else {
			//If they want linked lists we make a linked list.
			if(args[0].toLowerCase().equals("linkedlist")) {
				System.out.println("Using LinkedList.");
				list = new LinkedList<String>();
				teamlist = new LinkedList<List<String>>();
				isLinkedList = true;
			// If they want an arraylist we make an arraylist
			}else if(args[0].toLowerCase().equals("arraylist")){
				System.out.println("Using ArrayList.");
				list = new ArrayList<String>();
				teamlist = new ArrayList<List<String>>();
			// Else we quit if they didn't properly enter a valid data structure.
			}else {
				System.out.println("Please enter \"ArrayList\" or \"LinkedList\" to use this program.");
				return;
			}
		}
		// Main area of the program instantiates file path.
		try {
			File objects = new File(System.getProperty("user.dir")+"/src/ProjectCollections/itemlist.txt");
			//Checks the file path is valid else exits by throwing exception.
			if(!objects.exists()) {throw new FileNotFoundException();};
			// Instantiating the buffered reader to get the item list for the scavenger hunt.
			try {
				BufferedReader reader = new BufferedReader(new FileReader(objects));
				for(int i = 0;i < 100;++i) {
					list.add(reader.readLine());
				}
				reader.close();
				ListIterator<String> iter = list.listIterator();
				ArrayList<Long> actualTimes = new ArrayList<Long>();
				//The loop that traverses forweards and backwards through the list.
				//Repeats this 1,000,000 times
				//Adds all those times to a list actualTimes.
				for(int i = 0;i<1000000;++i) {
					long startTraverse = System.nanoTime();
					while(iter.hasNext()) {
						iter.next();
					}
					while(iter.hasPrevious()) {
						iter.previous();
					}
					actualTimes.add(System.nanoTime()-startTraverse);
				}
				//This for loop finds the smallest time in the list, we use this as the time it took to traverse the list
				//without os scheduling interuptions.
				long smallestTraverseTime = Long.MAX_VALUE;
				for(Long num:actualTimes) {
					if(num<smallestTraverseTime) {
						smallestTraverseTime = num;
					}
				}
				System.out.println(smallestTraverseTime + " Time to traverse in nanoseconds");
				//This while loop is used to keep trying the main loop of the user input section.
				// If they input an invalid number of teams it tries again.
				// IF they input an invalid index it tries again.
				BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
				while(true) {
					System.out.println("How many teams are there?");
					try {
						String input = userinput.readLine();
						int teams = Integer.parseInt(input);
						if(teams<1) {
							throw new NumberFormatException();
						}
						ArrayList<Long> actualTeams = new ArrayList<Long>();
						int testOver = 10000;
						//Similar to the first profiling of iteration this profiles creating a bunch of copies
						//of the list for each type.
						for(int j = 0; j<testOver;++j) {
							long totalTeams = 0;
							//If it's a linked list we create a new linked list and add each element in our scavenger list to a templist
							//We then add that templist to the teamlist.
							if(isLinkedList) {
								for(int i = 0;i < teams; ++i) {
									teamlist = new LinkedList<List<String>>();
									long startTeams = System.nanoTime();
									LinkedList<String> templist = new LinkedList<String>();
									
									while(iter.hasNext()) {
										templist.add(iter.next());
									}
									while(iter.hasPrevious()) {
										iter.previous();
									}
									teamlist.add(templist);
									totalTeams += System.nanoTime() - startTeams;
									Collections.shuffle(list);																
								}
								actualTeams.add(totalTeams);
							//If it's a linked list we create a new linked list and add each element in our scavenger list to a templist
							//We then add that templist to the teamlist.
							}else {
								for(int i = 0;i < teams; ++i) {
									teamlist = new ArrayList<List<String>>();
									long startTeams = System.nanoTime();
									ArrayList<String> templist = new ArrayList<String>();
									
									while(iter.hasNext()) {
										templist.add(iter.next());
									}
									while(iter.hasPrevious()) {
										iter.previous();
									}
									teamlist.add(templist);
									totalTeams += System.nanoTime() - startTeams;
									Collections.shuffle(list);
								}
								actualTeams.add(totalTeams);
							}
						}
						//Finds the smallest time it took and prints it.
						long smallest = Long.MAX_VALUE;
						for(Long num:actualTeams) {
							if(num<smallest) {
								smallest = num;
							}
						}
						System.out.println(smallest/teams + " Number of nanoseconds per team in nanoseconds");

						
						System.out.println("Please enter the index you wish to insert/get from");
						
						int userindex = Integer.parseInt(userinput.readLine());
						
						ArrayList<Long> getTimes = new ArrayList<Long>();
						
						
						// The profiling loop for geting an element from user index.
						// Works the same way as previous times but this time we profile .get for each structure
						for(int i = 0;i<100000;++i) {
							Long start = System.nanoTime();
							for(List<String> team:teamlist) {
								team.get(userindex);
								
							}
							getTimes.add(System.nanoTime()-start);
						}
						long smallestgetTime = Long.MAX_VALUE;
						for(Long num:getTimes) {
							if(num<smallestgetTime) {
								smallestgetTime = num;
							}
						}
						
						ArrayList<Long> addTimes = new ArrayList<Long>();
						
						// The profiling loop for adding an element from user index.
						// Works the same way as previous times but this time we profile .add for each structure
						// Removes the added element as well but does so outside the timing area of the code.
						// Counts the time to add to each team.
						for(int i = 0;i<100000;++i) {
							Long start = System.nanoTime();
							long singletime = 0;
							for(List<String> team:teamlist) {
								
								team.add(userindex,"testadd");
								singletime += System.nanoTime() - start;
								team.remove(userindex);
								
							}
							addTimes.add(singletime);
							
							
						}
						
						//Finds the smallest addTime
						long smallestaddTime = Long.MAX_VALUE;
						for(Long num:addTimes) {
							if(num<smallestaddTime) {
								smallestaddTime = num;
							}
						}
						System.out.println(smallestgetTime + " The time to .get the user's index in nanoseconds");
						System.out.println(smallestaddTime + " The time to .insert the user's index in nanoseconds");
						Random rand = new Random(System.nanoTime());
						
						
						//Uses Random to get a random index
						//I just used a raw average here
						// I also had this idea of getting a bunch of averages then getting the median average.
						//But I think I am just ok with it being variable.
						long randStart = System.nanoTime();
						long totalListTime = 0;
						for(int i = 0;i<100000;i++) {
							int randindex = rand.nextInt(100);
							randStart = System.nanoTime();
							list.get(randindex);
							totalListTime += System.nanoTime() - randStart;
							
						}
						long aveRandTime = totalListTime/100000;
						System.out.println(aveRandTime + " The average time to .get any index in nanoseconds.");
						break;
						
					}catch(NumberFormatException e){
						System.out.println("Please enter a valid integer");
						continue;
					}catch(IndexOutOfBoundsException e) {
						System.out.println("Please enter an index between 0-99");
					}
					
				}
				
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("Error creating reader");
				return;
				
			}
		}catch (FileNotFoundException e) {
			System.out.println("Couln't find itemlist");
			e.printStackTrace();
			return;
		}
		
	}
}

//Using ArrayList.
//199 Time to traverse in nanoseconds
//How many teams are there?
//10
//1399 Number of nanoseconds per team in nanoseconds
//Please enter the index you wish to insert/remove from
//15
//99 The time to .get the user's index in nanoseconds
//199 The time to .insert the user's index in nanoseconds
//103 The average time to .get any index in nanoseconds.



//Using LinkedList.
//1000 Time to traverse in nanoseconds
//How many teams are there?
//10
//2009 Number of nanoseconds per team in nanoseconds
//Please enter the index you wish to insert/remove from
//15
//99 The time to .get the user's index in nanoseconds
//100 The time to .insert the user's index in nanoseconds
//153 The average time to .get any index in nanoseconds.


//I was very suprised it took so much longer to traverse a LinkedList vs an ArrayList 
//I expected the same time to do most operations besides .get
//It leads me to believe I may not have implemented something correctly but it's the same implementation for both
//So I maybe be able to implement a faster way to create lists for linkedlists then my current method
//Something I did expect was faster .add for the user's index for linkedlists, since for the linkedlist we can start from the beginning
//Move to 15 then just add the node.  But for the arraylist we have to fix all the nodes after 15.

