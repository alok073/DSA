package linkedList.removeFirst;

/**
 * Q) Remove 1st node(head) of a linkedList
 * NOTE -> edge cases = check if head is present or not
 * - if head is present
 * 	- get the nxt element of head in a temp node
 * 	- make next of head as null
 * 	- make head as the temp node
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
		if(list.head != null) {
			Node temp = list.head.next;
			list.head.next = null;
			list.head = temp;
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
