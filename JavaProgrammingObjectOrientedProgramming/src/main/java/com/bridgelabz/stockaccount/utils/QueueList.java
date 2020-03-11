package com.bridgelabz.stockaccount.utils;

import org.apache.log4j.Logger;

public class QueueList<T> {

	Logger logger = Logger.getLogger(QueueList.class);
	LinkedList<T> list = new LinkedList<>();
	Node<T> front, rear;
	int size = 0;

	// Zero argument constructor
	public QueueList() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	// Add item to the end of the list.
	public void enqueue(T key) {
		Node<T> oldRear = rear;
		rear = new Node<T>();
		rear.data = key;
		rear.next = null;
		if (isEmpty()) {
			front = rear;
		} else {
			oldRear.next = rear;
		}
		size++;
	}

	// Remove item from the beginning of the list.
	public T dequeue() {
		T data = front.data;
		front = front.next;
		if (isEmpty()) {
			rear = null;
		}
		size--;
		return data;
	}
	
	public T getElement(T key) {
		// Store head node
		Node<T> temp = front;
		// If head node itself holds the key to be deleted
		if (temp != null && temp.data.equals(key)) {
			front = temp.next; // head changed
			return front.data;
		}

		// search for the key to be deleted, keep track of the previous node as
		// we need to change temp.next

		while (temp != null && !(temp.data.equals(key))) {
			temp = temp.next;
		}
		// If key was not present in the linked list
				if (temp == null)
					return null;
		return temp.data;
	}
	
	public T get() {
		return list.getNodeOnIndex(size);
	}
	/**
	 * method to get the Nth node, N can be any number
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return list.getNodeOnIndex(index);
	}// get on index
	
	public int size() {
		return size;
	}
	
	public void showQueueWithoutSpace() {
		list.showListWithoutSpaces();
	}
	
	public void display() {
		for(int i=0;i<size;i++) {
			OutputUtility.print(front.data);
			front = front.next;
		}
	}
}
