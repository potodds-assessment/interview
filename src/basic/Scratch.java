package basic;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;
import java.util.TreeMap;

public class Scratch {
        
    protected void countOccurrences(String quote, List<String> toys, Map<String, Integer> results) {
        if (quote == null || quote.length() == 0 || toys == null || toys.size() == 0)
            return;

        for(String toy : toys)  {
            String lcToy = toy.toLowerCase();
            
            if ( quote.contains(lcToy) ) {
                Integer count = results.get(lcToy);
                if ( count == null ){
                    results.put(lcToy, 1);
                } else {
                    results.put(lcToy, count++);
                }
            }
        }
    }
    
    protected ArrayList<String> topNToys(Map<String, Integer> results, int topToys) {
        ArrayList<String> finalResults = new ArrayList<>();
        SortedMap<Integer, String> sortedResults = new TreeMap<>();
        for(String toyKey : results.keySet()) {
            Integer count = results.get(toyKey);
            String toyString = sortedResults.get(count);
            if ( toyString == null )
                sortedResults.put(count, toyString);
            else { 
                if ( toyKey.compareTo(toyString) < 0 )
                    sortedResults.put(count, toyKey);
            }
        }
        Set<Entry<Integer, String>> s = sortedResults.entrySet();
        Iterator<Entry<Integer, String>> i = s.iterator();
        
        int counter = 0;
        while (i.hasNext() && counter < topToys) {
            Map.Entry m = (Map.Entry)i.next();
            finalResults.add((String)m.getValue());
            counter++;
        }
        return finalResults;
    }
    
    public ArrayList<String> popularNToys(int numToys, 
	                                      int topToys, 
                                          List<String> toys, 
										  int numQuotes, 
										  List<String> quotes)
    {
        if ( numToys == 0 || topToys == 0 || toys == null || quotes == null )
            return null;
            
        Map<String, Integer> results = new HashMap<>();
        for(String quote : quotes) {
            countOccurrences(quote.toLowerCase(), toys, results);
        }
        
        return topNToys(results, topToys);
    }
    // METHOD SIGNATURE ENDS

	public static void main(String args[]) {
		System.out.println("2%3=" + 2%3);
		System.out.println("3%3=" + 3%3);
		System.out.println("4%3=" + 4%3);
	}
}
