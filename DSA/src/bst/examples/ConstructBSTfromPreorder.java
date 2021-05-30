package bst.examples;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructBSTfromPreorder {
	static int index = 0;

	public static void main(String[] args) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>(
				Arrays.asList(10,5,1,7,40,50));
		
		//Tree root = constructBST(preOrder);
		Tree root = constructBSTlinearTime(preOrder,  Integer.MIN_VALUE, Integer.MAX_VALUE, preOrder.size());
		inOrder(root);
	}
	
	/**
	 * Time = O(n^2)
	 * Space = O(n)
	 * @param preOrder
	 * @return
	 */
	public static Tree constructBST(ArrayList<Integer> preOrder) {
		if(preOrder.isEmpty()) {
			return null;
		}
		Tree node = new Tree(preOrder.get(0)); 
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int i=1; i<preOrder.size(); i++) {
			if(preOrder.get(i) < node.data) {
				left.add(preOrder.get(i));
			}
			else {
				right.add(preOrder.get(i));
			}
		}
		
		node.left = constructBST(left);
		node.right = constructBST(right);
		
		return node;
	}
	
	/**
	 * Time = O(n)
	 * Space = O(n)
	 * @param preOrder
	 * @param min
	 * @param max
	 * @param size
	 * @return
	 */
	public static Tree constructBSTlinearTime(ArrayList<Integer> preOrder, int min, int max, int size) {
		if(index >= size) {
			return null;
		}
		if(preOrder.get(index) > min && preOrder.get(index) <= max) {
			Tree node = new Tree(preOrder.get(index));
			index++;
			if(index < size) {
				node.left = constructBSTlinearTime(preOrder, min, node.data, size);
				node.right = constructBSTlinearTime(preOrder, node.data+1, max, size);
			}
			return node;
		}
		else {
			return null;
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
