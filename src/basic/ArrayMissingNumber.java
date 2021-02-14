package basic;

import java.util.Arrays;

/*
 * Find the missing digit in a sequential list of numbers.
 * The sum of all digits - sum of digits in array = missing digit
 */
public class ArrayMissingNumber {
	public static int binarySearch(int[] array) {
		return Arrays.binarySearch(array, 4);
	}
	
	public static int getCheckSum(int size) {
		int finalValue = 0;
		for(int i=1; i<=size; i++) {
			finalValue += i;
		}
		System.out.println("checksum:" + finalValue);
		return finalValue;
	}
	
	public static int sumArray(int[] array) {
		int finalValue = 0;
		for(int i=0;i<array.length;i++) {
			finalValue += array[i];
		}
		System.out.println("sumarray:" + finalValue);
		return finalValue;
	}
	
	public static int findMissingValueInArray(int[] array, int size) {
		return getCheckSum(size) - sumArray(array);
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,12};		
		System.out.println(ArrayMissingNumber.findMissingValueInArray(array, 12));
//		System.out.println(ArrayMissingNumber.binarySearch(array));
	}
}
