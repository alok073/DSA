package binaryTree.examples;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesLevelWise {
	Tree root;

	public static void main(String[] args) {
		PrintNodesLevelWise bTree = new PrintNodesLevelWise();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		bTree.root.right.right = new Tree(6);
		bTree.root.left.right.right = new Tree(7);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \     \
		 *     4   5     6
		 *     	    \
		 *           7
		 */
		
		printNodesLevelWise(bTree.root); /**
										  * 1
										  * 2 3
										  * 4 5 6
										  * 7
										  */
	}
	
	/**
	 * CRUX = try a way to find out how many nodes are there at currentLevel and nextLevel
	 * - make a queue..insert root
	 * - currentLevel=1, nextLevel=0
	 * - while queue is not empty
	 * 		- pop and print the node...reduce currentLevel by 1
	 * 		- insert left child then right child in queue...and increment nextLevel for every child
	 * 		- if all nodes at currentLevel are printed i.e currentLevel=0
	 * 			- print next line, make currentLevel equal to nextLevel and nextLevel as 0
	 * - Time = O(n)
	 *   Space = O(n)
	 * @param root
	 */
	public static void printNodesLevelWise(Tree root) {
		Queue<Tree> treeQueue = new LinkedList<Tree>();
		Tree currentNode = root;
		treeQueue.add(currentNode);
		int currentLevel=1, nextLevel=0;
		
		while(!treeQueue.isEmpty()) {
			currentNode = treeQueue.poll();
			System.out.print(currentNode.data + " ");
			currentLevel--;
			
			if(currentNode.left != null) {
				treeQueue.add(currentNode.left);
				nextLevel++;
			}
			if(currentNode.right != null) {
				treeQueue.add(currentNode.right);
				nextLevel++;
			}
			
			if(currentLevel == 0) {
				System.out.println("");
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}

}
