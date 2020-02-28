package com.bridgelabz.datastructures.utils;

import org.apache.log4j.Logger;

public class Queue<T> {
	T queue[];
	int size;
	int front;
	int	rear;
	int capacity;
	Logger logger = Logger.getLogger(Queue.class);
	
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		capacity = size;
		queue = (T[]) new Object[size];
	}
	
	public void enqueue(T data) {
		if(!isFull()) {
			queue[rear] = data;
			rear = (rear+1) % capacity;//circular array loop
			size++;
		}else
			logger.info("Queue is full");
	}
	
	public T dequeue() {
		T data = queue[front];
		if(!isEmpty()) {
			front = (front+1) % capacity;//circular array loop
			size--;
		}else
			logger.info("Queue is empty");
		return data;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void printQueue() {
		for(int i=0; i<size; i++) {
			logger.info((front+i) % capacity);//circular array loop
		}
	}
}
