package bst.examples;

public class LCAofBST {
	Tree root;

	public static void main(String[] args) {
		LCAofBST bstTree = new LCAofBST();
		
		bstTree.root = new Tree(30);
		bstTree.root.left = new Tree(20); 
		bstTree.root.right = new Tree(50);
		bstTree.root.left.left = new Tree(10);
		bstTree.root.left.right = new Tree(25);
		bstTree.root.right.left = new Tree(36);
		bstTree.root.right.right = new Tree(60);
		bstTree.root.right.right.left = new Tree(55);
		/**
		 * 			   30
		 * 			 /     \
		 * 		   20       50
		 *        /  \     /  \
		 *       10  25   36   60
		 *                    /
		 *                   55
		 */
		
		Tree lca = lcaOfBST(bstTree.root, 10, 25);
		if(lca != null) {
			System.out.println(lca.data);
		}
		else {
			System.out.println("lca not present");
		}
	}
	
	/**
	 * LCA = 1st common parent of both the node
	 * 		 OR
	 * 		 It the intersection node of root->node path of both the nodes
	 * - if both the values are smaller than the root...go left
	 * - else if both values are greater than root....go right
	 * - else ....return root
	 * 
	 * Time = O(h)
	 * Space = O(1)
	 * @param root
	 * @param n1
	 * @param n2
	 * @return Tree node
	 */
	public static Tree lcaOfBST(Tree root, int n1, int n2) {
		if(root == null) {
			return null;
		}
		
		if(n1 < root.data && n2 < root.data) {
			return lcaOfBST(root.left, n1, n2);
		}
		else if(n1 > root.data && n2 > root.data) {
			return lcaOfBST(root.right, n1, n2);
		}
		else {
			return root;
		}
	}

}
