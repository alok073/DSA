package binaryTree.examples;

/**
 * Print inOrder traversal recursively
 * @author alok
 */

class Tree {
	int data;
	Tree left;
	Tree right;
	
	public Tree(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}
}

public class InorderRecursive {
	Tree root;

	public static void main(String[] args) {
		InorderRecursive bTree = new InorderRecursive();
		
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
		
		inOrderRecursive(bTree.root); // 4 2 5 1 3
	}
	
	/**
	 * inOrder = leftChild -> root -> rightChild
	 * - Time - O(n)
	 * - Space = O(1)
	 * @param root
	 */
	public static void inOrderRecursive(Tree root) {
		if(root == null) {
			return;
		}
		
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}

}
