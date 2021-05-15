package binaryTree.examples;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterative {
	Tree root;

	public static void main(String[] args) {
		LevelOrderIterative bTree = new LevelOrderIterative();
		
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
		
		levelOrderIterative(bTree.root);
	}
	
	/**
	 * - create a queue and insert root node
	 * - perform below steps until queue is empty
	 * 		- pop a node from queue and print it
	 * 		- insert it's left child then right child in queue
	 * - Time = O(n)
	 *   Space = O(n)
	 * @param root
	 */
	public static void levelOrderIterative(Tree root) {
		Tree currentNode = root;
		Queue<Tree> treeQueue = new LinkedList<Tree>();
		treeQueue.add(currentNode);
		
		while(!treeQueue.isEmpty()) {
			currentNode = treeQueue.poll();
			System.out.print(currentNode.data + " ");
			
			if(currentNode.left != null) {
				treeQueue.add(currentNode.left);
			}
			if(currentNode.right != null) {
				treeQueue.add(currentNode.right);
			}
		}
	}

}
