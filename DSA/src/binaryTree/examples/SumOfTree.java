package binaryTree.examples;

public class SumOfTree {
	Tree root;

	public static void main(String[] args) {
		SumOfTree bTree = new SumOfTree();
		
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
		
		System.out.println(sumOfTree(bTree.root)); //21
	}
	
	/**
	 * sum = sumOfLeftTree + sumOfRightTree + currentNode.data
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 * @return
	 */
	public static int sumOfTree(Tree root) {
		if(root == null) {
			return 0;
		}
		int leftTreeSum = sumOfTree(root.left);
		int rightTreeSum = sumOfTree(root.right);
		
		return (leftTreeSum + rightTreeSum + root.data);
	}

}
