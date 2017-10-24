package interview;

public class HashMap<K, V> {
	private static final int SIZE = 16;
	private Entry<K, V>[] table = new Entry[SIZE];
	
	public void put(K key, V value) {
		Entry current = table[key.hashCode()];
		for(; current != null; current = current.next) {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			} else {
				//Collision
			}
		}
		Entry<K,V> newEntry = new Entry<>(key, value);
		newEntry.next = table[key.hashCode()];
		table[key.hashCode()] = newEntry;
	}
	
	public V get(K key) {
		Entry<K, V> current = table[key.hashCode()];
		while(current != null) {
			if (current.key.equals(key)) return current.value;
			current = current.next;
		}
		return null;
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
