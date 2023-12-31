package capitalone;

/*
You are given an array of non-negative integers numbers. You are allowed to choose any number from this array and swap any two digits in it. If after the swap operation the number contains leading zeros, they can be omitted and not considered (eg: 010 will be considered just 10).

Your task is to check whether it is possible to apply the swap operation at most once, so that the elements of the resulting array are strictly increasing.

Example

For numbers = [1, 5, 10, 20], the output should be solution(numbers) = true.

The initial array is already strictly increasing, so no actions are required.

For numbers = [1, 3, 900, 10], the output should be solution(numbers) = true.

By choosing numbers[2] = 900 and swapping its first and third digits, the resulting number 009 is considered to be just 9. So the updated array will look like [1, 3, 9, 10], which is strictly increasing.

For numbers = [13, 31, 30], the output should be solution(numbers) = false.

The initial array elements are not increasing.
By swapping the digits of numbers[0] = 13, the array becomes [31, 31, 30] which is not strictly increasing;
By swapping the digits of numbers[1] = 31, the array becomes [13, 13, 30] which is not strictly increasing;
By swapping the digits of numbers[2] = 30, the array becomes [13, 31, 3] which is not strictly increasing;
So, it's not possible to obtain a strictly increasing array, and the answer is false.

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.integer numbers

An array of non-negative integers.

Guaranteed constraints:
1 ≤ numbers.length ≤ 103,
0 ≤ numbers[i] ≤ 103.

[output] boolean

Return true if it is possible to obtain a strictly increasing array by applying the digit-swap operation at most once, and false otherwise.

====================================
1,80,910,100
910 = 19,190,901,910
x = 91, 109

9
1 = 190
0 = 019

1 
9 = 190
0 = 901

0
9 = 019
1 = 901 

numbers: [92, 121, 193, 293, 328, 345, 343, 475, 478, 154, 250, 706, 929]
		  92, 121, 193, 293, 328, 345, 433, 475, 478, 514, 520, 706, 929
		  
numbers: [92, 121, 193, 293, 328, 345, 746, 475, 478, 154, 250, 706, 929]
		  92, 121, 193, 293, 328, 345, 476, 745, 748, 514, 520, 706, 929


 */

public class CodingSignalB {
    public static void main(String[] args) {
        
    }
}
