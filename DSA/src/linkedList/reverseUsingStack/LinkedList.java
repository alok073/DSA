package linkedList.reverseUsingStack;

/**
 * Q)Reverse a linkedList using stack
 * - insert all elements of linkedList to a stack
 * - while stack is not empty
 * 		- get the top value
 *  	- insert it to the current node of linkedList, go to next node
 *  	- NOTE = no need to change the structure of linkedList just change the values
 *  	- pop
 */

import java.util.Stack;

class Node {
	int data;
	Node next;
	
	public Node(int value) {
		this.data = value;
		this.next = null;
	}
}

public class LinkedList {
	Node head;
	Stack<Integer> reverseStack = new Stack<Integer>();

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		// 10 -> 20 -> 30 -> 40
		LinkedListToStack(list);
		System.out.println("stack = " + list.reverseStack);
		
		System.out.println("Linked list before reversal");
		printLinkedList(list);
		
		reverseLinkedList(list);
		
		System.out.println("\nLinked list after reversal");
		printLinkedList(list);
	}
	
	public static void LinkedListToStack(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			list.reverseStack.push(temp.data);
			temp = temp.next;
		}
	}
	
	public static void reverseLinkedList(LinkedList list) {
		Node temp = list.head;
		while(!list.reverseStack.isEmpty()) {
			int value = list.reverseStack.peek();
			if(temp != null) {
				temp.data = value;
				temp = temp.next;
			}
			list.reverseStack.pop();
		}
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

}
