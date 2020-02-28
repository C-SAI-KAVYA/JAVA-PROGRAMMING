package com.bridgelabz.datastructures.utils;

public class BinarySearchTree<T> {
	
	@SuppressWarnings("hiding")
	public class Node<T>{
		public Node<T> left;
		public Node<T> right;
		int data;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public class BinaryTrees{
		public int bst;
		public int max;
		public int min;
		
		boolean isBst;
		
		public BinaryTrees(int a, int b, int c, boolean d) {
			bst = a;
			max = b;
			min = c;
			isBst = d;
		}
		
		public BinaryTrees() {
			
		}
	}
	
	public BinaryTrees numberOfBst(Node<T> root) {
		
		//Base case
		if(root == null)
			return new BinaryTrees(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
		
		/**
		 * if leaf node then return from function and store information about the leaf 
		 * node 
		 */
		if(root.left == null && root.right == null)
			return new BinaryTrees(1, root.data, root.data, true);
		
		//store information about the left subtree
		BinaryTrees l = numberOfBst(root.left);
		
		//information about right subtree
		BinaryTrees	r = numberOfBst(root.right); 
		
		//create a node that has to be returned 
		BinaryTrees bst = new BinaryTrees();
		bst.min = Math.min(root.data, (Math.min(l.min, r.min)));
		bst.max = Math.max(root.data, (Math.max(l.max, r.max)));
		
		/**
		 * if whole tree rooted under the current root is binary search tree
		 */
		if(l.isBst && r.isBst && root.data > l.max && root.data < r.min) {
			//update the number of binary search trees
			bst.isBst = true;
			bst.bst = 1 + l.bst + r.bst;
		}
		
		//If the whole tree is not a binary search tree update the number of binary search trees
		
		else {
			bst.isBst =false;
			bst.bst = l.bst + r.bst;
		}
		return bst;
	}
}