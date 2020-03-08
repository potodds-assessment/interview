package interview;

import java.util.ArrayList;
import java.util.List;
/****************************
 * 
 * Fibonacci calculated recursively.
 * 
 * base case and recursive case
 * 
 * @author lwlee
 *
 */
public class FibonacciRecursive {
	public List<Long> calculateFibs(long seed1, long seed2, long length) {
		List<Long> fibArray = new ArrayList<>();
		
		if (seed1 == 0 && seed2 == 0) return fibArray;
		if (length == 0) return fibArray;
		
		fibArray.add(seed1);
		fibArray.add(seed2);
		
		for(int i=2;i<(length+2);i++) {
			fibArray.add(fibArray.get(i-2) + fibArray.get(i-1));
		}
		
		return fibArray;
	}
	
	public static void main(String[] args) {
		FibonacciRecursive fib = new FibonacciRecursive();
		List<Long> fibArray = fib.calculateFibs(0, 1, 10);
		System.out.println(fibArray.toString());
	}
}
