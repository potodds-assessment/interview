package amazon;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class GCD {

	public List<Integer> getFactorsForSmallestValue(int[] arr) {
		List<Integer> factors = new ArrayList<>();
		if ( arr == null ) return factors;

		int smallestValue = Integer.MAX_VALUE;
		for(int value : arr) {
			if ( value < smallestValue )
				smallestValue = value;
		}
		
		double sqrt = Math.sqrt(smallestValue);
		for(int i=2; i<sqrt; i++) {
			if ( smallestValue % i == 0 ) {
				factors.add(i);
				factors.add(smallestValue / i);
			}
		}
		factors.add(smallestValue);
		return factors;
	}
	
	public int getMaxFactor(List<Integer> factors) {
		int maxFactor = 0;
		for(Integer i : factors) {
			if ( i > maxFactor )
				maxFactor = i;
		}
		return maxFactor == 0 ? 1 : maxFactor;
	}

	/*
	 * 1. find smallest number in array
	 * 2. get factors for smallest number
	 * 3. for each number in array, remove factors that are not common 
	 * 4. return largest value in factor array or if none, return 1
	 */	
	public int generalizedGCD(int num, int[] arr) {
		if ( arr == null || arr.length == 1 || ( num > arr.length) )
			return 1;
		
		List<Integer> factors = getFactorsForSmallestValue(arr);
		for(int i=0; i<num; i++) {
			Iterator<Integer> z=factors.iterator();
			for(;z.hasNext();) {
				Integer factor = z.next();
				if ( arr[i] % factor != 0 ) 
					z.remove();
			}
		}
		return getMaxFactor(factors); 
	}
	
	/*
	 * answer: 2
	 */
	public int[] getTestCase1() {
		return new int[] {2,4,6,8,10};
	}
	
	/*
	 * answer: 1
	 */
	public int[] getTestCase2() {
		return new int[] {2,3,4,5,6};
	}

	/*
	 * answer: 
	 */
	public int[] getTestCase3() {
		return new int[] {5,20,40,60,80,100};
	}

	public int[] getTestCase4() {
		return new int[] { 49, 343, 2401, 16807};
	}
	
	// { 454 } 1,2,227,454
	// { 121 } 1,11,11,121
	// { 122 } 1,2,61,122
	// { 25 } 1,5,5,25
	// { 20,30,40 } 10
	// { 7, 49, 343, 2401, 16807} 7
	// { 49, 343, 2401, 16807} 49
	// { 343, 2401, 16807} 343
	// { 2401, 16807} 2401
	// { 227, 454 } 227	
	
	public void run() {
		System.out.println(this.generalizedGCD(5, getTestCase1()));
		System.out.println(this.generalizedGCD(5, getTestCase2()));
		System.out.println(this.generalizedGCD(6, getTestCase3()));
		System.out.println(this.generalizedGCD(4, getTestCase4()));
	}
	
	public static void main(String[] args) {
		new GCD().run();		
	}

}
