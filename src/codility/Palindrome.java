package codility;

// you can also use imports, for example:
// import java.util.*;

public class Palindrome {

    public static boolean isPalindrome(String str) {
 //       char[] chArr = input.toCharArray();

        boolean odd = str.length() % 2 != 0;
        int mid=str.length()/2;
        if (odd) ++mid;
        
        // int i=mid; 
        // int j=mid-1;
        // while ()
        for(int i=mid, j=mid-1; i<str.length() && j>=0; ++i, --j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = new String("aabc");
//        char[] chArr = input.toCharArray();

        for(int i=0; i<input.length(); ++i) {
            for(int j=i; j<input.length(); ++j) {
                if (isPalindrome(input.substring(i,j))) {
                    System.out.println(input.substring(i,j));
                }
            }
        }

        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }
}
