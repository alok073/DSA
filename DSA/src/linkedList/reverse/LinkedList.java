package linkedList.reverse;

/**
 * Q) Reverse a LinkedList
 * e.g = 1 -> 2 -> NULL ==> 2 -> 1 -> NULL
 * NOTE -> Edge cases = no nodes, 1 node
 * - create 3 nodes; prev=NULL, curr=head, next=NULL
 * - follow below steps until curr!=NULL
 * 		- next = curr.next
 *  	- curr.next = prev
 *  	- prev = curr
 *  	- curr = next
 * @author alok
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
		
		System.out.println("Linked list before reversal");
		printLinkedList(list);
		
		reverseLinkedList(list);
		
		System.out.println("\nLinked list after reversal");
		printLinkedList(list);
	}
	
	public static void reverseLinkedList(LinkedList list) {
		Node prev = null;
		Node current = list.head;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

}
