package com.bridgelabz.datastructures.utils;

import org.apache.log4j.Logger;

public class StackList<T> {
		  
	Logger logger = Logger.getLogger(StackList.class);
	LinkedList<T> stack = new LinkedList<T>();
	public static int top = 0;

	/**
	 * Purpose: push the element into stack
	 * 
	 * @param data push data into stack
	 */
	public void push(T data) {

		stack.insert(data);
		top++;

	}

	/**
	 * Purpose: pop the element from stack
	 * 
	 * @return returns data which is popped
	 */
	public void pop() {

		if (isEmpty()) {
			logger.info("Stack is underflow");
		} else {
			stack.deleteAtEnd();
			top--;

		}

	}

	/**
	 * Purpose: show top element of stack
	 * 
	 * @return returns top data
	 */

	public T peek() {
		if (!isEmpty()) {
			T data;
			data = (T) stack.getNodeOnIndex(top);
			return data;
		}
		return null;

	}

	/**
	 * Purpose: check stack is empty or not
	 * 
	 * @return return true if empty else true
	 */
	public boolean isEmpty() {

		return stack.isEmpty();
	}

	/**
	 * Purpose: check stack is full or not (not applicable in linked list)
	 * 
	 * @return return true if full else true
	 */
	/*
	 * public boolean isFull() {
	 * 
	 * return top == stack.length; }
	 */

	/**
	 * Purpose: show stack values
	 */
	public void display() {
		/*
		 * for (Object num : stack) { System.out.print(num + " "); }
		 * System.out.println();
		 */
		stack.display();
	}
	
	public int getCount( Node<T> head) 
	{ 
	    int count = 0; // Initialize count 
	    Node<T> current = head; // Initialize current 
	    while (current != null) 
	    { 
	        count++; 
	        current = current.next; 
	    } 
	    return count; 
	} 
	
	public int size(Node<T> head) {
		return getCount(head);
	}
	
	public void printReverse() {
		Node<T> reverse = stack.reverse(stack.head);
		printList(reverse);
	}
	void printList(Node<T> node) 
    { 
        while (node != null) { 
            logger.info(node.data + " "); 
            node = node.next; 
        } 
    } 
	
	public void showStackWithoutSpace() {
		stack.showListWithoutSpaces();
	}
}
