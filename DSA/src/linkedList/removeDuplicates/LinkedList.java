package linkedList.removeDuplicates;

/**
 * Q)Remove duplicates from a sorted LinkedList
 * - e.g: 1 -> 2 -> 2 -> 4 -> 4
 *   O/P: 1 -> 2 -> 4
 * - while current & next node != null:
 * 		- if value of current & next is equal
 * 			- remove next node
 * 		- increment node
 *  NOTE -> edge case = last 2 elements are same
 *  - Time = O(n)
 *  - Space = O(1)   
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
		
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(4);
		// 1 -> 2 -> 2 -> 4 -> 4
		
		removeDuplicates(list);
		printLinkedList(list);
	}
	
	public static void removeDuplicates(LinkedList list) {
		Node temp = list.head;
		while(temp != null && temp.next != null) {
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
