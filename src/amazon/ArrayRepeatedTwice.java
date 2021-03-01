package amazon;

import java.util.Arrays;
import java.util.Collections;

/*
Question 2: Given a sorted array where all elements are repeated twice and only one element is present once. You are required to find that unique element.
The instant approach that striked me was returning xor of all elements. This was O(n) approach. He asked me to optimize it.
Then I gave O(logn) solution based on modified binary search. 
 */
public class ArrayRepeatedTwice {
	int iteration=0;
	public int findUnique(int[] sortedArray) {
		if ( sortedArray.length == 1 )
			return sortedArray[0]; 
		
		int midPt = sortedArray.length / 2;

		iteration++;
		if ( sortedArray[midPt] == sortedArray[midPt-1] ) {
			// right side has unique value
			return findUnique( Arrays.copyOfRange(sortedArray, midPt+1, sortedArray.length) );
		} else if ( sortedArray[midPt] == sortedArray[midPt+1] ) {
			// left side has unique value
			return findUnique( Arrays.copyOfRange(sortedArray, 0, midPt) );
		} else
			return sortedArray[midPt];
		
	}

	public void run() {
		int[] array = new int[] {1,1,3,3,5,5,6,6,7,9,9};
		Arrays.sort(array);
		System.out.println("Unique number[" + findUnique(array) + "], iterations[" + iteration + "]");
	}
	
	public static void main(String[] args) {
		new ArrayRepeatedTwice().run();
	}

}
