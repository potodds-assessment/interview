package meta;

/*
Longest contiguous subarray with range at most 1

Description
Given an array of integers A, find the longest contiguous subarray A[i...j] where the maximum 
element of the subarray and the minimum element of the subarray differ by at most 1.
A contiguous subarray A[i...j] for i <= j is defined as [A[i], A[i+1], ... A[j]].

Examples
[1,2,1,2,3,2] => 4, longest subarray is [1,2,1,2]
[1,2,2,3,3,5] => 4, longest subarray is [2,2,3,3]

*/

public class LongestContiguousSubarray {

        public int findLongest(int[] arr) {

            int max=0;

            int start=0;
            int end=1;

            int counter=1;

            while (end<arr.length) {
                if (Math.abs(arr[end]-arr[start]) <= 1) {
                    ++counter;
                } else {
                    max=Math.max(max, counter);
                    counter=0;

                    int counter2=0;
                    while (start < end) {
                        if (Math.abs(arr[end]-arr[start]) > 1) 
                            counter2=0;
                        ++counter2;
                        ++start;
                    }
                    start = end-counter2;
                    counter=counter2;
                }
                ++end;
            }
            max=Math.max(max, counter);

            return max;
        }

    public static void main(String[] args) {
        LongestContiguousSubarray app = new LongestContiguousSubarray();
        System.out.println(app.findLongest(new int[]{1,2,2,2,3,3,3,3,4,5,6}));
        System.out.println(app.findLongest(new int[]{2,2,3,3}));
    }    
}
