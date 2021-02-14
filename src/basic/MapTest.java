package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapTest {
//	public static void main(String[] args) {
//		String str = "a";
//		int [] cost= {1};
//		
//		int sumOfCost = 0;		
//		Character prevChar = null;
//		
//		for(int i=0; i<str.length(); i++) {
//			Character currentChar = str.charAt(i);
//			if (!currentChar.equals(prevChar))
//				prevChar = currentChar;
//			else if (currentChar.equals(prevChar)) {
//				sumOfCost += cost[i-1];
//			}				
//		}
//		
//		System.out.println(sumOfCost);		
//	}


	public static void main(String[] args) {
		int[] blocks = new int[] {2,6,8,5};
		
		int maxJumps = 0;		
		for(int x=0;x<blocks.length;x++) {
			
			int curr = blocks[x];
			int right = 1;
			for(int y=x+1;y<blocks.length;y++) {
				int next = blocks[y];
				
				if (next < curr) {
					right = y-x;
					break;
				} else {
					curr = next;
				}
			}

			int left = 1;
			curr = blocks[x];
			for(int z=x-1; z >= 0 ;z--) {
				int next = blocks[z];
				
				if (next < curr) {
					left = x-z;
					break;
				} else {
					curr = next;
				}
			}
			
			if ( maxJumps < (left + right) )
				maxJumps = left+right;
		}
		
		System.out.println(maxJumps);
	}
}
