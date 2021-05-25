package bst.examples;

public class KthSmallestAndLargest {
	Tree root;
	static int count = 0;

	public static void main(String[] args) {
		KthSmallestAndLargest bstTree = new KthSmallestAndLargest();
		
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
		
		kthSmallest(bstTree.root, 4); //30
		count = 0;
		KthLargest(bstTree.root, 2); //55
	}
	
	/**
	 * CRUX -> - exactly similar to inOrder traversal
	 * 		   - go left....when left SubTree is visited...increment the count, check if is equal to k..if yes print it....then go right
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 * @param k
	 */
	public static void kthSmallest(Tree root, int k) {
		if(root == null) {
			return;
		}
		
		kthSmallest(root.left, k);
		count++;
		if(count == k) {
			System.out.println("Kth smallest = " + root.data);
		}
		kthSmallest(root.right, k);
	}
	
	/**
	 * CRUX -> - exactly similar to reverse inOrder traversal
	 * 		   - go right....when right SubTree is visited...increment the count, check if is equal to k..if yes print it....then go left
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param root
	 * @param k
	 */
	public static void KthLargest(Tree root, int k) {
		if(root == null) {
			return;
		}
		
		KthLargest(root.right, k);
		count++;
		if(count == k) {
			System.out.println("Kth largest = " + root.data);
		}
		KthLargest(root.left, k);
	}
	
	

}
