package basic;

import java.util.Map;
import java.util.HashMap;
/*************************
 * 
 * Recursive solution with memoization to calculating fibonacci
 * fibonacci series is 0,1,1,2,3,5,8,13,21,34,55,etc
 * the next number in sequence is the sum of the prior 2 numbers
 * 
 * memoization means to store data that has already been calculated
 * 
 * @author lwlee
 *
 */
public class FibonacciMemoization {
	public static int fibMemo(int i, Map<Integer, Integer> map) {
		if (i==0) return 0;
		if (i==1) return 1;
		
		if (map.containsKey(i)) {
			System.out.println(map.get(i));
			return map.get(i);
		}
		
		map.put(i, fibMemo(i-1,map) + fibMemo(i-2,map));
		return fibMemo(i-1, map) + fibMemo(i-2, map);
	}
	
	public static void main(String[] args) {
		System.out.println(FibonacciMemoization.fibMemo(8, new HashMap<>()));
	}
}
