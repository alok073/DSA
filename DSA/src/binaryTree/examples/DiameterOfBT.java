package binaryTree.examples;

public class DiameterOfBT {
	Tree root;
	private static int diameter = 0;

	public static void main(String[] args) {
		DiameterOfBT bTree = new DiameterOfBT();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2); 
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		/**
		 * 			1
		 *        /   \
		 *       2     3
		 *      / \   
		 *     4   5
		 */
		
		diameterOfBt(bTree.root);
		System.out.println(diameter); //4
	}
	
	/**
	 * Diameter of BT = longest path between two leaf nodes of a tree
	 * - Exactly similar to the calculate heightofBT function
	 * - maintain a global variable called as diameter=0
	 * - just after calculating heightOfLeftSubtree and heightOfRightSubtree
	 * - update the diameter variable with...max(diameter, heightOfLeftSubtree+heightOfRightSubtree+1)
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 * @return
	 */
	public static int diameterOfBt(Tree root) {
		if(root == null) {
			return 0;
		}
		int leftTreeHeight = diameterOfBt(root.left);
		int rightTreeHeight = diameterOfBt(root.right);
		
		diameter = Math.max(diameter, leftTreeHeight + rightTreeHeight + 1);
		
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}
}
