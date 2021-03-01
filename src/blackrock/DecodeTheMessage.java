package blackrock;

public class DecodeTheMessage {

	private static String encode(String text) {
		StringBuilder b = new StringBuilder();
		StringBuilder r = new StringBuilder(text);
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			b.append(c += c+i);
		}
		return b.reverse().toString();
	}	
	
//[76, 97, 112, 87, 97, 104, 76, 101, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	
//[-104, -61, -30, -79, -58, -43, -98, -47, -46, 0, 0, 0, 0, 0, 0, 0]	
    static String decode(String encodedMessage) {
    	StringBuilder b = new StringBuilder(encodedMessage);
    	String msg = b.reverse().toString();
    	
    	StringBuilder d = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			d.append((char)((c-i)/2));
		}
    	    	
    	return d.toString();
    }	
    
    public void run() {
    	System.out.println( decode(encode("LapWahLee")) );
    	
    }
	
	public static void main(String[] args) {
		new DecodeTheMessage().run();
	}

}
