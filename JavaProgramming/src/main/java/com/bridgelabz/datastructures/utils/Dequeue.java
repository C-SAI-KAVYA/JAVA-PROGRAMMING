package com.bridgelabz.datastructures.utils;

import org.apache.log4j.Logger;

public class Dequeue<T> {

	T dequeue[];
	int front;
	int rear;
	int capacity;

	Logger logger = Logger.getLogger(Dequeue.class);
	
	/**
	 * constructor to make the dequeue capacity dynamic
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Dequeue(int size) {
		capacity = size;
		dequeue = (T[]) new Object[capacity];
		front = -1;
		rear = 0;
	}
	
	/**
	 * method to check whether the dequeue is full or no
	 * @return
	 */
	public boolean isFull() {
		return ((front == 0 && rear == capacity - 1) || front == rear + 1);
	}
	
	/**
	 * Method to check whether the dequeue is empty or no
	 * @return
	 */
	public boolean isEmpty() {
		return (front == -1);
	}
	
	/**
	 * method to add an element in front of the dequeue
	 * @param key
	 */
	public void insertFront(T key) {
		// check whether dequeue is full or not

		if (isFull()) {
			logger.info("Overflow");
			return;
		}

		// If dequeue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// front is at first position of queue
		else if (front == 0)
			front = capacity - 1;

		else // decrement front end by 1
			front = front - 1;

		// insert current element into dequeue
		dequeue[front] = key;
	}
	
	/**
	 * Method to add an element at the end of the dequeue
	 * @param key
	 */
	public void insertRear(T key) {
		if (isFull()) {
			logger.info("Overflow");
			return;
		}

		// If dequeue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// rear is at last position of dequeue
		else if (rear == capacity - 1)
			rear = 0;

		// increment rear end by 1
		else
			rear = rear + 1;

		// insert current element into dequeue
		dequeue[rear] = key;
	}
	
	/**
	 * Method to delete an element in the front of the dequeue
	 */
	public void deleteFront() {
		if (isEmpty()) {
			logger.info("Empty dequeue");
			return;
		}

		// dequeue has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == capacity - 1)
			front = 0;
		/**
		 * increment front by 1 to remove current front value from dequeue
		 */
		else
			front = front + 1;
	}
	
	/**
	 * method to delete the element in the end of the dequeue
	 */
	public void deleteRear() {
		if (isEmpty()) {
			logger.info("Emtpy");
			return;
		}

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0)
			rear = capacity - 1;
		else
			rear = rear - 1;
	}
	
	/**
	 * Method to get an element in the front
	 * @return
	 */
	public T getFront() {
		if (isEmpty()) {
			logger.info("empty");
			return null;
		}
		return dequeue[front];
	}
	
	/**
	 * Method to get an element from the last 
	 * @return
	 */
	public T getRear() {
		if (isEmpty() || rear < 0) {
			logger.info("Empty");
			return null;
		}
		return dequeue[rear];
	}
	public void printDequeue() {
		for(int i=0; i<capacity; i++) {
			logger.info((front+i) % capacity);//circular array loop
		}
	}
}
