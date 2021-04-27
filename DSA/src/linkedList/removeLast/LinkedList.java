package linkedList.removeLast;

/**
 * Q) remove last node(tail) of a Linked list 
 * NOTE -> edge case = no node, only 1 node
 * - if no node -> "empty list"
 * - if only 1 node -> head = null
 * - else 
 * 	  - traverse till currentNode.next.next != null
 *    - make currentNode.next = null
 * @author alok
 *
 */

class Node {
	int data;
	Node next;
	
	public Node(int value) {
		data = value;
		next = null;
	}
}

public class LinkedList {
	Node head;
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		// 10 -> 20 -> 30 -> 40
		
		System.out.println("Linked list before removing tail");
		printLinkedList(list);
		
		removeLast(list);
		
		System.out.println("\nLinked list after removing tail");
		printLinkedList(list);
	}
	
	public static void removeLast(LinkedList list) {
		Node temp = list.head;
		if(temp == null) {
			System.out.println("empty list");
		}
		else if(temp.next == null) {
			list.head = null;
		}
		else {
			while(temp.next.next != null) {
				temp = temp.next;
			}
		}
		temp.next = null;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

}
