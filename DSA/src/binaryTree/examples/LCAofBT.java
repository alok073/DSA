package binaryTree.examples;

public class LCAofBT {
	Tree root;

	public static void main(String[] args) {
		LCAofBT bTree = new LCAofBT();
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
		
		Tree lca = lcaOfBT(bTree.root, 2, 5); // 2
		if(lca != null) {
			System.out.println(lca.data);
		}
		else {
			System.out.println("No lca");
		}
	}
	
	/**
	 * LCA of 2 nodes = 1st common parent of the 2 nodes
	 * - traverse left then traverse right (inOrder)
	 * - if any node equals n1 or n2....return that node
	 * - if both left and right of a node is not null....then currentNode is the lca...return it
	 * - if both are null...return null
	 * - else return the node which is not null
	 * 
	 * Time = O(n)
	 * space = O(1)
	 * @param root
	 * @param n1
	 * @param n2
	 * @return Tree node
	 */
	public static Tree lcaOfBT(Tree root, int n1, int n2) {
		if(root == null) {
			return null;
		}
		
		if(root.data == n1 || root.data == n2) {
			return root;
		}
		
		Tree leftSubTree = lcaOfBT(root.left, n1, n2);
		Tree rightSubTree = lcaOfBT(root.right, n1, n2);
		
		if(leftSubTree != null && rightSubTree != null) {
			return root;
		}
		else if(leftSubTree == null && rightSubTree == null) {
			return null;
		}
		else if(leftSubTree != null && rightSubTree == null) {
			return leftSubTree;
		}
		else {
			return rightSubTree;
		}
	}

}
