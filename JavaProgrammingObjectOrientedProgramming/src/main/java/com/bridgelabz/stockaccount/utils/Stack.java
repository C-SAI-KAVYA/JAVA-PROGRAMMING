package com.bridgelabz.stockaccount.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class Stack<T> {
	
	Logger logger = Logger.getLogger(Stack.class);
	T stack[];
	int top = 0;
	int capacity;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		capacity = size;
		stack = (T[]) new Object[size];
	}
	
	public void push(T data) {
		int size = size();
		if(size >= capacity) {
			int newSize = size + (size >> 1);
			stack = Arrays.copyOf(stack, newSize);
		}
		stack[top] = data;
		top++;
	}
	
	public T pop() {
		
		T data;
		if(isEmpty()) {
			logger.info("Empty stack");
		}
		top--;//because it will be referring to the next empty place of the stack
		data = stack[top];
		stack[top] = null;
		
		//reducing the size because of popping out the content
		int size = size();
		int reducedSize = size;
		if(size >= capacity && size < (reducedSize + (reducedSize << 1))) {
			System.arraycopy(stack, 0, stack, 0, size);
		}
		return data;
	}
	
	public T peek() {
		T data;
		data = stack[top-1];//last value that is inserted
		return data;
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top<=0;
	}
	
	/**
	 * Purpose: show stack values
	 */
	public void printStack() {
		for (Object num : stack) {
			System.out.print(num + " ");
		}
	}
	
	
	
}
