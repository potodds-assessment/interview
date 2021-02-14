package basic;

/*
 * A palindrome is a string that is the same, spelled backwards as well as forward
 * ex t1t is a palindrome
 * ex abccba is a palindrome
 * ex abcdedcbz is not a palindrome
 * 
 */

public class Palindrome {

	public boolean isPalindrome(String palindrome) {
		if (palindrome == null || palindrome.length() == 0) return false;
		if (palindrome.length() == 1) return true;
		
		int midpoint = palindrome.length() / 2;
		int lastPos = palindrome.length()-1;
		
		for (int i=0; i<midpoint; i++) {
			System.out.println("comparing " + i + ":" + palindrome.charAt(i) + ", " + lastPos + ":" + palindrome.charAt(lastPos));
			if (palindrome.charAt(i) != palindrome.charAt(lastPos))
				return false;
			
			lastPos--;
		}		
		return true;
	}
	
	public static void main(String[] args) {
		String[] listOfPalindromes = new String[] {"test", "t1t","abcdefggfedcba","abcdefg","abcdefgh"};
		
		Palindrome listOfPs = new Palindrome();
		for(String word : listOfPalindromes) {
			System.out.println(word + ":" + listOfPs.isPalindrome(word));
		}
	}	
}
