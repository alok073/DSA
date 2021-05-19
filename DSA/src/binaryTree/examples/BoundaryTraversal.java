package binaryTree.examples;

public class BoundaryTraversal {
	Tree root;

	public static void main(String[] args) {
		BoundaryTraversal bTree = new BoundaryTraversal();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.left.right = new Tree(3); 
		bTree.root.left.right.left = new Tree(4);
		bTree.root.left.right.left.right = new Tree(5);
		bTree.root.left.right.left.right.left = new Tree(6);
		bTree.root.right = new Tree(7);
		bTree.root.right.left = new Tree(8);
		bTree.root.right.right = new Tree(9);
		bTree.root.right.left.right = new Tree(10);
		/**
		 * 					1
		 * 				 /     \
		 * 				2       7
		 * 				 \     / \
		 * 				  3   8   9
		 *               /     \
		 *              4       10
		 *               \ 
		 *                5
		 *               / 
		 *              6   
		 * 
		 */
		
		boundaryTraversal(bTree.root); // 1 2 3 4 5 6 10 9 7
	}
	
	/**
	 * Boundary traversal = traverse the BT in anti-clockwise manner from the root node
	 * - print the leftmost nodes of the leftSubtree of root...except the leaves
	 * - print all the leaves
	 * - print the rightmost nodes of the rightSubTree of root from bottom to up.....except the leaves
	 * @param root
	 */
	public static void boundaryTraversal(Tree root) {
		printLeftNodesOfLeftTree(root); // 1 2 3 4 5
		printLeaves(root); // 6 10 9
		printRightNodesOfRightTree(root.right); // 7
	}
	
	public static void printLeftNodesOfLeftTree(Tree root) {
		if(root == null) {
			return;
		}
		
		if(root.left != null) {
			System.out.print(root.data + " ");
			printLeftNodesOfLeftTree(root.left);
		}
		else if(root.right != null) {
			System.out.print(root.data + " ");
			printLeftNodesOfLeftTree(root.right);
		}
	}
	
	public static void printLeaves(Tree root) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	public static void printRightNodesOfRightTree(Tree root) {
		if(root == null) {
			return;
		}
		
		if(root.right != null) {
			printRightNodesOfRightTree(root.right);
			System.out.print(root.data + " ");
		}
		else if(root.left != null) {
			printRightNodesOfRightTree(root.left);
			System.out.print(root.data + " ");
		}
	}

}
