package com.lld.lru.eviction_policy;

import com.lld.lru.Node;

public class LRUEvictionPolicy<K, V> implements EvictionPolicy<K, V> {
	private Node<K, V> head; // Most recently used
	private Node<K, V> tail; // Least recently used

	public LRUEvictionPolicy() {
		this.head = new Node<>(null, null); // dummy
		this.tail = new Node<>(null, null); // dummy
		this.head.next = tail;
		this.tail.prev = head;
	}

	private void removeNode(Node<K, V> node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void addToHead(Node<K, V> node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}

	private void moveToFront(Node<K, V> node) {
		removeNode(node);
		addToHead(node);
	}

	@Override
	public void onAccess(Node<K, V> node) {
		// When a node is accessed, it becomes the most recently used.
		// So, move it to the front of the DLL.
		moveToFront(node);
	}

	@Override
	public void onPut(Node<K, V> node) {

	}

	@Override
	public Node<K, V> evict() {
		return head;

	}

}
