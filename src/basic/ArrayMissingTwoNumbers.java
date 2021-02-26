package basic;

public class ArrayMissingTwoNumbers {
	
	/*
	 * To find one missing number in an sequence of consecutive increasing numbers
	 * Add all the numbers in the array than subtract from sum of sequence of increasing numbers
	 */
	public void findMissingNumbers( int[] arrNums, int totalNum ) {
		int arrNumsSum = 0;

		/*
		 * formula to calculate a sequence of numbers increasing by 1 eg 1,2,3,4,5,6
		 * N = number of elements
		 * 
		 * N*(N+1)/2
		 */
		int calculatedTotalNumSum = (( totalNum + 1 ) * totalNum) / 2;
		
		for(int i=0; i<arrNums.length; i++) {
			arrNumsSum += arrNums[i];
		}

		System.out.println("arrNumsSum: " + arrNumsSum);
		System.out.println("calculatedTotalNumSum: " + calculatedTotalNumSum);
		System.out.println("missing number: " + (calculatedTotalNumSum - arrNumsSum));
	}	

	public void findTwoMissingNumbers( int[] arrNums, int totalNum ) {
		int calculatedTotalNumSum = (( totalNum + 1 ) * totalNum) / 2;
		
		int arrNumsSum = 0;
		for(int i=0; i<arrNums.length; i++) {
			arrNumsSum += arrNums[i];
		}

		System.out.println("arrNumsSum: " + arrNumsSum);
		System.out.println("calculatedTotalNumSum: " + calculatedTotalNumSum);
		
		int sumMissingNumbers = calculatedTotalNumSum - arrNumsSum;
		int avgMissingNumbers = ( sumMissingNumbers / 2 ) + 1;

		int calculatedTotalNumSum2 = (( avgMissingNumbers + 1 ) * avgMissingNumbers) / 2;
		int arrNumsSum2 = 0;
		for(int i=0; i<avgMissingNumbers-1; i++) {
			arrNumsSum2 += arrNums[i];
		}
		
		System.out.println("arrNumsSum2: " + arrNumsSum2);
		System.out.println("calculatedTotalNumSum2: " + calculatedTotalNumSum2);
		System.out.println("missing numbers[" + (calculatedTotalNumSum2 - arrNumsSum2) + "," + (sumMissingNumbers - (calculatedTotalNumSum2 - arrNumsSum2)) + "]");
	}	
	
	public void run() {
//		this.findMissingNumbers(new int[] {1,3,4,5,6,7,8,9,10}, 10);
		this.findTwoMissingNumbers(new int[] {1,3,4,5,6,8,9,10}, 10);
	}

	public static void main(String[] args) {
		new ArrayMissingTwoNumbers().run();
	}

}
