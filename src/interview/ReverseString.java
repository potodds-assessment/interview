package interview;

public class ReverseString {

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
		System.out.println(new ReverseString().reverse("abcdefghijklmnop"));
		System.out.println(new ReverseString().reverseRecursively("abcdefghijklmnop"));
	}
}
