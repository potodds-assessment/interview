package basic;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class DistinctSubStrings {

	/*
	 * double loops finds all substrings.  Add to set so only have unique strings.
	 */
	public static int recursiveCount(String str) {
        Set<String> result = new HashSet<String>(); 
  
        for (int i = 0; i <= str.length(); i++) { 
            for (int j = i + 1; j <= str.length(); j++) { 
                result.add(str.substring(i, j)); 
            } 
        } 
  
        return result.size(); 		
	}
	
	public static int iterativeCount(String s) {
        if (s.isEmpty()) return 0;

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int l = s.length(); l >= 1; l--) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l;
                String sub = s.substring(i, j);

                if (!set.contains(sub)) {
                    count++;
                    set.add(sub);
                }
            }
        }

        return count;		
	}
	
	public static int formulaCount(String str) {
		/*
		Your current solution is quadratic for the size of the input string or O(n^2)
		You can solve this more efficiently by counting the occurrence of each character in the string, and then counting the number of substrings that can be created with this character.
		E.g. if a character occurs 4 times, then this leads to 3 + 2 + 1 = 6 substrings.
		You can use the following formula for this: ((n-1) * n) / 2
		This brings the complexity of the algorithm down to O(n), because for counting each character you only need to traverse the String once.
		I believe this code should work:
		*/

		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			Integer count = map.get(c);
			if (count == null)
				count = 0;
			map.put(c, count + 1);
		}
		int sum = 0;
		for (int n : map.values())
			sum += ((n - 1) * n) / 2;
		return sum;
	}
	/*
	 * https://www.geeksforgeeks.org/number-substrings-string/	
    static int countNonEmptySubstr(String str) 
    { 
        int n = str.length(); 
        return n * (n + 1) / 2; 
    } 
      
    // Driver code 
    public static void main(String args[]) 
    { 
        String s = "abcde"; 
        System.out.println( 
                  countNonEmptySubstr(s)); 
    } 
	 */
	
	
}
