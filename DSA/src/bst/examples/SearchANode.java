package bst.examples;

public class SearchANode {
	Tree root;

	public static void main(String[] args) {
		SearchANode bstTree = new SearchANode();
		
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
		
		boolean found = searchInBST(bstTree.root, 41);
		if(found) {
			System.out.println("key found");
		}
		else {
			System.out.println("key not found");
		}
	}
	
	/**
	 * Time = O(h) 
	 * Space = O(1)
	 * @param root
	 * @param key
	 * @return
	 */
	public static boolean searchInBST(Tree root, int key)
	{
		if(root == null) {
			return false;
		}
		
		if(root.data == key) {
			return true;
		}
		else if(key < root.data) {
			return searchInBST(root.left, key);
		}
		else {
			return searchInBST(root.right, key);
		}
	}

}
