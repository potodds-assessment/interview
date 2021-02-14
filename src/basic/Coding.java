package basic;

import java.util.HashSet;
import java.util.Set;

public class Coding {	
	
	public void start(int[] arr, int k) {
		Set<Integer> remainder = new HashSet<>();
		for(int z : arr) {
			int p = Math.abs(k-z);
			if (remainder.contains(p)) {
				System.out.println("Found 2 values[" + p + "][" + z + "]");
				return;
			} else
				remainder.add(z);
		}
		System.out.println("Did not find");
	}
	
	public static void main(String[] args) {
		int[] test = {10,2,6,4,13,7};
		new Coding().start(test, 17);
	}
}
