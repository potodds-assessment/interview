package singleton;

public class SingletonInitOndemandHolder {
    private SingletonInitOndemandHolder() {
    }
 
    private static class LazyHolder {
        private static final SingletonInitOndemandHolder INSTANCE = new SingletonInitOndemandHolder();
    }
 
    public static SingletonInitOndemandHolder getInstance() {
        return LazyHolder.INSTANCE;
    }
}
