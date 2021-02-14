package recursion;

import basic.FactorialLoop;

/*
 * Factorial calculation is the multiplication of a sequence of numbers
 * ex 6! = 6*5*4*3*2*1 = 720
 * 
 *  This is the recursive solution
 */
public class FactorialRecursion {
	public static int factorial(int num) {
		if (num == 0) return num;

		return factorial(num--) * num;
	}

	public static void main(String[] args) {
		System.out.println(FactorialLoop.factorial(2));
		System.out.println(FactorialLoop.factorial(3));
		System.out.println(FactorialLoop.factorial(4));
		System.out.println(FactorialLoop.factorial(5));
		System.out.println(FactorialLoop.factorial(6));
	}
}
