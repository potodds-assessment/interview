package interview;

import java.util.Map;
import java.util.HashMap;

public class FibonacciMemoization {
	public static int fibMemo(int i, Map<Integer, Integer> map) {
		if (i==0) return 0;
		if (i==1) return 1;
		
		if (map.containsKey(i)) {
			return map.get(i);
		}
		
		map.put(i, fibMemo(i-1,map) + fibMemo(i-2,map));
		return fibMemo(i-1, map) + fibMemo(i-2, map);
	}
	
	public static void main(String[] args) {
		System.out.println(FibonacciMemoization.fibMemo(6, new HashMap<>()));
	}
}
