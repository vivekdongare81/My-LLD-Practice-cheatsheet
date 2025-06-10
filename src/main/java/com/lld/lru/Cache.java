package com.lld.lru;

import java.util.HashMap;
import java.util.Map;

import com.lld.lru.eviction_policy.EvictionPolicy;

public class Cache <K,V>{
	private int capacity;
	private Map<K,Node<K,V>> cache;
	private EvictionPolicy<K,V> evictionPolicy;
	
	Cache(int capacity, EvictionPolicy<K,V> policy){
		this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
		this.evictionPolicy = policy;
	}
	
    public synchronized V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null; // Key not found
        }
        // Notify the eviction policy that this node was accessed (read)
        evictionPolicy.onAccess(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);

        if (node != null) {
            // Key already exists, update value and notify the policy (treat as access)
            node.value = value;
            evictionPolicy.onAccess(node);
        } else {
            // Key does not exist, create a new node
            Node<K, V> newNode = new Node<>(key, value);

            // Check if cache capacity is exceeded BEFORE adding the new node
            if (cache.size() >= capacity) {
                // If capacity is full, ask the eviction policy to determine the LRU node
                Node<K, V> lruNode = evictionPolicy.evict();
                if (lruNode != null) {
                    // Remove the evicted node from the main HashMap
                    cache.remove(lruNode.key);
                }
            }
            // Add the new node to the HashMap
            cache.put(key, newNode);
            // Notify the eviction policy that a new node has been added
            evictionPolicy.onPut(newNode);
        }
    }
    
    public synchronized int size() {
        return cache.size();
    }

    /**
     * Checks if the cache is empty.
     *
     * @return true if the cache is empty, false otherwise.
     */
    public synchronized boolean isEmpty() {
        return cache.isEmpty();
    }

    /**
     * Clears all entries from the cache and resets the eviction policy.
     */
    public synchronized void clear() {
        cache.clear();
        evictionPolicy.clear();
    }
    
}
