package binaryTree.examples;

/**
 * Q) Print inOrder of a binary tree iteratively
 */

import java.util.Stack;

public class InOrderIterative {
	Tree root;

	public static void main(String[] args) {
		InOrderIterative bTree = new InOrderIterative();
		
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
		
		inOrderIterative(bTree.root); // 4 2 5 1 3
	}
	
	/**
	 * InOrder = left -> root -> right
	 * - current = root
	 * - while stack is not empty OR current is not null
	 * 		- traverse to the left until NULL and push current to stack
	 * 		- if null
	 * 			- print the top of stack
	 * 			- make current as top.right
	 * Time = O(n)
	 * Space = O(n)
	 * @param root
	 */
	public static void inOrderIterative(Tree root) {
		Tree currentNode = root;
		Stack<Tree> treeStack = new Stack<>();
		
		while(currentNode != null || !treeStack.isEmpty()) {
			while(currentNode != null) {
				treeStack.push(currentNode);
				currentNode = currentNode.left;
			}
			
			//If currentNode is null
			currentNode = treeStack.pop();
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.right;
		}
	}

}
