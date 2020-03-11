package com.bridgelabz.stockaccount.utils;

@SuppressWarnings("hiding")
public class Node<Integer> {
	public Integer data;
	public Node<Integer> next;
	public Node<Integer> left;
	public Node<Integer> right;
	
	public Node() {
		
	}
	public Node(Integer key) {
		data = key;
		next = null;
		left = null;
		right = null;
	}
}
