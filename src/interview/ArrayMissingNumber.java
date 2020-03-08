package interview;

import java.util.Arrays;

public class ArrayMissingNumber {
	public static int binarySearch(int[] array) {
		return Arrays.binarySearch(array, 4);
	}
	
	public static int getCheckSum(int size) {
		int finalValue = 0;
		for(int i=1; i<=size; i++) {
			finalValue += i;
		}
		System.out.println(finalValue);
		return finalValue;
	}
	
	public static int sumArray(int[] array) {
		int finalValue = 0;
		for(int i=0;i<array.length;i++) {
			finalValue += array[i];
		}
		System.out.println(finalValue);
		return finalValue;
	}
	
	public static int findMissingValueInArray(int[] array, int size) {
		return getCheckSum(size) - sumArray(array);
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,4,5};		
//		System.out.println(ArrayMissingNumber.findMissingValueInArray(array, 5));
		System.out.println(ArrayMissingNumber.binarySearch(array));
	}
}
