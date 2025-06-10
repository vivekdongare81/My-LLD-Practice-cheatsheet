package com.lld.lru;

import com.lld.lru.eviction_policy.EvictionPolicy;
import com.lld.lru.eviction_policy.LRUEvictionPolicy;

public class App {
		public static void main(String[] args) {
			  // Create an LRU Eviction Policy instance
	        EvictionPolicy<String, Integer> lruPolicy = new LRUEvictionPolicy<>();
	        // Create an LRU Cache with capacity 3, injecting the policy
	        Cache<String, Integer> cache = new Cache<>(3, lruPolicy);

	        System.out.println("Putting (A, 1)");
	        cache.put("A", 1); // Cache: (A)
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("Putting (B, 2)");
	        cache.put("B", 2); // Cache: (B, A)
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("Putting (C, 3)");
	        cache.put("C", 3); // Cache: (C, B, A)
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("\nGetting A: " + cache.get("A")); // Cache: (A, C, B) - A is now MRU
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("\nPutting (D, 4)");
	        // B should be evicted as it's the LRU
	        cache.put("D", 4); // Cache: (D, A, C)
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("Getting B: " + cache.get("B")); // Expected: null (B was evicted)

	        System.out.println("\nGetting C: " + cache.get("C")); // Cache: (C, D, A) - C is now MRU
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("\nPutting (E, 5)");
	        // A should be evicted as it's the LRU
	        cache.put("E", 5); // Cache: (E, C, D)
	        System.out.println("Cache size: " + cache.size());

	        System.out.println("\nGetting A: " + cache.get("A")); // Expected: null (A was evicted)
	        System.out.println("Getting D: " + cache.get("D"));
	        System.out.println("Getting E: " + cache.get("E"));
	        System.out.println("Getting C: " + cache.get("C"));

	        System.out.println("\nClearing cache...");
	        cache.clear();
	        System.out.println("Cache size after clear: " + cache.size());
	        System.out.println("Is cache empty: " + cache.isEmpty());
		}
}
