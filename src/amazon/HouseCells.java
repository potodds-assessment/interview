package amazon;

import java.util.ArrayList;
import java.util.List;

public class HouseCells {

	public List<Integer> cellCompete(int[] states, int days) {
		int[] flip = states;
		int[] flop = new int[states.length];

		for(int z=1;z<=days;z++) {
			for(int i=0 ; i < states.length; i++) {
				int left = (i-1 < 0) ? 0 : flip[i-1];
				int right = (i+1 >= states.length) ? 0 : flip[i+1];
				
				if (( left == 0 && right == 0 ) ||
					( left == 1 && right == 1 )) {
					flop[i] = 0;
				} else {
					flop[i] = 1;
				}				
			}
			int[] temp = flip;
			flip = flop;
			flop = temp;
		}

		List<Integer> list = new ArrayList<>();
		for(int r : flip) {
			list.add(r);
		}		
		return list;
	}

	/*
	 * answer: 0 1 0 0 1 0 1 0
	 */
	public int[] getTestCase1() {
		return new int[] {1,0,0,0,0,1,0,0};
	}
	
	/*
	 * answer: 0 0 0 0 0 1 1 0
	 */
	public int[] getTestCase2() {
		return new int[] {1,1,1,0,1,1,1,1};
	}

	public void run() {
		System.out.println(cellCompete(getTestCase1(), 1));
		System.out.println(cellCompete(getTestCase2(), 2));
	}
	
	public static void main(String[] args) {
		new HouseCells().run();
	}

}
