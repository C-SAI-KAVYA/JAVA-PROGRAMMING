package com.bridgelabz.datastructures.utils;

import org.apache.log4j.Logger;

public class HashMap<K, V> {

	private Entry<K, V>[] table;
	Logger logger = Logger.getLogger(HashMap.class);
	int capacity=0;
	
	//Inner class concept: Entry<K, V> is the member class of HashMap<K, V> class
	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}
	
	/**
	 * parameterized constructor to make the size of the HashMap dynamic based on requirement
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		this.capacity = capacity;
		table = new Entry[capacity];
	}
	
	
	/**
	 *Method for add values to the HashMap 
	 * @param newKey
	 * @param data
	 */
	public void put(K newKey, V data) {
		if(newKey == null)
			return; //does not allow to store null
		
		//calculate hash code of the key.
		int hash = hash(newKey);
		
		//create a new entry.
		Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
		
		//if table location does not contain any entry, store entry there
		if(table[hash] == null) {
			table[hash] = newEntry;
		}else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			
			//reached last entry to the table
			while(current != null) {
				if(current.key.equals(newKey)) {
					if(previous == null) {
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}
	
	 
	/**
	 * Method to return the value on entering the key pair
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int hash = hash(key);
		if(table[hash] == null) {
			return null;
		}else {
			Entry<K, V> temp = table[hash];
			while(temp != null) {
				if(temp.key.equals(key))
					return temp.value;
				temp = temp.next;
			}
			return null;
		}
	}
	public Entry<K, V> get(int hash, K key) {
		if(table[hash] == null) {
			return null;
		}else {
			Entry<K, V> temp = table[hash];
			while(temp != null) {
				if(temp.key.equals(key))
					return temp;
				temp = temp.next;
			}
			return null;
		}
	}
	
	public boolean containsKey(K key) {
        return get(hash(key), key) != null;
    }
	
    public boolean replace(K key, V oldValue, V newValue) {
        Entry<K, V> e; V v;
        if ((e = get(hash(key),key)) != null &&
            ((v = e.value) == oldValue || (v != null && v.equals(oldValue)))) {
            e.value = newValue;
            return true;
        }
        return false;
    }
	
	/**
	 * Method for removing the element based on the key
	 * @param deleteKey
	 * @return
	 */
	public boolean remove(K deleteKey) {
		int hash = hash(deleteKey);
		
		if(table[hash] == null) {
			return false;
		}else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			
			while(current != null) {
				if(current.key.equals(deleteKey)) {
					if(previous == null) {
						table[hash] = table[hash].next;
						return true;
					}else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}
	
	/**
	 * Method to display the content that hashmap holds
	 */
	public void display() {
		for(int i=0;i<capacity;i++) {
			if(table[i] != null) {
				Entry<K, V> entry = table[i];
				while(entry != null) {
					logger.info("{ "+entry.key+" = "+entry.value+" } "+" ");
					entry = entry.next;
				}
			}
		}
	}
	
	/**
	 * method to generate different hash code values to store the key value pairs of the map
	 * @param key
	 * @return
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}
