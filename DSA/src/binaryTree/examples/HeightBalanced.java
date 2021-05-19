package binaryTree.examples;

public class HeightBalanced {
	Tree root;
	
	public static void main(String[] args) {
		HeightBalanced bTree = new HeightBalanced();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.left.left = new Tree(3);
		/**
		 * 			1
		 *         /
		 *        2
		 *       /
		 *      3   
		 */
		int isHeightBalanced = checkIfHeightBalanced(bTree.root); // -1
		if(isHeightBalanced == -1) {
			System.out.println("Binary tree is not height balanced");
		}
		else {
			System.out.println("Binary tree is height balanced");
		}
	}
	
	/**
	 * CRUX -> - A BT is heightBalanced if abs(heightOfLeftSubtree - heightOfRightSubTree) <=1
	 *         - If greater than 1...it is unBalanced
	 * - This is exactly similar to heightOfBT....with just 1 modification
	 * - just add the checkBalanced condition....and if its true return -1
	 * - AND for every recursive call...check if "-1" was returned...if yes then return "-1" as it is without calculating the height
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 * @return
	 */
	public static int checkIfHeightBalanced(Tree root) {
		if(root == null) {
			return 0;
		}
		
		int leftSubtreeHeight = checkIfHeightBalanced(root.left);
		if(leftSubtreeHeight == -1) return -1;
		int rightSubtreeHeight = checkIfHeightBalanced(root.right);
		if(rightSubtreeHeight == -1) return -1;
		
		//Height balanced condition
		if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
			return -1;
		}
		
		//returns height
		return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
	}

}
