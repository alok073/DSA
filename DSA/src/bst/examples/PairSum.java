package bst.examples;

import java.util.Stack;

public class PairSum {
	Tree root;

	public static void main(String[] args) {
		PairSum bstTree = new PairSum();
		
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
		
		boolean present = pairSum(bstTree.root, 56);
		System.out.println(present);
	}
	
	/**
	 * Q) find 2 nodes in a BST whose addition == targetSum
	 * - make 2 stacks
	 * - push all the nodes in stack1 which are on the left of root until u reach null
	 * - push all the nodes in stack2 which are on the right of the root until u reach null
	 * - now the top of stack1 is the smallest value and the top of the stack2 is the largest value
	 * - //just like an array stored in a sorted manner...top of stack1 is element at index 0 and top of stack 2 is last element of array
	 * - //now use 2 pointer technique
	 * - do the foll. steps until peek of both the stacks is same (root node)
	 * 		- if top of stack1 + stack2 == sum...pair found ... return true
	 * 		- if less than sum... (then in 2-pointer on an array we move the left pointer forward) so push all the nodes which come in the path from peek of stack1 
	 * 		  to it's successor into stack1
	 * 		- if greater than sum... (then in 2-pointer on an array we move the right pointer backward) so push all the nodes which come in the path from peek of stack2 
	 * 		  to it's predecessor into stack1
	 * - if nothing....return false
	 * 
	 * Time = O(n)
	 * Space = O(h)
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean pairSum(Tree root, int sum) {
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		
		Tree temp = root;
		while(temp != null) {
			stack1.push(temp);
			temp = temp.left;
		}
		temp = root;
		while(temp != null) {
			stack2.push(temp);
			temp = temp.right;
		}
		
		while(stack1.peek() != stack2.peek()) {
			int value1 = stack1.peek().data;
			int value2 = stack2.peek().data;
			if(value1 + value2 == sum) {
				System.out.println(value1 + " " + value2);
				return true;
			}
			else if(value1 + value2 < sum) {
				// push all the nodes in the path from value1 to it's successor
				temp = stack1.pop();
				if(temp.right != null) {
					temp = temp.right;
					while(temp != null) {
						stack1.push(temp);
						temp = temp.left;
					}
				}
//				temp = stack1.peek().right;
//				stack1.pop();
//				while(temp != null) {
//					stack1.push(temp);
//					temp = temp.left;
//				}
			}
			else {
				// push all the nodes in the path from value2 to it's predecessor
				temp = stack2.pop();
				if(temp.left != null) {
					temp = temp.left;
					while(temp != null) {
						stack2.push(temp);
						temp = temp.right;
					}
				}
//				temp = stack2.peek().left;
//				stack2.pop();
//				while(temp != null) {
//					stack2.push(temp);
//					temp = temp.right;
//				}
			}
		}
		return false;
	}

}
