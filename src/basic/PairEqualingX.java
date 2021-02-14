package basic;

/*
 * Find 2 numbers that will total X.
 * 
 * Solution is do a double loop.  Summing each value in first array with each value in second array.
 */

public class PairEqualingX {
	private static int[] sortedArray = new int[] {-10, -4, -1, 0, 3, 7, 14, 20};
	
	public static void findNumber(int total) {
		int counter=0;
		
		for(int x=0; x<sortedArray.length; x++) {
			for(int y=x+1; y<sortedArray.length; y++) {
				if ((sortedArray[x] + sortedArray[y]) == total)
					System.out.println("Found[" + sortedArray[x] + "], [" + sortedArray[y] + "] equals " + total);
				counter++;
			}
			counter++;
		}
		System.out.println("counter[" + counter + "]");
	}
	
	public static void main(String[] args) {
		findNumber(2);
	}	
}
