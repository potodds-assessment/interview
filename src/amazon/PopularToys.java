package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PopularToys {

	public ArrayList<String> popularNToys(int numToys, 
			int topToys, List<String> toys, int numQuotes, List<String> quotes ) {

		Map<String, Integer> toysMap = new HashMap<>();
		for(String quote : quotes) {
			for(String toy : toys) {
				toy = toy.toLowerCase();
				quote = quote.toLowerCase();
				if ( quote.indexOf( toy ) != -1 ) {
					Integer count = toysMap.get( toy );
					if ( count == null ) 
						toysMap.put(toy, 1);
					else
						toysMap.put(toy, ++count);
				}
			}
		}
		
		TreeMap<Integer, String> sortedMap = new TreeMap();
		for(String key : toysMap.keySet()) {
			sortedMap.put(toysMap.get(key), key);
		}
		
		ArrayList<String> toyList = new ArrayList<>();
		for(int i=1; i<= topToys; i++) {
			toyList.add(sortedMap.get(sortedMap.lastKey()));
			sortedMap.remove(sortedMap.lastKey());
		}
		
		return toyList;
	}
	
	/*
	 * correct answer: "elmo", "elsa"
	 */
	public void runTest1() {
		List<String> toys = new ArrayList<>();
		toys.add("elmo");
		toys.add("elsa");
		toys.add("legos");
		toys.add("drone");
		toys.add("tablet");
		toys.add("warcraft");
		List<String> quotes = new ArrayList<>();
		quotes.add("Elmo is the hottest toy of the season! Elmo will be on every kid's wishlist");
		quotes.add("The new Elmo dolls are super high quality.");
		quotes.add("Expect the Elsa dolls to be very popular this year");
		quotes.add("Elsa and Elmo are the toys I'll be buying for my kids.");
		quotes.add("For parents of older kids, look into buying them a drone");
		quotes.add("Warcraft is slowly rising in popularity ahead of the holiday season");
		System.out.println(this.popularNToys(6, 2, toys, 6, quotes));
	}

	/*
	 * correct answer: "anacell", "betacellular"
	 */
	public void runTest2() {
		List<String> toys = new ArrayList<>();
		toys.add("anacell");
		toys.add("betacellular");
		toys.add("cetracular");
		toys.add("deltacellular");
		toys.add("eurocell");
		List<String> quotes = new ArrayList<>();
		quotes.add("Best services provided by anacell");
		quotes.add("betacellular has great services");
		quotes.add("anacell provides much better services than all other");
		System.out.println(this.popularNToys(5, 2, toys, 3, quotes));
	}

	/*
	 * correct answer: "betacellular", "deltacellular"
	 */
	public void runTest3() {
		List<String> toys = new ArrayList<>();
		toys.add("anacell");
		toys.add("betacellular");
		toys.add("cetracular");
		toys.add("deltacellular");
		toys.add("eurocell");
		List<String> quotes = new ArrayList<>();
		quotes.add("I love anacell Best services provided by anacell in the town");
		quotes.add("betacellular has great services");
		quotes.add("deltacellular provides much better services than betacellular");
		quotes.add("cetracular is worse than eurocell");
		quotes.add("betacellular is better than deltacellular");
		System.out.println(this.popularNToys(5, 2, toys, 5, quotes));
	}	
	
	public void run() {
		this.runTest1();
		this.runTest2();
		this.runTest3();
	}
	
	public static void main(String[] args) {
		new PopularToys().run();
	}

}
