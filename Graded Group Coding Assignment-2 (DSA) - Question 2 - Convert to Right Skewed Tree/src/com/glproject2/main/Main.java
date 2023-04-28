package com.glproject2.main;

import java.util.*;

import com.glproject2.node.Node;

public class Main {
	
	Node node = null;

	public static void main(String[] args) {
		
	     Main tree = new Main();
	     
	     tree.node = new Node(50);
	     tree.node.left = new Node(30);
	     tree.node.right = new Node(60);
	     tree.node.left.left = new Node(10);
	     tree.node.right.left= new Node(55);  
	     
	     Node root = tree.convertToRightSkewedTree(tree.node);
	     tree.printTree(root);

	}
	
	public Node convertToRightSkewedTree(Node root) {//returns the new root of the BST after its conversion to skewed BST
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		
		Node newroot = new Node(list.get(0));
		int i;
		for(i = 1; i < list.size(); i++) {
			Node newnode = new Node(list.get(i));
			insertNode(newroot, newnode);
		}
		return newroot;
	}

	public void inOrder(Node root, List<Integer> list) {//Arranges the BST values in ascending order and adds them to an Array list
		if(root==null) return;
		else {
			inOrder(root.left, list);
			list.add(root.key);
			inOrder(root.right, list);
		}
	}
	
	public void insertNode(Node root, Node newnode) {//inserts a new node to the right subtree of the binary search tree
		if(root.right == null)
			root.right = newnode;
		else
			insertNode(root.right, newnode);
	}
	
	public void printTree(Node root) {//prints all values in the tree by traversing though the right subtree of the BST
		if(root == null) return;
		System.out.print(root.key+" ");
		printTree(root.right);
	}

}
