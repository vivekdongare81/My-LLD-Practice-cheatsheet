package com.lld.lru.eviction_policy;

import com.lld.lru.Node;

public interface EvictionPolicy<K, V> {
	void onAccess(Node<K, V> node);

	void onPut(Node<K, V> node);

	Node<K, V> evict();
	
	void clear();
}
