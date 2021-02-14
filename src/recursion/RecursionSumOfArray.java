package recursion;

import java.util.Arrays;
import java.util.List;

/*
 * recursively sum the array of integers
 * 
 * recursion works by reusing same method with n-1 value until the base case is reached, then summing up return values.
 * 
 * The base case is one element left.
 * The summation is last value returned + last value of the array.
 */
public class RecursionSumOfArray {
	public int recurse(List<Integer> ar1) {
		if (ar1.size() > 1) {
			List<Integer> newList = ar1.subList(0, ar1.size()-1);
			return recurse(newList) + ar1.get(ar1.size()-1);			
		}
		return ar1.get(0);
	}

	public static void main(String[] args) {		
		List<Integer> intArray = Arrays.asList(1,2,3,4,5,6,7,8,9,10); 		
		System.out.println(new RecursionSumOfArray().recurse(intArray));
	}
}
