package interview;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyConcurrentHashMap<K,V> {
	private Map<K,V> hashMap = new HashMap<>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	public void put(K key, V value) {
		writeLock.lock();
		try {
			hashMap.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public V get(K key) {
		readLock.lock();
		try {
			return hashMap.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public boolean containsKey(K key) {
		readLock.lock();
		try {
			return hashMap.containsKey(key);
		} finally {
			readLock.unlock();
		}
	}

	public void remove(K key) {
		writeLock.lock();
		try {
			hashMap.remove(key);
		} finally {
			writeLock.unlock();
		}
	}
}
