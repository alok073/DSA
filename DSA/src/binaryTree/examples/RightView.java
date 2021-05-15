package binaryTree.examples;

public class RightView {
	private static int maxLevel = 0;
	Tree root;

	public static void main(String[] args) {
		RightView bTree = new RightView();
		
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
		
		rightView(bTree.root, 0);
	}
	
	/**
	 * CRUX = go to right node then left node and increase level by 1 for every call....if level equals MaxLevel print this node
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 * @param level
	 */
	public static void rightView(Tree root, int level) {
		if(root == null) {
			return;
		}
		if(maxLevel == level) {
			System.out.print(root.data + " ");
			maxLevel++;
		}
		rightView(root.right, level+1);
		rightView(root.left, level+1);
	}
}
