package binaryTree.examples;

import java.util.Stack;

public class SpiralOrderTraversal {
	Tree root;

	public static void main(String[] args) {
		SpiralOrderTraversal bTree = new SpiralOrderTraversal();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		bTree.root.right.right = new Tree(6);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \     \
		 *     4   5     6
		 */
		
		spiralOrderTraversal(bTree.root); // 1 2 3 6 5 4
	}
	
	/**
	 * - create 2 stacks...insert root in stack1
	 * - iterate until both stacks are empty
	 * 		- while any node is present in stack1
	 * 			- pop it, print it and insert left 1st and then right child in stack2
	 * 		- while any node is present in stack2
	 * 			- pop it, print it and insert right 1st and then left child in stack2
	 * - Time = O(n)
	 *   Space = O(n)
	 * @param root
	 */
	public static void spiralOrderTraversal(Tree root) {
		Stack<Tree> treeStack1 = new Stack<Tree>();
		Stack<Tree> treeStack2 = new Stack<Tree>();
		Tree currentNode = root;
		treeStack1.push(currentNode);
		
		while(!treeStack1.isEmpty() || !treeStack2.isEmpty()) {
			while(!treeStack1.isEmpty()) {
				currentNode = treeStack1.pop();
				System.out.print(currentNode.data + " ");
				if(currentNode.right != null) {
					treeStack2.push(currentNode.right);
				}
				if(currentNode.left != null) {
					treeStack2.push(currentNode.left);
				}
			}
			while(!treeStack2.isEmpty()) {
				currentNode = treeStack2.pop();
				System.out.print(currentNode.data + " ");
				if(currentNode.left != null) {
					treeStack1.push(currentNode.left);
				}
				if(currentNode.right != null) {
					treeStack1.push(currentNode.right);
				}
			}
		}
	}

}
