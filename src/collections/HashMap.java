package collections;

/*************************************
 * @author lap
 *
 * Custom implementation of a HashMap
 * 1. hash hit, then check if value already exists
 * 2. hash miss, then add value
 * 3. hash hit, but value doesn't, append to list
 * 
 * Design
 * array of Entry objects.  Entry object contains key, value, pointer to next Entry object.
 * Each array position holds Entry objects with same hash code mapping.
 * Need to iterate the linked list of Entry objects to find matching value. 
 *
 * @param <K>
 * @param <V>
 */

public class HashMap<K, V> {
	private static final int SIZE = 16;
	private Entry<K, V>[] table = new Entry[SIZE];
	
	public void put(K key, V value) {
		int bucket = getBucket(key.hashCode());
		Entry current = table[bucket];
		for(; current != null; current = current.next) {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			} else {
				//Collision
			}
		}
		Entry<K,V> newEntry = new Entry<>(key, value);
		newEntry.next = table[bucket];
		table[bucket] = newEntry;
	}
	
	public V get(K key) {
		int bucket = getBucket(key.hashCode());		
		Entry<K, V> current = table[bucket];
		while(current != null) {
			if (current.key.equals(key)) return current.value;
			current = current.next;
		}
		return null;
	}
	
	private int getBucket(int hashCode) {
		return hashCode % SIZE;
	}
}

class Entry<K,V> {
	K key;
	V value;
	Entry<K, V> next;
	
	Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
}
