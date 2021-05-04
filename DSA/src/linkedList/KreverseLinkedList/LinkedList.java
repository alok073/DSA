package linkedList.KreverseLinkedList;

/**
 * Q)Reverse a linkedList from Kth node
 * - if Kth node is head
 * 		- apply normal reverseLinkedList method from head node
 * - else
 * 		- reach till (K-1)th node
 * 		- apply reverse from Kth node....and make the reverse function return the tempHead node
 * 		- make next of (K-1)th node as the node returned from reverse function
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
		list.head.next.next.next.next = new Node(50);
		// 10 -> 20 -> 30 -> 40 -> 50
		
		System.out.println("Before reversing");
		printLinkedList(list);
		Kreverse(list, 6);
		System.out.println("After reversing from Kth node");
		printLinkedList(list);
	}
	
	public static void Kreverse(LinkedList list, int k) {
		if(k == 1) {
			list.head = reverse(list.head);
		}
		else {
			int cnt = 1;
			Node temp = list.head;
			while(temp.next != null) {
				if(cnt+1 == k) {
					temp.next = reverse(temp.next);
					return;
				}
				cnt++;
				temp = temp.next;
			}
			System.out.println("\nK out of range");
		}
	}
	
	public static Node reverse(Node node) {
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
