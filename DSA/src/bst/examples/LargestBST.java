package bst.examples;

class BSTdetails {
	int min;
	int max;
	boolean isBST;
	int size;
	
	public BSTdetails() {
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
		this.isBST = true;
		this.size = 0;
	}
}

public class LargestBST {
	Tree root;

	public static void main(String[] args) {
		LargestBST bstTree = new LargestBST();
		
		bstTree.root = new Tree(50);
		bstTree.root.left = new Tree(30);
		bstTree.root.right = new Tree(60);
		bstTree.root.left.left = new Tree(5);
		bstTree.root.left.right = new Tree(20);
		bstTree.root.right.left = new Tree(45);
		bstTree.root.right.right = new Tree(70);
		bstTree.root.right.right.left = new Tree(65);
		bstTree.root.right.right.right = new Tree(80);
		/**
		 * 					50
		 * 				  /    \
		 *              30      60
		 *             /  \    /  \
		 *            5   20  45   70
		 *            			  /  \
		 *                      65    80	
		 */
		
		BSTdetails object = sizeOfLargestBST(bstTree.root); //5 {60,45,70,65,80}
		System.out.println(object.size);
	}
	
	public static BSTdetails sizeOfLargestBST(Tree root) {
		if(root == null) {
			return new BSTdetails();
		}
		
		//do postOrder traversal
		BSTdetails leftTree = sizeOfLargestBST(root.left);
		BSTdetails rightTree = sizeOfLargestBST(root.right);
		
		BSTdetails node = new BSTdetails();
		if(leftTree.isBST && rightTree.isBST && root.data >= leftTree.max && root.data < rightTree.min) {
			node.size = leftTree.size + rightTree.size + 1;
			node.min = root.left != null ? leftTree.min : root.data;
			node.max = root.right != null ? rightTree.max : root.data;
			return node;
		}
		
		node.size = Math.max(leftTree.size, rightTree.size);
		return node;
	}

}
