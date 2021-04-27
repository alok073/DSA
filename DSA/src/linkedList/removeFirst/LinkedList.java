package linkedList.removeFirst;

/**
 * Q) Remove 1st node(head) of a linkedList
 * NOTE -> edge cases = check if head is present or not
 * - if head is present
 * 	- head = head.next 
 * @author alok
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

		System.out.println("Linked list before removing head");
		printLinkedList(list);
		
		removeFirst(list);
		
		System.out.println("\nLinked list after removing head");
		printLinkedList(list);
		
	}
	
	public static void removeFirst(LinkedList list) {
		if(list.head == null) {
			System.out.println("empty list");
		}
		else if(list.head != null) {
			list.head = list.head.next;
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
