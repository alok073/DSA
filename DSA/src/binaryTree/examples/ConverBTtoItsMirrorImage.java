package binaryTree.examples;

public class ConverBTtoItsMirrorImage {
	Tree root;

	public static void main(String[] args) {
		ConverBTtoItsMirrorImage bTree = new ConverBTtoItsMirrorImage();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.right.left = new Tree(4);
		bTree.root.right.left.right = new Tree(5);
		/**
		 * Original Tree
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *       	  /
		 *           4
		 *            \
		 *             5 
		 *             
		 * Mirror Tree
		 * 			1
		 * 		  /   \
		 *       3     2	
		 *        \
		 *         4
		 *        /
		 *       5  
		 */
		
		convertToMirror(bTree.root);
		// can verify using any traversal techniques
	}
	
	/**
	 * - Go to the left subTree then the right subTree
	 * - swap the left and the right nodes
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 */
	public static void convertToMirror(Tree root) {
		if(root == null) {
			return;
		}
		
		convertToMirror(root.left);
		convertToMirror(root.right);
		
		//swap left and right nodes
		Tree temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
