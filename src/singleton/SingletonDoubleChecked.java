package singleton;

public class SingletonDoubleChecked {
	private volatile static SingletonDoubleChecked _instance;
	
	private SingletonDoubleChecked() {}
	
	public static SingletonDoubleChecked getInstance() {
		if (_instance == null) {
			synchronized(SingletonDoubleChecked.class) {
				if (_instance == null) {
					_instance = new SingletonDoubleChecked();
				}
			}
		}
		return _instance;
	}
}
