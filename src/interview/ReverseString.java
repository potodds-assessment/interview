package interview;

public class ReverseString {

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
