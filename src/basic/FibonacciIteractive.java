package basic;

import java.util.ArrayList;
import java.util.List;
/****************************
 * Fibonacci calculated iteratively.
 * fibonacci series is 0,1,1,2,3,5,8,13,21,34,55,etc
 * the next number in sequence is the sum of the prior 2 numbers
 * 
 * @author lwlee
 *
 */
public class FibonacciIteractive {
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
		FibonacciIteractive fib = new FibonacciIteractive();
		List<Long> fibArray = fib.calculateFibs(0, 1, 10);
		System.out.println(fibArray.toString());
	}
}
