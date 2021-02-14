package basic;

import java.util.LinkedList;
import java.util.List;

import recursion.FibonacciRecursive;

public class FibonacciDP {
	public int fib(int n) {
		List<Integer> f = new LinkedList<>();
		f.add(0);
		f.add(1);
		
		for(int i=2;i <=n; i++) {
			f.set(i, f.get(i-1) + f.get(i-2));
		}
		
		
		return f.get(n);
	}
	
	public static void main(String[] args) {
		System.out.println( new FibonacciRecursive().fib(3) );
	}
}
