package binaryTree.examples;

public class LeftView {
	Tree root;
	private static int maxLevel = 0;

	public static void main(String[] args) {
		LeftView bTree = new LeftView();
		
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
		
		leftView(bTree.root, 0);
	}
	
	/**
	 * print the node only when level and maxLevel are equal
	 * CRUX = go to left node then go to right node and increase level by 1 for every call...if level & maxLevel are equal print this node
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 * @param level
	 */
	public static void leftView(Tree root, int level) {
		if(root == null) {
			return;
		}
		if(maxLevel == level) {
			System.out.print(root.data + " ");
			maxLevel++;
		}
		leftView(root.left, level+1);
		leftView(root.right, level+1);
		
	}

}
