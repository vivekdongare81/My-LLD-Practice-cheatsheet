package com.lld.lru;

import java.util.HashMap;
import java.util.Map;

import com.lld.lru.eviction_policy.EvictionPolicy;

public class Cache <K,V>{
	private int capacity;
	private Map<K,Node<K,V>> map;
	private EvictionPolicy evictionPolicy;
	
	Cache(int capacity, EvictionPolicy policy){
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.evictionPolicy = policy;
	}
	
}
