package binaryTree.examples;

import java.util.Stack;

public class PostOrderIterative {
	Tree root;

	public static void main(String[] args) {
		PostOrderIterative bTree = new PostOrderIterative();
		
		bTree.root = new Tree(1);
		bTree.root.left = new Tree(2);
		bTree.root.right = new Tree(3);
		bTree.root.left.left = new Tree(4);
		bTree.root.left.right = new Tree(5);
		bTree.root.right.left = new Tree(6);
		bTree.root.right.right = new Tree(7);
		/**
		 * 			1
		 * 		  /	  \
		 *       2     3
		 *      / \   / \ 
		 *     4   5 6   7
		 */
		
		postOrderIterative(bTree.root); // 4 5 2 6 7 3 1
	}
	
	/**
	 * Using 2 stacks
	 * - push root in stack1
	 * - iterate till stack1 is not empty
	 * 		- pop stack1 and push in stack2
	 * 		- push the left & right child of popped node in stack1
	 * - print stack2
	 * - Time = O(n)
	 *   Space = O(n)
	 * @param root
	 */
	public static void postOrderIterative(Tree root) {
		Stack<Tree> treeStack1 = new Stack<>();
		Stack<Tree> treeStack2 = new Stack<>();
		Tree currentNode = root;
		treeStack1.push(currentNode);
		
		while(!treeStack1.isEmpty()) {
			currentNode = treeStack1.pop();
			treeStack2.push(currentNode);
			if(currentNode.left != null) {
				treeStack1.push(currentNode.left);
			}
			if(currentNode.right != null) {
				treeStack1.push(currentNode.right);
			}
		}
		printStack(treeStack2);
	}
	
	public static void printStack(Stack<Tree> stack) {
		while(!stack.isEmpty()) {
			Tree node = stack.pop();
			System.out.print(node.data + " ");
		}
	}

}
