package meta;

public class Palindrome_Minus_One {

    public boolean isPalindrome(String str) {
        int i=0;
        int j=str.length()-1;

        while(i<str.length()/2) {
            if (str.charAt(i++) != str.charAt(j--)) {
                if (isPalindromeBasic(str.substring(i, j+1)) || 
                    isPalindromeBasic(str.substring(i+1, j)))
                    return true;
                else
                    return false;
            }
        }
        return true;
    }

    public boolean isPalindromeBasic(String str) {
        int i=0;
        int j=str.length()-1;

        while(i<str.length()/2) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome_Minus_One app = new Palindrome_Minus_One();
        System.out.println(app.isPalindrome("abba"));
        System.out.println(app.isPalindrome("abbaz"));
        System.out.println(app.isPalindrome("abcba"));
        System.out.println(app.isPalindrome("abczba"));
    
    }
    
}
