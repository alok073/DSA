package binaryTree.examples;

public class ReverseLevelOrderRecursive {
	Tree root;

	public static void main(String[] args) {
		ReverseLevelOrderRecursive bTree = new ReverseLevelOrderRecursive();
		
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
		
		reverseLevelOrder(bTree.root); // 7 4 5 6 2 3 1
	}
	
	/**
	 * Exactly similar to LevelOrderTraversalRecursive just 1 change instead of going from 0 to height...we go from height to 0
	 * - Time = O(n^2)
	 *   Space = O(1)
	 * @param root
	 */
	public static void reverseLevelOrder(Tree root) {
		int height = heightOfBinaryTree(root);
		for(int i=height; i>=0; i--) {
			printNodeAtALevel(root, i);
		}
	}
	
	/**
	 * This function print all the nodes at level "level"
	 * - if level==0...print the node
	 * - go to left node and reduce level by 1
	 * - go to right node and reduce level by 1
	 * - if root is null....return
	 * @param root
	 * @param level
	 */
	public static void printNodeAtALevel(Tree root, int level) {
		if(root == null) {
			return;
		}
		if(level == 0) {
			System.out.print(root.data + " ");
		}
		printNodeAtALevel(root.left, level-1);
		printNodeAtALevel(root.right, level-1);
	}
	
	/**
	 * Returns the height of the BinaryTree
	 * @param root
	 * @return
	 */
	public static int heightOfBinaryTree(Tree root) {
		if(root == null) {
			return 0;
		}
		int leftTreeHeight = heightOfBinaryTree(root.left);
		int rightTreeHeight = heightOfBinaryTree(root.right);
		
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}

}
