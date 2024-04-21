package meta;

import java.util.Arrays;

public class ReorderZeros {
    public static void moveZeros(int[] arr) {
        int lastPos=0;
        for(int i=0; i<arr.length; ++i) {
            if (arr[i] == 0) {
                for(int j=i;j>lastPos;--j) {
                    arr[j]=arr[j-1];
                }
                arr[lastPos]=0;
                ++lastPos;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,5,6,9,0};
        System.out.println(Arrays.toString(arr));
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }   

}
