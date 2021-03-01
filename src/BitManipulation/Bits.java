package BitManipulation;

public class Bits {
	
	public int testXOR(int a, int b) {
		return a ^ b;
	}
	
	public void run() {
		System.out.println(testXOR(1,1));
		System.out.println(testXOR(23432,23432));
	}
	
	public static void main(String[] args) {
		new Bits().run();
	}
}
