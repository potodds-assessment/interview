package amazon._20231011;

import java.util.List;

public class countMaximumProfitableGroups {

    List<Integer> stockPrice;
    public int count=0;

    public static long countMaximumProfitableGroups1(List<Integer> stockPrice) {
    // Write your code here

        // int[] arr = stockPrice.stream().mapToInt(i->i).toArray();
        
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=i+1; j<arr.length; j++) {
                
        //     }
        // }

        int count = 0;
        for(int i=0; i<stockPrice.size(); i++) {
            int maxValue = 0;
            for(int j=i+1; j<=stockPrice.size(); j++) {
                int first = stockPrice.get(i);
                int last = stockPrice.get(j-1);
                
                maxValue = Math.max(Math.max(first, last), maxValue);
                System.out.println(maxValue + " " + first + " " + last + " " + ";" + stockPrice.subList(i, j));

                if (first >= maxValue || last >= maxValue)
                    count++;

            }
        }

        return count;
    }

    public int dfs(int i, int j) {
        if (i==j) {
            count++;
            return stockPrice.get(i);
        }

        int first = stockPrice.get(i);
        int last = stockPrice.get(j);
        int dfs = dfs(i, j-1);
        int maxValue = Math.max(dfs, last);

        if (first == maxValue || last == maxValue) {
            System.out.println("Yes" + " " + first + "," + last + "," + dfs + "," + maxValue);
            count++;
        } else {
            System.out.println("No" + " " + first + "," + last + "," + dfs + "," + maxValue);
        }

        return maxValue;
    }

    public long countMaximumProfitableGroups(List<Integer> stockPrice) {
        this.stockPrice = stockPrice;

        for(int i=0; i<stockPrice.size(); i++) {
            dfs(i, stockPrice.size()-1);
        }

        return this.count;
    }

    public static void main(String[] args) {
        countMaximumProfitableGroups app = new countMaximumProfitableGroups();
        System.out.println(app.countMaximumProfitableGroups(List.of(3,1,3,5)));
        app.count = 0;
        System.out.println(app.countMaximumProfitableGroups(List.of(1,5,2)));
    }    

}
