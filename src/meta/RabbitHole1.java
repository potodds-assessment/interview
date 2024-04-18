package meta;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class RabbitHole1 {

    public int getMaxVisitableWebpages(int N, int[] L) {        
        // for each page, find out max number of pages. Cache number of links once visited.   
        Map<Integer, Integer> pageLinksCount = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int max=0;
        
        for(int i=0; i<L.length; ++i) {
            if (pageLinksCount.get(i) != null) {
                System.out.println("found:" + pageLinksCount.get(i));
                continue;
            }

            visited.clear();
            int count=1;      
            int index=L[i]-1;
            System.out.print("index:" + i + "," + i+1 + ",");
            visited.add(i);
            
            while (!visited.contains(index) && count<N) {
                System.out.print(index+1 + ",");
                visited.add(index);
                index=L[index]-1;
                ++count;
            }
            pageLinksCount.put(i+1, count);
              System.out.println("count=" + count + "," + visited);
            max = Math.max(max, count);
            if (max == N) return max;
        }    
        
        return max;
    }

    public static void main(String[] args) {
        RabbitHole1 app = new RabbitHole1();
        System.out.println(app.getMaxVisitableWebpages(4, new int[]{4,1,2,1}));
        System.out.println(app.getMaxVisitableWebpages(5, new int[]{4,3,5,1,2}));
        System.out.println(app.getMaxVisitableWebpages(5, new int[]{2,4,2,2,3}));
    }
}
