package blackrock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashMap;

public class CreateAnIssuerTree {

	static TreeMap<String, List<String>> issuerTree = new TreeMap<>();
	
	static void printBFS() {
		if ( issuerTree == null || issuerTree.isEmpty() ) {
			System.out.println("Nothing to do. Tree is empty");
			return;
		}
		
		Queue<String> processingQ = new ArrayDeque<>();
		Queue<String> childrenQ = new ArrayDeque<>();

		processingQ.add( issuerTree.firstKey() );
		
		while( !processingQ.isEmpty() ) {
			String parent = processingQ.poll();
			System.out.print( parent + " " );
			
			List<String> children = issuerTree.get( parent );
			if ( children != null )
				childrenQ.addAll(children);

			if ( processingQ.isEmpty() ) {
				System.out.println();
				processingQ = childrenQ;
				childrenQ = new ArrayDeque<>();
			}
		}

	}

	static boolean findRoot(String key) {
		if ( key.equals( "ROOT" ) )
			return true;

		Set<Entry<String, List<String>>> set = issuerTree.entrySet();
		if ( set == null || set.isEmpty() ) {
			System.out.println("key[" + key + "] doesn't have ancestors. Tree is empty ");
			return false;
		}
		
		for(Entry<String, List<String>> entry : set) {
			if ( entry.getValue().contains( key ) )
				if ( findRoot( entry.getKey() ) )
					return true;
		}
		
		System.out.println("key[" + key + "] doesn't have ROOT as ancestor");
		return false;
	}
	
	static boolean validateTree() {
		for(String key : issuerTree.keySet() ) {
			if (!findRoot(key))
				return false;
		}		
		return true;
	}

	static void createIssuerTree(List<Issuer> issuers) {    	
    	for(Issuer is : issuers) {
    		String key = is.parentId;
    		String value = is.id;
    		
    		List<String> foundList = issuerTree.get( key );
    		if ( foundList == null ) {
    			foundList = new ArrayList<>();
    			foundList.add( value );
    			issuerTree.put(key, foundList);
    		} else {
    			foundList.add( value );
    		}
    	}

    	if ( validateTree() )
    		printBFS();
    }

    /**
      * Issuer class struture, do no modify
      */
    private static class Issuer {
        String parentId;
        String id;
        Issuer(String parentId, String id) {
            this.parentId = parentId;
            this.id = id;
        }
    }	
	
    static List<Issuer> getTestCases() {
        List<Issuer> issuers = new ArrayList<>();
        Issuer issuer = new Issuer("ROOT", "1");
        issuers.add(issuer);
        issuer = new Issuer("1", "2");
        issuers.add(issuer);
        issuer = new Issuer("1", "3");
        issuers.add(issuer);
//        issuer = new Issuer("1", "4");
//        issuers.add(issuer);
        issuer = new Issuer("2", "25");
        issuers.add(issuer);
//        issuer = new Issuer("2", "28");
//        issuers.add(issuer);
//        issuer = new Issuer("2", "27");
//        issuers.add(issuer);
//        issuer = new Issuer("4", "41");
//        issuers.add(issuer);
//        issuer = new Issuer("4", "43");
//        issuers.add(issuer);
//        issuer = new Issuer("4", "42");
//        issuers.add(issuer);
        issuer = new Issuer("3", "13");
        issuers.add(issuer);
//        issuer = new Issuer("13", "101");
//        issuers.add(issuer);
//        issuer = new Issuer("13", "100");
//        issuers.add(issuer);
//        issuer = new Issuer("25", "201");
//        issuers.add(issuer);
//        issuer = new Issuer("43", "301");
//        issuers.add(issuer);
//        issuer = new Issuer("7", "3010");
//        issuers.add(issuer);


        return issuers;  
    }
    
    public static void main(String[] args)  {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        Scanner s = new Scanner(System.in).useDelimiter("\n");
//        //nodes with id as key and parent id as value
//        String input;
//        while (s.hasNext() && (input = s.nextLine()) != null && input.length() > 0) {
//            String[] nodeString = input.split(" ");
//            Issuer issuer = new Issuer(nodeString[0], nodeString[1]);
//            issuers.add(issuer);
//        }
//        s.close();

    	createIssuerTree(getTestCases());
    }

}

/*
Input:
ROOT 1
1 2
1 3
1 4
2 25
2 28
2 27
4 41
4 43
4 42
3 13

Output:
1
2 3 4
25 28 27 13 41 43 42
*/
