package binaryTree.examples;

/**
 * Print postOrder traversal recursively
 * @author alok
 *
 */

public class PostOrderRecursive {
	Tree root;

	public static void main(String[] args) {
		PostOrderRecursive bTree = new PostOrderRecursive();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \
		 *     4   5
		 */
		
		postOrderRecursive(bTree.root); // 4 5 2 3 1
	}
	
	/**
	 * postOrder = root.left -> root.right -> root
	 * - Time = O(n)
	 *   space = O(1)
	 * @param root
	 */
	public static void postOrderRecursive(Tree root) {
		if(root == null) {
			return;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

}
