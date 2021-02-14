package basic;

public class DoubleCheckedSingleton {
	private volatile static DoubleCheckedSingleton _instance;
	
	private DoubleCheckedSingleton() {}
	
	public static DoubleCheckedSingleton getInstance() {
		if (_instance == null) {
			synchronized(DoubleCheckedSingleton.class) {
				if (_instance == null) {
					_instance = new DoubleCheckedSingleton();
				}
			}
		}
		return _instance;
	}
}
