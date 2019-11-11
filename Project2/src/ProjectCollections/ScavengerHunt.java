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

public class ScavengerHunt {
	
	
	public static void main(String args[]) {
		List<List<String>> teamlist;
		List<String> list;
		boolean isLinkedList = false;
		if(args.length != 1) {
			System.out.println("Please enter \"ArrayList\" or \"LinkedList\" to use this program.");
			return;
		}else {
			if(args[0].toLowerCase().equals("linkedlist")) {
				System.out.println("Using LinkedList.");
				list = new LinkedList<String>();
				teamlist = new LinkedList<List<String>>();
				isLinkedList = true;
			}else if(args[0].toLowerCase().equals("arraylist")){
				System.out.println("Using ArrayList.");
				list = new ArrayList<String>();
				teamlist = new ArrayList<List<String>>();
			}else {
				System.out.println("Please enter \"ArrayList\" or \"LinkedList\" to use this program.");
				return;
			}
		}
		try {
			File objects = new File(System.getProperty("user.dir")+"/src/ProjectCollections/itemlist.txt");
			if(!objects.exists()) {throw new FileNotFoundException();};
			try {
				BufferedReader reader = new BufferedReader(new FileReader(objects));
				for(int i = 0;i < 100;++i) {
					list.add(reader.readLine());
				}
				reader.close();
				ListIterator<String> iter = list.listIterator();
				ArrayList<Long> actualTimes = new ArrayList<Long>();
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
				long smallestTraverseTime = Long.MAX_VALUE;
				for(Long num:actualTimes) {
					if(num<smallestTraverseTime) {
						smallestTraverseTime = num;
					}
				}
				System.out.println(smallestTraverseTime + " Time to traverse in nanoseconds");
				
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
						for(int j = 0; j<testOver;++j) {
							long totalTeams = 0;
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
						long smallest = Long.MAX_VALUE;
						for(Long num:actualTeams) {
							if(num<smallest) {
								smallest = num;
							}
						}
						System.out.println(smallest/teams + "Number of nanoseconds per team");
						
						System.out.println(teamlist);
						
						System.out.println("Please enter the index you wish to insert/remove from");
						
						int userindex = Integer.parseInt(userinput.readLine());
						
						ArrayList<Long> getTimes = new ArrayList<Long>();
						
						
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
						
						
						for(int i = 0;i<100000;++i) {
							Long start = System.nanoTime();
							for(List<String> team:teamlist) {
								team.add(userindex,"testadd");
								
							}
							addTimes.add(System.nanoTime()-start);
							
						}
						long smallestaddTime = Long.MAX_VALUE;
						for(Long num:addTimes) {
							if(num<smallestaddTime) {
								smallestaddTime = num;
							}
						}
						System.out.println(smallestgetTime);
						System.out.println(smallestaddTime);
						Random rand = new Random(System.nanoTime());
						
						long randStart = System.nanoTime();
						long totalListTime = 0;
						for(int i = 0;i<100000;i++) {
							int randindex = rand.nextInt(100);
							randStart = System.nanoTime();
							list.get(randindex);
							totalListTime += System.nanoTime() - randStart;
							
						}
						long aveRandTime = totalListTime/100000;
						System.out.println(aveRandTime);
						
						
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
