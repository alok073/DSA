package binaryTree.examples;

public class MaxOfTree {
	Tree root;

	public static void main(String[] args) {
		MaxOfTree bTree = new MaxOfTree();
		
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
		
		System.out.println(maxOfBinaryTree(bTree.root)); //6
	}
	
	/**
	 * Max = max(leftTreeMax, rightTreeMax, currentNode.data)
	 * Min = min(leftTreeMin, rightTreeMin, currentNode.data)
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 * @return
	 */
	public static int maxOfBinaryTree(Tree root) {
		if(root == null) {
			return 0;
		}
		int leftTreeMax = maxOfBinaryTree(root.left);
		int rightTreeMax = maxOfBinaryTree(root.right);
		
		return Math.max(Math.max(leftTreeMax, rightTreeMax), root.data);
	}

}
