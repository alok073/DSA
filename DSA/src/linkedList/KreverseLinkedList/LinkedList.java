package linkedList.KreverseLinkedList;

/**
 * Q)Reverse a linkedList from Kth node
 * - pass the Kth node
 * - apply same logic as reverseLinkedList...ignore head node condition
 * - return prev node
 * - Time = O(n)
 * - Space = O(1)
 * @author alok
 *
 */

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

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		// 10 -> 20 -> 30 -> 40
		
		System.out.println("Before reversing");
		printLinkedList(list);
		list.head.next.next = KreverseLinkedList(list.head.next.next);
		System.out.println("\nAfter reversing from 3rd node");
		printLinkedList(list);
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
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
