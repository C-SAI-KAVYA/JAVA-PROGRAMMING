package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.BinarySearchTree;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.BinarySearchTree.Node;

public class BinarySearchTreeTester {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		/**
		 * Setting up logger
		 */
		LogsUtility.setLog("BinarySearchTreeTester");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "BinarySearchTreeTester.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Number of Binary search trees present ");
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
	
		Node root = tree.new Node(5);
		
		root.left = tree.new Node(9);
		root.right = tree.new Node(3);
		root.left.left = tree.new Node(6);
		root.right.right = tree.new Node(4);
		root.left.left.left = tree.new Node(8);
		root.left.left.right = tree.new Node(7);
		
		logger.info(tree.numberOfBst(root).bst+" number of sub binary trees are present in a binary tree");
	}

}
