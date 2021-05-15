package binaryTree.examples;

public class NumberOfNodes {
	Tree root;

	public static void main(String[] args) {
		NumberOfNodes bTree = new NumberOfNodes();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		bTree.root.right.right = new Tree(6);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \     \
		 *     4   5     6
		 */
		
		System.out.println(numberOfNodes(bTree.root)); //6
	}
	
	/**
	 * NumberOfNodes = NodesInLeftTree + NodesInRightTree + 1
	 * - Time = O(n)
	 *   Space = (1)
	 * @param root
	 * @return
	 */
	public static int numberOfNodes(Tree root) {
		if(root == null) {
			return 0;
		}
		return (numberOfNodes(root.left) + numberOfNodes(root.right) + 1);
	}

}
