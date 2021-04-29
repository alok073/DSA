package linkedList.checkPalindrome;

/**
 * Q) check if a linkedList is palindrome or not?
 * - Two methods
 * # METHOD 1
 * - push all linkedList elements to stack
 * - start comparing from headNode of LinkedList to peek elements of stack
 * - Time = O(n) + O(n)
 * - Space = O(n)
 * --------------------------
 * # METHOD 2
 * - Find midNode using tortoise method
 * - //Make sure to find 1st middleNode ; e.g: 1-2-3-4 the midNode=2 not 3
 * - reverse from midNode.next
 * - create a temp node at head and your currentNode will be at midNode.next
 * - compare till currentNode!=null....
 * - If all same -> Palindrome else Not a Palindrome
 * - Time = O(n)
 * - Space = O(1)
 */

import java.util.Stack;

class Node {
	int data;
	Node next;
	
	public Node(int value) {
		this.data= value;
		this.next = null;
	}
}

public class LinkedList {
	Node head;
	Stack<Integer> listStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(20);
		list.head.next.next.next.next = new Node(10);
		// 10 -> 20 -> 30 -> 20 -> 10
		
		/*
		 * linkedListToStack(list);
		 * if(checkPalindromeUsingStack(list)) { System.out.println("Palindrome"); }
		 * else { System.out.println("Not Palindrome"); }
		 */
		
		if(checkPalindromeInLinearSpace(list)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}
	
	public static void linkedListToStack(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			list.listStack.push(temp.data);
			temp = temp.next;
		}
	}
	
	public static boolean checkPalindromeUsingStack(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			int value = list.listStack.peek();
			if(temp.data != value) {
				return false;
			}
			temp = temp.next;
			list.listStack.pop();
		}
		return true;
	}
	
	public static boolean checkPalindromeInLinearSpace(LinkedList list) {
		//find mid node
		Node slow = list.head;
		Node fast = list.head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//reverse all nodes after midNode
		slow.next = KreverseLinkedList(slow.next);
		slow = slow.next;
		//create a dummy node pointing to head
		Node temp = list.head;
		while(slow != null) {
			if(temp.data != slow.data) {
				return false;
			}
			temp = temp.next;
			slow = slow.next;
		}
		return true;
	}
	
	public static Node KreverseLinkedList(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}
