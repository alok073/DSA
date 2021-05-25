package bst.examples;

class Tree {
	int data;
	Tree left;
	Tree right;
	
	public Tree(int value) {
		this.data= value;
		this.left = null;
		this.right = null;
	}
}

public class InsertNode {
	Tree root;

	public static void main(String[] args) {
		InsertNode bstTree = new InsertNode();
		
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
		
		insertNode(bstTree.root, 40);
		inOrder(bstTree.root); // 10 20 25 30 36 50 55 60
	}
	
	/**
	 * Time = O(h)
	 * Space = O(1)
	 * @param root
	 * @param key
	 */
	public static void insertNode(Tree root, int key) {
		if(root == null) {
			root = new Tree(key);
			return;
		}
		
		if(key < root.data) {
			if(root.left == null) {
				root.left = new Tree(key);
				return;
			}
			insertNode(root.left, key);
		}
		else {
			if(root.right == null) {
				root.right = new Tree(key);
				return;
			}
			insertNode(root.right, key);
		}
	}
	
	public static void inOrder(Tree root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

}
