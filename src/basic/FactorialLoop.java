package basic;

/*
 * Factorial calculation is the multiplication of a sequence of numbers
 * ex 6! = 6*5*4*3*2*1
 * 
 *  This is the iterative solution
 */
public class FactorialLoop {
	public static int factorial(int num) {
		int result = 1;
		while (num != 0) {
			result = result * num;
			num--;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(FactorialLoop.factorial(2));
		System.out.println(FactorialLoop.factorial(3));
		System.out.println(FactorialLoop.factorial(4));
		System.out.println(FactorialLoop.factorial(5));
		System.out.println(FactorialLoop.factorial(6));
	}
}
