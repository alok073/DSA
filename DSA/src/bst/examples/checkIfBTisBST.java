package bst.examples;

public class checkIfBTisBST {
	Tree root;
	static Tree prev;

	public static void main(String[] args) {
		checkIfBTisBST bstTree = new checkIfBTisBST();
		
		bstTree.root = new Tree(30);
		bstTree.root.left = new Tree(20); 
		bstTree.root.right = new Tree(50);
		bstTree.root.left.left = new Tree(10);
		bstTree.root.left.right = new Tree(25);
		bstTree.root.right.left = new Tree(36);
		bstTree.root.right.right = new Tree(60);
		bstTree.root.right.right.left = new Tree(95);
		/**
		 * 			   30
		 * 			 /     \
		 * 		   20       50
		 *        /  \     /  \
		 *       10  25   36   60
		 *                    /
		 *                   95
		 */
		
		boolean isBST = checkIfBST(bstTree.root);
		System.out.println(isBST);
	}
	
	/**
	 * Approach 1
	 * - apply inOrder and store it in an array
	 * - traverse the array from index=1....if value[i] < value[i-1]....return false
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * Approach 2
	 * CRUX = -> similar to approach 1 but recursively
	 * 		  -> here too we will apply inOrder
	 * 		  -> In approach 1...we used to compare current node with previous node...if if prev>current we returned false
	 * 	  	  -> here also we will maintain a prev node which will be initialized with null
	 * - create a global Tree node prev = null
	 * - if node is null...return true
	 * - go left and if the boolean returned from left is false the return false
	 * - now check the prev condition....if prev is not null and prev > currentNode.....return false
	 * - make prev as currentNode
	 * - go right 
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 * @return
	 */
	public static boolean checkIfBST(Tree root) {
		if(root == null) {
			return true;
		}
		
		if(!checkIfBST(root.left)) {
			return false;
		}
		
		if(prev != null && prev.data > root.data) {
			return false;
		}
		prev = root;
		
		return checkIfBST(root.right);
		
	}

}
