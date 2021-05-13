package binaryTree.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IterativeTraversalTrick {
	Tree root;

	public static void main(String[] args) {
		IterativeTraversalTrick bTree = new IterativeTraversalTrick();
		
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
		
		//inOrderIterativeTrick(bTree.root); // 4 2 5 1 6 3 7
		//preOrderIterativeTrick(bTree.root); // 1 2 4 5 3 6 7
		//postOrderIterativeTrick(bTree.root); // 4 5 2 6 7 3 1
		
	}
	
	public static void inOrderIterativeTrick(Tree root) {
		Map<Tree, Integer> treeMap = new HashMap<Tree, Integer>();
		Stack<Tree> treeStack = new Stack<Tree>();
		Tree currentNode = root;
		treeStack.push(currentNode);
		
		while(!treeStack.isEmpty()) {
			currentNode = treeStack.peek();
			if(currentNode == null) {
				treeStack.pop();
				continue;
			}
			if(!treeMap.containsKey(currentNode)) {
				treeMap.put(currentNode, 0);
			}
			//check status
			int status = treeMap.get(currentNode);
			if(status == 0) { treeStack.push(currentNode.left); }
			else if(status == 1) { System.out.print(currentNode.data + " "); }
			else if(status == 2) { treeStack.push(currentNode.right); }
			else { treeStack.pop(); }
			
			treeMap.put(currentNode, status+1);
		}
	}
	
	
	public static void preOrderIterativeTrick(Tree root) {
		Map<Tree, Integer> treeMap = new HashMap<Tree, Integer>();
		Stack<Tree> treeStack = new Stack<Tree>();
		Tree currentNode = root;
		treeStack.push(currentNode);
		
		while(!treeStack.isEmpty()) {
			currentNode = treeStack.peek();
			if(currentNode == null) {
				treeStack.pop();
				continue;
			}
			if(!treeMap.containsKey(currentNode)) {
				treeMap.put(currentNode, 0);
			}
			//check status
			int status = treeMap.get(currentNode);
			if(status == 0) { System.out.print(currentNode.data + " "); }
			else if(status == 1) { treeStack.push(currentNode.left); }
			else if(status == 2) { treeStack.push(currentNode.right); }
			else { treeStack.pop(); }
			
			treeMap.put(currentNode, status+1);
		}
	}
	
	
	public static void postOrderIterativeTrick(Tree root) {
		Map<Tree, Integer> treeMap = new HashMap<Tree, Integer>();
		Stack<Tree> treeStack = new Stack<>();
		Tree currentNode = root;
		treeStack.push(currentNode);
		
		while(!treeStack.isEmpty()) {
			currentNode = treeStack.peek();
			if(currentNode == null) {
				treeStack.pop();
				continue;
			}
			if(!treeMap.containsKey(currentNode)) {
				treeMap.put(currentNode, 0);
			}
			//check status
			int status = treeMap.get(currentNode);
			if(status == 0) { treeStack.push(currentNode.left); }
			else if(status == 1) { treeStack.push(currentNode.right); }
			else if(status == 2) { System.out.print(currentNode.data + " "); }
			
			treeMap.put(currentNode, status+1);
		}
	}

}
