package binaryTree.examples;

import java.util.ArrayList;
import java.util.Arrays;

public class SerializeAndDeserializeBT {
	Tree root;
	static int index = 0;

	public static void main(String[] args) {
		SerializeAndDeserializeBT bTree = new SerializeAndDeserializeBT();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \
		 *     4   5
		 */
		StringBuilder str = new StringBuilder();
		serializeBT(bTree.root, str); //1,2,4,-1,-1,5,-1,-1,3,-1,-1,
		
		String serialize = str.toString();
		System.out.println(serialize);
		
		String[] serializedArray = serialize.split(",");
		
		Tree rootIndex = deserializeBT(serializedArray);
		inOrder(rootIndex);
		
	}
	
	/**
	 * Just a preOrder....when null append -1
	 * @param root
	 * @param str
	 * @return
	 */
	public static StringBuilder serializeBT(Tree root,StringBuilder str) {
		if(root == null) {
			str.append("-1,");
			return str;
		}
		
		str.append(root.data);
		str.append(",");
		serializeBT(root.left, str);
		serializeBT(root.right, str);
		
		return str;
	}
	
	/**
	 * construct a BT from a preOrder traversal with null nodes marked as "-1"
	 * @param array
	 * @return root
	 */
	public static Tree deserializeBT(String[] array) {
		if(index >= array.length) {
			return null;
		}
		if(array[index].equalsIgnoreCase("-1")) {
			index++;
			return null;
		}
		
		
		Tree node = new Tree(Integer.parseInt(array[index]));
		if(index < array.length) {
			index++;
			node.left = deserializeBT(array);
			node.right = deserializeBT(array);
		}
		return node;
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
