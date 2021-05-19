package binaryTree.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class VerticalOrderTraversal {
	Tree root;
	private static TreeMap<Integer, List<Integer>> orderedMap = new TreeMap<Integer, List<Integer>>();

	public static void main(String[] args) {
		VerticalOrderTraversal bTree = new VerticalOrderTraversal();
		
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
		verticalOrderTraversal(bTree.root, 0);
		printTreeMap(bTree.root); /**
								  *	-2 : [4]
									-1 : [2]
									 0 : [1, 5]
									 1 : [3]
									 2 : [6]
								  */
	}
	
	/**
	 * CRUX -> - initially for root node, value=0 is passed
	 * 		   - go left and reduce value-- then go right and increase value++
	 * 		   - at the same time, insert the node.value against the value key in TreeMap
	 * 		   - print the treeMap
	 * 
	 * - create a global TreeMap with key = Integer (slopeValue of every node) & value = list of integers (node.value for every slope)
	 * - check if a list is present against the slopeValue
	 * 		- if present...just insert the node.value in it
	 * 		- else...create a new list...and insert the node.value in it
	 * - now insert this list in the treeMap against the key=slopeValue
	 * - go node.left and decrement slopeValue by 1
	 * - then go node.right and increment slopeValue by 1
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * @param root
	 * @param value
	 */
	public static void verticalOrderTraversal(Tree root, int value) {
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
		
		verticalOrderTraversal(root.left, value-1);
		verticalOrderTraversal(root.right, value+1);
	}
	
	public static void printTreeMap(Tree root) {
		for(Map.Entry<Integer, List<Integer>> entry : orderedMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
