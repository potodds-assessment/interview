package basic;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class LongestSequence {

// longest sequence in 2d array
	
/*
	function longestPath(matrix, row, col, prev) {
	    if (row = matrix.length ||
	        col = matrix[ 0 ].length ||
	        matrix[ row ][ col ] &lt;= prev) {
	        return 0;
	    }
	
	    var lgth = 0,
	        curr = matrix[ row ][ col ];
	
	    lgth = Math.max(longestPath(matrix, row, col + 1, curr), lgth);
	    lgth = Math.max(longestPath(matrix, row + 1, col, curr), lgth);
	    lgth = Math.max(longestPath(matrix, row, col - 1, curr), lgth);
	    lgth = Math.max(longestPath(matrix, row - 1, col, curr), lgth);
	
	    return lgth + 1;
	}
	
	function longestIncreasingPath(matrix) {
	    var longest = 0;
	    matrix.forEach(function(row, i) {
	        row.forEach(function(col, j) {
	            var lgth = longestPath(matrix, i, j, 0);
	            longest = Math.max(lgth, longest);
	        });
	    });
	
	    return longest;
	}
*/
	
	
//	Implement a function that would give you the longest  incrementing path in a 2d array. You can only move to adjacent values (not diagonally)
/*
Python:

def longest_inc_path(matrix):
    longest, current = None, None

    for j in matrix:
        for k in matrix[j]:
            # If we are on the first cell
            if longest is None and current is None:
                longest, current = matrix[j][k], matrix[j][k]
                continue

            # Decide if we are to our current sum or starting
            # over with the current cell.
            current = max(matrix[j][k], longest + matrix[j][k])
            # Decide if our current sum is longer than our longest
            # sum so far.
            longest = max(longest, current)

    return longest
*/
	
	
// Find the triples in an array that equal a given sum.
	
	
//	Add BigIntegers	
	public void addBigIntegers() {
		BigInteger one = new BigInteger("35");
		BigInteger two = new BigInteger("22");
		
		BigInteger sum = one.add(two);
		System.out.println(sum);
	}
	
	public void findMissingNumber() {
		int[] missingNumberArray = {1,2,3,4,5,6,7,8,9,10,11,12,14};
		int missingNumber = 0;
		int total = 0;

		for(int i=0; i<missingNumberArray.length; i++) {
			missingNumber += missingNumberArray[i];
			total += i+1;
		}
		total +=missingNumberArray.length+1; 		
		
		System.out.println(total - missingNumber);
	}

	public void findTwoMissingNumbers() {
		int[] missingNumberArray = {1,2,3,4,6,7,8,9,10,11,12,14};
		// sort numbers if not sorted
		// iterate through and find gap
		
		int prior = 0;
		for(int i=0; i<missingNumberArray.length; i++) {
			if ( missingNumberArray[i] != prior+1 )
				System.out.println(missingNumberArray[i]-1);
			
			prior = missingNumberArray[i];
		}
	}	

	public void findAllMissingNumbers() {
		int[] missingNumberArray = {2,6,7,20};
		
		int[] copyArray = new int[missingNumberArray[missingNumberArray.length-1]+1];
		for(int i : missingNumberArray) {
			copyArray[i] = 1;
		}
		
		for(int i=1; i<copyArray.length; i++) {
			if ( copyArray[i] == 0 )
				System.out.println(i);
		}
	}
	
	public void findAllSubsets() {
		// using bitset solution
		// using recursion solution
		
		Set allValues = new HashSet();
		allValues.add("a");
		allValues.add("b");
		allValues.add("c");
		
//		for() {
//			
//		}
		
		// a, b, c, ab, ac, bc, abc
	}
	
	public static void main(String[] args) {
//		new LongestSequence().addBigIntegers();
		new LongestSequence().findAllMissingNumbers();
	}
}
