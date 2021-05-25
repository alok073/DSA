package bst.examples;

public class FloorAndCeil {
	Tree root;
	static Tree floor;
	static Tree ceil;

	public static void main(String[] args) {
		FloorAndCeil bstTree = new FloorAndCeil();
		
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
		
		floorAndCeil(bstTree.root, 31);
		System.out.println("Floor = " + floor.data);
		System.out.println("Ceil = " + ceil.data);
	}
	
	/**
	 * CRUX = - exactly similar to predecessor & successor of BST
	 * 		  - only diff....when target == root....make floor and ceil as root and return
	 * 
	 * Time = O(h)
	 * Space = O(1)
	 * @param root
	 * @param target
	 */
	public static void floorAndCeil(Tree root, int target) {
		if(root == null) {
			return;
		}
		
		if(target == root.data) {
			floor = root;
			ceil = root;
			return;
		}
		else if(target < root.data) {
			ceil = root;
			floorAndCeil(root.left, target);
		}
		else {
			floor = root;
			floorAndCeil(root.right, target);
		}
	}

}
