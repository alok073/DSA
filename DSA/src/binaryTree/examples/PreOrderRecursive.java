package binaryTree.examples;

/**
 * Print preOrder traversal recursively
 * @author alok
 *
 */

/*class Tree {
	int data;
	Tree left;
	Tree right;
	
	public Tree(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}
}*/

public class PreOrderRecursive {
	Tree root;
	
	public static void main(String[] args) {
		PreOrderRecursive bTree = new PreOrderRecursive();
		
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
		
		preOrderRecursive(bTree.root); // 1 2 4 5 3
	}
	
	/**
	 * preOrder = root -> root.left -> root->right
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param root
	 */
	public static void preOrderRecursive(Tree root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

}
