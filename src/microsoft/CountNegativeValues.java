package microsoft;

import java.util.ArrayList;
import java.util.List;

public class CountNegativeValues {

    public int countNegativeValues(int[][] nums) {
        int count=0;

        for(int i=0; i<nums.length; ++i) {
            for(int j=0; i<nums[0].length; ++j) {
                if (nums[i][j] < 0) 
                    ++count;
                else
                    break;
            }
            if (nums[i][0] >= 0) break;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNegativeValues app = new CountNegativeValues();
        System.out.println(app.countNegativeValues(new int[][]{{-4,-3,-3,-2 ,2 ,3 ,4},{-4,-3,-3,1,2,3,4}}));
    }    
}
