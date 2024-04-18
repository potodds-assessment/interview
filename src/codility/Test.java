package codility;

import java.util.Arrays;

public class Test {

    public int findMissingInteger(int[] A) {
        Arrays.sort(A);
        
        int start=1;
        for(int n : A) {
            if (n == start || n < 0)
                continue;
            else if (n == start+1)
                ++start;
            else
                return start+1;
        }

        return start == 1 ? 1 : start+1;
    }

    public static void main(String[] args) {
        System.out.println(new Test().findMissingInteger(new int[]{1, 3, 6, 4, 1, 2}));
    }
}
