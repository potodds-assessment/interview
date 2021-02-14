package basic;


/*
 * reverse string using array
 * 1. convert string to array of character
 * 2. for 0 to midpoint, swap i position with end-i position
 *  
 * reverse using stringbuffer
 * 1. pointer to last character, append last-i character to StringBuffer 
 * 
 * reverse recursively
 * 1. base case when string is only one char
 * 2. recuse case is to recurse string(1,end) then add result + string(0)
 */
public class ReverseString {

	/*
	 * 1. find midpoint of string
	 * 2. from 0 position to midpoint position, swap value with corresponding mirror position at end
	 * 		ie 0 and X, 1 and X-1, 2 and X-2, etc 
	 */
	public String reverseUsingArray(String i) {
		char[] s = i.toCharArray();
		int strLength = s.length;
		for(int x=0;x<strLength/2;x++) {
			char temp = s[x];
			s[x] = s[strLength-1-x];
			s[strLength-1-x] = temp;
		}
		return new String(s);
	}
	
	public String reverse(String orig) {
		if (orig == null || orig.length() == 0)
			return orig;
		
		StringBuffer reversed = new StringBuffer();
		for(int i=0; i<orig.length();i++) {
			reversed.append(orig.charAt(orig.length()-i-1));
		}
		
		StringBuffer b = new StringBuffer();
		char z = 'a';
		b.append(z);
		
		return reversed.toString();
	}
	
	public String reverseRecursively(String orig) {
		if(orig.length() < 2) return orig;
		return reverseRecursively(orig.substring(1)) + orig.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseUsingArray("abcdefghijklmnop"));
//		System.out.println(new ReverseString().reverseRecursively("abcdefghijklmnop"));
	}
}
