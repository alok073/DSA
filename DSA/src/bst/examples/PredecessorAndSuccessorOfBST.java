package bst.examples;

public class PredecessorAndSuccessorOfBST {
	Tree root;
	static Tree predecessor;
	static Tree successor;

	public static void main(String[] args) {
		PredecessorAndSuccessorOfBST bstTree = new PredecessorAndSuccessorOfBST();
		
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
		
		predeecessorAndSuccessor(bstTree.root, 31);
		if(predecessor != null) {
			System.out.println("predecessor = " + predecessor.data);
		}
		else {
			System.out.println("no predecessor");
		}
		if(successor != null) {
			System.out.println("successor = " + successor.data);
		}
		else {
			System.out.println("no successor");
		}
	}
	
	/**
	 * - if target==root
	 * 		- //pre
	 * 		- (if left child of currentNode != null && left child has a right child) pre is rightmost child of the left child of currentNode
	 * 		- else pre is the left child
	 * 		- //successor
	 * 		- (if the right child of currentNode != null && right child has a left child) successor is the leftmost child of the right child of the currentNode
	 * 		- else successor is the right child
	 * 		- return
	 * - else if target < root
	 * 		- pre = root....go left
	 * - else
	 * 		- successor = root....go right
	 * 
	 * Time = O(h)
	 * Space = O(1)
	 * @param root
	 * @param target
	 */
	public static void predeecessorAndSuccessor(Tree root, int target) {
		if(root == null) {
			return;
		}
		
		if(target == root.data) {
			//for predecessor
			if(root.left != null) {
				Tree temp = root.left;
				while(temp.right != null) {
					temp = temp.right;
				}
				predecessor = temp;
			}
			//for successor
			if(root.right != null) {
				Tree temp = root.right;
				while(temp.left != null) {
					temp = temp.left;
				}
				successor = temp;
			}
			return;
		}
		else if(target < root.data) {
			successor = root;
			predeecessorAndSuccessor(root.left, target);
		}
		else {
			predecessor = root;
			predeecessorAndSuccessor(root.right, target);
		}

	}
}
