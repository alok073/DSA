package binaryTree.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
	Tree root;
	private static TreeMap<Integer, List<Integer>> orderedMap = new TreeMap<Integer, List<Integer>>();

	public static void main(String[] args) {
		DiagonalTraversal bTree = new DiagonalTraversal();
		
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
		diagonalTraversal(bTree.root, 0);
		printTreeMap(bTree.root);/**
								  -2 : [4]
								  -1 : [2, 5]
								   0 : [1, 3, 6]
								 */
	}
	
	/**
	 * - Exactly similar to vertical order traversal
	 * - Only difference is when we go recursively to right node we used to increment the slopeValue in vertical traversal
	 * - But here we won't increment....we will pass the slope value as it is
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * @param root
	 * @param value
	 */
	public static void diagonalTraversal(Tree root, int value) {
		if(root == null) {
			return;
		}
		
		List<Integer> treeList = orderedMap.get(value);
		if(treeList == null) {
			treeList = new ArrayList<Integer>();
			treeList.add(root.data);
		}
		else {
			treeList.add(root.data);
		}
		orderedMap.put(value, treeList);
		
		diagonalTraversal(root.left, value-1);
		diagonalTraversal(root.right, value);
	}
	
	public static void printTreeMap(Tree root) {
		for(Map.Entry<Integer, List<Integer>> entry : orderedMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
