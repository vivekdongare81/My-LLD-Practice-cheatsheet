package com.lld.lru;

public class Node<K,V> {
	K key;
	V value;
    public Node<K, V> next;
    public Node<K, V> prev;
	public Node(K key, V value){
		this.key = key;
		this.value = value;
	}
}
