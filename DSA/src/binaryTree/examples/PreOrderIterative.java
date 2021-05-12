package binaryTree.examples;

/**
 * Print preOrder Iteratively
 */

import java.util.Stack;

public class PreOrderIterative {
	Tree root;

	public static void main(String[] args) {
		PreOrderIterative bTree = new PreOrderIterative();
		
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
		
		preOrderIterative(bTree.root); //1 2 4 5 3
	}
	
	/**
	 * @param root
	 * PreOrder = root -> left -> right
	 * - current = root
	 * - while current != null OR stack != empty
	 * 		- while current != null....print current, push right to stack and go left
	 * 		- if current is null...make current as top of stack
	 * - Time = O(n)
	 *   Space = O(h) //h=height of tree
	 */
	public static void preOrderIterative(Tree root) {
		Tree currenNode = root;
		Stack<Tree> treeStack = new Stack<>();
		
		while(currenNode != null || !treeStack.isEmpty()) {
			while(currenNode != null) {
				System.out.print(currenNode.data + " ");
				treeStack.push(currenNode.right);
				currenNode = currenNode.left;
			}
			
			//if currentNode is null
			if(!treeStack.isEmpty()) {
				currenNode = treeStack.pop();
			}
		}
	}

}
