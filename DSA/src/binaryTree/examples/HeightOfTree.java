package binaryTree.examples;

public class HeightOfTree {
	Tree root;

	public static void main(String[] args) {
		HeightOfTree bTree = new HeightOfTree();
		
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
		
		System.out.println(heightOfTree(bTree.root)); //3
	}
	
	/**
	 * Height = max(heightOfLeftTree, heightOfRightTree) + 1;
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 * @return
	 */
	public static int heightOfTree(Tree root) {
		if(root == null) {
			return 0;
		}
		
		int leftSubtreeHeight = heightOfTree(root.left);
		int rightSubtreeHeight = heightOfTree(root.right);
		
		return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
	}

}
