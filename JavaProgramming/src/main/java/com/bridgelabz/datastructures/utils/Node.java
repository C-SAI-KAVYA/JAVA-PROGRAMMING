package com.bridgelabz.datastructures.utils;

public class Node<T> {
	T data;
	Node<T> next;
	Node<T> left;
	Node<T> right;
	
	public Node() {	
	}
	public Node(T key) {
		data = key;
		next = null;
		left = null;
		right = null;
	}
}
