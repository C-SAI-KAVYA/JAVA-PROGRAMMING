package com.bridgelabz.stockaccount.utils;

import java.util.Stack;

import org.apache.log4j.Logger;


public class LinkedList<T> {

	Logger logger = Logger.getLogger(LinkedList.class);
	public Node<T> head;// by default null
	Node<T> first;

	/**
	 * constructor to initialize the list with null
	 */
	public LinkedList() {
		first = null;
	}

	/**
	 * Purpose: method for checking list is empty or not
	 * 
	 * @return returns true if empty else returns false
	 */
	public boolean isEmpty() {
		return head == null;
	}


	/**
	 * method to insert the node at the beginning
	 * 
	 * @param data
	 */
	public void insert(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;

		node.next = head;// the current node which is head will be the next node
		head = node;// the newly inserting node will be the head
		// and its inserted
	}// add at start

	/**
	 * Method to insert node at the end of the list
	 * 
	 * @param data
	 */
	public void insertAtEnd(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;// Optional because by default object for the node is null
		/**
		 * take this step only when the list is empty (no nodes in list)
		 */
		if (head == null) {
			head = node;
		}
		/**
		 * if your list is not empty take this step
		 */
		else {
			Node<T> n = head;// temporary node to check the position of each node
			/**
			 * to traverse between the nodes and to find the last node use the following
			 */
			while (n.next != null) {
				/**
				 * if null is detected you are at the end of the list till then go on traversing
				 */
				n = (Node<T>) n.next;// jumping between the nodes. first it was head now it will be the next node
			}
			/**
			 * as soon as you get null change the value here
			 */
			n.next = node;
		}
	}// add at end

	/**
	 * method to insert a node anywhere in between the two nodes
	 * 
	 * @param index
	 * @param data
	 */
	public void insertAnywhereInBetween(int index, T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;

		/**
		 * for zeroth location we need to write a special case because it will add at
		 * the starting point
		 */
		if (index == 0) {
			insert(data);
		}
		/**
		 * for rest all positions this below procedure holds good
		 */
		else {
			Node<T> n = head;
			/**
			 * to add a node in the index position reach to the index-1 position by using
			 * following procedure
			 */
			for (int i = 0; i < index - 1; i++) {
				n = n.next;// traversing
			}
			node.next = n.next;// reference of index-1 node(n) to the new node(node)
			n.next = node;// giving the reference of new node to the index-1 node
		}
	}// add anywhere in between
	
    /* function to insert a new_node in a list. */
    public void sortedInsert(Node<T> new_node) 
    { 
         Node<T> current; 
  
         /* Special case for head node */
         if (head == null || head.data.equals((new_node.data))) 
         { 
            new_node.next = head; 
            head = new_node; 
         } 
         else { 
  
            /* Locate the node before point of insertion. */
            current = head; 
  
            while (current.next != null && 
                   !(current.next.data.equals(new_node.data))) 
                  current = current.next; 
  
            new_node.next = current.next; 
            current.next = new_node; 
         } 
     } 

    /**
	 * Purpose: method for delete node at start
	 * 
	 * @param index input from user
	 */
	public void deleteAt(T index) {
		if (index.equals(null)) {
			head = head.next;
		} else {
			Node<T> n = head;
			Node<T> n1 = null;
			while (!(n.data.equals(index))) {
				n1=n;
				n = n.next;
			}
			n1.next = n.next;
//			System.out.println("Node deleted is: " + n1.data);
		}
	}
	/**
	 * Purpose: method for deleting node at last index
	 */
	public void deleteAtEnd() {
		if (!isEmpty()) {
			Node<T> n = head;

			while (n.next != null) {
				n = n.next;
			}

			n.next = null;

		} else {
			System.out.println("Linked list is empty nothing to delete");
		}
	}
		
	/**
	 * method to return the length of the linked list using recursive approach
	 * 
	 * @return
	 */
	public int length() {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}// count

	/**
	 * method to sort the linked list
	 * 
	 * @param <T>
	 * @param size
	 */
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> void sortLinkedList(int size) {
		@SuppressWarnings("unchecked")
		Node<T> n = (Node<T>) head;
		Node<T> n1 = n.next;
		T temp;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j <= size - 1 - i - 1; j++) {

				if (n.data.compareTo(n1.data) > 0) {
					temp = n.data;
					n.data = n1.data;
					n1.data = temp;
				}
				n1 = n1.next;
			}
			n = n.next;
			n1 = n.next;
		}
	}// sort the linked list in order

	/**
	 * method to check whether node is present in the list or no
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public boolean checkNodeIsPresentOrNo(T x) {
		Node<T> current = head;// initialize current
		boolean isFound = false;
		while (current != null) {
			if (current.data.equals(x)) {
				isFound = true; // data found
				break;
			}
			current = current.next; // traversing
		}
		return isFound;
	}// present or no

	/**
	 * method to get the Nth node, N can be any number
	 * 
	 * @param index
	 * @return
	 */
	public T getNodeOnIndex(int index) {
		Node<T> current = head;
		int count = 0;
		while (current != null) {
			if (count == index)
				return current.data;
			count++;
			current = current.next;// traversing
		}
		assert (false);
		return null;
	}// get on index

	/**
	 * method to get the last Nth node in the list
	 * 
	 * @param n
	 * @return
	 */
	public T getNthNodeFromLast(int n) {
		int length = 0;
		Node<T> temp = head;
		/**
		 * count the number of nodes in linked list
		 */
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		/**
		 * check if value of n is not more than length of the linked list
		 */
		if (length < n)
			return null;
		temp = head;

		/**
		 * get the (len-n+1)th node from the beginning
		 */
		for (int i = 1; i < length - n + 1; i++)
			temp = temp.next;

		return temp.data;
	}// get nth node from last

	/**
	 * method to print the middle element in the list
	 * 
	 * @return
	 */
	public T getMiddleNodeInList() {
		Node<T> previousNode = head;
		Node<T> nextNode = head;

		if (head != null) {
			while (nextNode != null && nextNode.next != null) {
				nextNode = nextNode.next.next;
				previousNode = previousNode.next;
			}
			return previousNode.data;
		} else
			return null;
	}// get the middle node

	/**
	 * 
	 * @returns index value, -1 if object was not found
	 */
	public int indexOf(Object obj) {

		int index = 0;
		Node<T> current = head.next;
		while (current != null) {
			if (current.data.equals(obj)) {
				return index;
			}
			index++;
			current = current.next;
		}
		if (index == 0 && obj == null) {
			return -1;
		} else {
			return index;
		}
	}// get the index of the node

	/**
	 * Method to count the number of occurences of a element in linked list
	 * 
	 * @param occuringElement
	 * @return
	 */
	public int numberOfOccurencesOfNode(T occuringElement) {
		Node<T> current = head;
		int count = 0;
		while (current != null) {
			if (current.data.equals(occuringElement))
				count++;// Number of times occured
			current = current.next; // traversing
		}
		return count;
	}// find how many time the node is present in the list

	/**
	 * Method to check whether the given list is palindrome or no
	 * 
	 * @param head
	 * @return
	 */
	public boolean listIsPalindrome(Node<T> head) {
		Node<T> current = head;
		boolean isPalindrome = true;
		Stack<T> stack = new Stack<T>();

		while (current != null) {
			stack.push(current.data);
			current = current.next;
		}

		while (head != null) {
			T i = stack.pop();
			if (head.data.equals(i)) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
			head = head.next;
		}
		return isPalindrome;
	}// check whether the list is palindrome or not

	/**
	 * method to remove duplicates from the sorted list
	 */
	public void removeDuplicatesSorted() {
		// reference to head
		Node<T> current = head;

		// traverse list till the last node
		while (current != null) {
			Node<T> temp = current;
			/**
			 * compare current node with the next node and keep on deleting them until it
			 * matches the current node data
			 */
			while (temp != null && temp.data == current.data) {
				temp = temp.next; // traverse
			}
			/**
			 * set current node next to the next different element denoted by temp
			 */
			current.next = temp;
			current = current.next;
		}
	}// remove duplicates from the sorted list

	/**
	 * method to remove duplicates from an unsorted list
	 */
	public void removeDuplicatesUnsorted() {
		Node<T> node1 = null, node2 = null, duplicate = null;
		node1 = head;

		while (node1 != null && node1.next != null) {
			node2 = node1;

			/**
			 * compare the picked element with rest of the elements
			 */
			while (node2.next != null) {
				// If duplicates are present then delete
				if (node1.data.equals(node2.next.data)) {
					duplicate = node2.next;
					logger.info("duplicate is" + duplicate);
					node2.next = node2.next.next;
					System.gc();// garbage collector to store the removed duplicates
				} else {
					node2 = node2.next;
				}
			}
			node1 = node1.next;
		}
	}// remove duplicates from an unsorted list

	/**
	 * method to segregateEvenOdds in the linked list
	 */
	public void segregateEvenOdd() {
		Node<Integer> head = null;
		Node<Integer> end = head;
		Node<Integer> prev = null;
		Node<Integer> current = head;

		/* Get pointer to last Node */
		while (end.next != null)
			end = end.next;

		Node<Integer> new_end = end;

		// Consider all odd nodes before getting first eve node
		while (current.data % 2 != 0 && current != end) {
			new_end.next = current;
			current = current.next;
			new_end.next.next = null;
			new_end = new_end.next;
		}

		// do following steps only if there is an even node
		if (current.data % 2 == 0) {
			head = current;

			// now current points to first even node
			while (current != end) {
				if (current.data % 2 == 0) {
					prev = current;
					current = current.next;
				} else {
					/* Break the link between previous and current */
					prev.next = current.next;

					/* Make next of current as null */
					current.next = null;

					/* Move current to end */
					new_end.next = current;

					/* Make current as new end of list */
					new_end = current;

					/* Update current pointer */
					current = prev.next;
				}
			}
		}

		/* We have to set prev before executing rest of this code */
		else
			prev = current;

		if (new_end != end && end.data % 2 != 0)

		{
			prev.next = end.next;
			end.next = null;
			new_end.next = end;
		}
	}// segregate even and odd positions in the list
	/**
	 * Method to store the content of the text file into the linked list of string type
	 * 
	 * @param fileName
	 * @return
	 */
	public LinkedList<String> textFileToStringLinkedList(String fileName) {
		String content = InputUtility.readFileToString(fileName);
		String[] words = content.split("\\s+");
		LinkedList<String> listOfStrings = new LinkedList<String>();
		for (String word : words)
			listOfStrings.insert(word);
		return listOfStrings;
	}// store the text file content to the linked list
	
	/**
	 * Method to store the content of the text file into the linked list of Integer type
	 * 
	 * @param fileName
	 * @return
	 */
	public LinkedList<Integer> textFileToIntLinkedList(String fileName) {
		String content = InputUtility.readFileToString(fileName);
		LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
		
		String[] words = content.split("\\s+");
		
		Integer[] ints = listOfIntegers.stringToIntArray(words);
		for (Integer integers : ints)
			listOfIntegers.insert(integers);
		return listOfIntegers;
		
	}// store the text file content to the linked list

	/**
	 * static method to convert of integer values into int array
	 * 
	 * @param primeNumbers
	 * @return int array of Prime Numbers
	 */
	private Integer[] stringToIntArray(String[] primes) {
		Integer[] primeNumbers = new Integer[primes.length];
		// converting each value from String to int
		for (int i = 0; i < primes.length; i++) {
			primeNumbers[i] = Integer.parseInt(primes[i]);
		}
		return primeNumbers;
	}
	
	/**
	 * method is used to write the linked list content to string
	 * @param list
	 * @return
	 */
	public String linkedListToString(LinkedList<T> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = list.length()-1; i > 0; i--) {
			sb.append(list.getNodeOnIndex(i) + " ");
		}
		String string = sb.toString();
		return string;
	}// store the linked list content to string


	/**
	 * Purpose: method which convert list in string and return it
	 * 
	 * @return returns the list in string
	 */
	public String linkedListToString() {
		String str = "\n";
		Node<T> n = head;
		while (n.next != null) {
			str += n.data + " ";
			n = n.next;
		}
		str += n.data;
		return str;
	}
	
	 public Node<T> reverse(Node<T> node) 
	    { 
	        Node<T> prev = null; 
	        Node<T> current = node; 
	        Node<T> next = null; 
	        while (current != null) { 
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next; 
	        } 
	        node = prev; 
	        return node; 
	    } 
	/**
	 * method to print all the nodes in the list
	 */
	public void display() {
		Node<T> node = head; // always start with head

		// Traversing till last node to print the last entry
		/**
		 * as soon as you are detecting null the loop gets exited so last value will not
		 * be printed
		 */
		while (node.next != null) {
			logger.info(node.data);
			// Every time you print it shift to next node
			node = (Node<T>) node.next;
		}
		logger.info(node.data);// printing the last element in the list
	}
	
	public String toString() {
		String string = "[ ";
		Node<T> node = head; // a
		
		
		while (node != null) {
			string = string+node.data;
			if(node.next != null)
				string=string+" ";
			node = (Node<T>) node.next;
		}
		return string+" ]";
	}
	
	/**
	 * Purpose: printing the list without using spaces
	 */
	public String showListWithoutSpaces() {
		String str = "";
		Node<T> n = head;
		while (n.next != null) {
			str += n.data;
			n = n.next;
		}
		str += n.data;
		return str;
	}
}
