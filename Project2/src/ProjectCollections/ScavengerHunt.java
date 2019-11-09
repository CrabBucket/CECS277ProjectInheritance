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
				for(int i = 0;i<100;++i) {
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
						int testOver = 100;
						for(int j = 0; j<testOver;++j) {
							long totalTeams = 0;
							if(isLinkedList) {
								for(int i = 0;i < teams; ++i) {
									long startTeams = System.nanoTime();
									teamlist.add(new LinkedList());
									while(iter.hasNext()) {
										teamlist.get(i).add(iter.next());
									}
									while(iter.hasPrevious()) {
										iter.previous();
									}
									totalTeams += System.nanoTime() - startTeams;
									Collections.shuffle(list);																
								}
								actualTeams.add(totalTeams);
							}else {
								for(int i = 0;i < teams; ++i) {
									long startTeams = System.nanoTime();
									teamlist.add(new ArrayList());
									while(iter.hasNext()) {
										teamlist.get(i).add(iter.next());
									}
									while(iter.hasPrevious()) {
										iter.previous();
									}
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
					}catch(NumberFormatException e){
						System.out.println("Please enter a valid integer");
						continue;
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
