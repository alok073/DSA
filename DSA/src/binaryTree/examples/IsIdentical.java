package binaryTree.examples;

/**
 * Q) Given root nodes of 2 BT check if they are identical or not.
 * @author alok
 */

public class IsIdentical {
	Tree root;

	public static void main(String[] args) {
		IsIdentical bTree1 = new IsIdentical();
		bTree1.root = new Tree(1);
		bTree1.root.left = new Tree(2);
		bTree1.root.right = new Tree(3);
		bTree1.root.left.left = new Tree(4);
		bTree1.root.left.right = new Tree(5);
		bTree1.root.right.right = new Tree(6);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \     \
		 *     4   5     6
		 */
		
		IsIdentical bTree2 = new IsIdentical();
		bTree2.root = new Tree(1);
		bTree2.root.left = new Tree(2);
		bTree2.root.right = new Tree(3);
		bTree2.root.left.left = new Tree(4);
		bTree2.root.left.right = new Tree(5);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \     
		 *     4   5     
		 */
		
		boolean identical = isIdentical(bTree1.root, bTree2.root); //not identical
		if(identical) {
			System.out.println("Identical");
		}
		else {
			System.out.println("Not Identical");
		}
	}
	
	/**
	 * Identical trees = structure of both the trees and the node values should be be same
	 * CRUX = if leftSubTree is identical && rightSubTree is identical && current root values are not null and same then both trees are identical....else not identical
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean isIdentical(Tree root1, Tree root2) {
		if(root1 == null && root2 == null) return true;
		else if(root1 != null && root2 != null) {
			return (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
		}
		else return false;
	}		
}

