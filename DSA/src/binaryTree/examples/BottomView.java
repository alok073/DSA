package binaryTree.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {
	Tree root;
	private static TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();

	public static void main(String[] args) {
		BottomView bTree = new BottomView();
		
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
		
		bottomView(bTree.root); //4 2 5 3 6
	}
	
	/**
	 * - Print the last node of each slope value present in the treeMap after performing vertical OrderTraversal
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * @param root
	 */
	public static void bottomView(Tree root) {
		verticalOrderTraversal(root, 0);
		for(Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
			int lastElement = entry.getValue().size()-1;
			System.out.print(entry.getValue().get(lastElement) + " ");
		}
	}
	
	public static void verticalOrderTraversal(Tree root, int value) {
		if(root == null) {
			return;
		}
		
		List<Integer> treeList = treeMap.get(value);
		if(treeList == null) {
			treeList = new ArrayList<Integer>();
			treeList.add(root.data);
		}
		else {
			treeList.add(root.data);
		}
		treeMap.put(value, treeList);
		
		verticalOrderTraversal(root.left, value-1);
		verticalOrderTraversal(root.right, value+1);
	}

}
