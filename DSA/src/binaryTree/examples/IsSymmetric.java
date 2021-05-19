package binaryTree.examples;

/**
 * Q) Given a BT, check if it is symmetric/mirror image or not
 * @author alok
 */

public class IsSymmetric {
	Tree root;

	public static void main(String[] args) {
		IsSymmetric bTree = new IsSymmetric();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.right.left = new Tree(4);
		bTree.root.right.left.right = new Tree(5);
		/**
		 * e.g 1) -> Not symmetric
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *       	  /
		 *           4
		 *            \
		 *             5 
		 *             
		 * e.g 2) -> Symmetric
		 * 			1
		 * 		  /   \
		 *       2     2
		 *      / \   / \
		 *     3         3
		 */
		
		boolean symmetric = isSymmetric(bTree.root.left, bTree.root.right);
		if(symmetric) {
			System.out.println("Symmetric");
		}
		else {
			System.out.println("Not symmetric");
		}
	}
	
	/**
	 * - Exactly similar to isIdentical()
	 * - we just need to compare leftNode of leftTree with rightNode of rightTree....similarly....rightNode of leftTree with leftNode of rightTree
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * 
	 * @param root1
	 * @param root2
	 * @return boolean
	 */
	public static boolean isSymmetric(Tree root1, Tree root2) {
		if(root1 == null && root2 == null) return true;
		else if(root1 != null && root2 != null) {
			return (root1 == root2 && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left));
		}
		else return false;
	}

}
