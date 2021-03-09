package amazon._20210308;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	private static long findBiggestGap(List<Integer> list,  int slots) {
		long biggestGap = 1;

		int prev = 0;
		for(int i=1; i<=slots+1; i++) {
			if ( !list.contains(i) ) {
				biggestGap = Math.max(biggestGap, i-prev);
				prev = i;
			}
		}
		return biggestGap;
	}
	
	// my solution.  fairly straightforward.  find largest gap on x and y axis.
    public static long storage(int n, int m, List<Integer> h, List<Integer> v) {
    	
    	long max_w = findBiggestGap(h, n);
    	long max_h = findBiggestGap(v, m);
    	
    	return max_w * max_h;
    }

		// Internet solution
//    public static long storage2(int n, int m, List<Integer> h, List<Integer> v) {
//        long max_h = 0;
//        long max_w = 0;
//        
//        int hptr=0;
//        int vptr=0;
//        
//        long prev = 0;
//        for(int i=1;i<n+2;i++) {
//            if ( i != h.get(hptr) ) {
//                max_h = Math.max(max_h, i-prev);
//                prev = i;
//            } else {
//                if ( hptr < h.size()-1 ) 
//                    hptr += 1;
//            }
//        }
//        
//        prev = 0;
//        for(int i=1;i<m+2;i++) {
//            if ( i != v.get(vptr) ) {
//                max_w = Math.max(max_w, i-prev);
//                prev = i;
//            } else {
//                if ( vptr < v.size()-1 ) 
//                    vptr += 1;
//            }
//        }        
//        
//        return max_h * max_w;
//    }
	
	public void run() {
		List<Integer> hList = null;
		List<Integer> vList = null;
		
		hList = new ArrayList<>();
		hList.add(2);
		hList.add(3);
		vList = new ArrayList<>();
		vList.add(2);
		vList.add(4);
		
		// answer 6
		System.out.println(storage(6,6,hList,vList));

	
		hList = new ArrayList<>();
		hList.add(2);
		vList = new ArrayList<>();
		vList.add(2);
		
		// answer 4
		System.out.println(storage(3,3,hList,vList));
		
		
		hList = new ArrayList<>();
		hList.add(1);
		vList = new ArrayList<>();
		vList.add(2);
		
		// answer 4
		System.out.println(storage(2,2,hList,vList));		
		
		
		hList = new ArrayList<>();
		hList.add(1);
		hList.add(2);
		hList.add(3);
		vList = new ArrayList<>();
		vList.add(1);
		vList.add(2);
		
		// answer 12
		System.out.println(storage(3,2,hList,vList));			
	}
	
	public static void main(String[] args) {
		new Problem2().run();
	}

}
