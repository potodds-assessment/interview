package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunWithArrays {
	public static void zeroOutMultiDArray() {
		int[][] first = new int[][] {{1,2,3},{2,3,4}};
		for(int i=0;i<first.length;i++) {
			System.out.println(Arrays.toString(first[i]));
		}
		for(int i=0;i<first.length;i++) {
			int length = first[i].length;
			for(int y=0;y<length;y++) {
				first[i][y] = 0;
			}
		}
		for(int i=0;i<first.length;i++) {
			System.out.println(Arrays.toString(first[i]));
		}
	}

	public static void main(String[] args) {
		FunWithArrays.zeroOutMultiDArray();
		System.exit(0);
		
		int[] myArray = new int[] {3,2,1};
		Arrays.sort(myArray);
		System.out.println(Arrays.toString(myArray));
		
		int[] myArray2 = new int[] {3,2,1,3,2};
		List<Integer> results = new ArrayList<Integer>();
		for(int i=0;i<myArray2.length;i++) {
			if (!results.contains(new Integer(myArray2[i])))
				results.add(myArray2[i]);
		}
		System.out.println(Arrays.toString(results.toArray(new Integer[results.size()])));
	}

}
