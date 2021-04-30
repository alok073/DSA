package linkedList.evenOdd;

/**
 * Q) Given a linkedList, print 2 separate linkedList containing even and odd elements
 * - i=0, if i is even
 * 		- addLast(evenList, value)
 * - else
 * 		- addLast(oddList, value)
 * - repeat this till you reach end of the original linkedList 
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
		LinkedList evenList = new LinkedList();
		LinkedList oddList = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		// 10 -> 20 -> 30 -> 40
		
		EvenOddList(list, evenList, oddList);
		
		System.out.println("Original List");
		printLinkedList(list);
		System.out.println("\nEven List");
		printLinkedList(evenList);
		System.out.println("\nOdd List");
		printLinkedList(oddList);
	}
	
	public static void EvenOddList(LinkedList list, LinkedList evenList, LinkedList oddList) {
		Node temp = list.head;
		Node tempEven = evenList.head;
		Node tempOdd = oddList.head;
		int i=0;
		while(temp != null) {
			if(i%2 == 0) {
				addLast(evenList, temp.data);
			}
			else {
				addLast(oddList, temp.data);
			}
			i++;
			temp = temp.next;
		}
	}
	
	public static void addLast(LinkedList tempList, int value) {
		if(tempList.head == null) {
			Node newNode = new Node(value);
			tempList.head = newNode;
		}
		else {
			Node temp = tempList.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			Node newNode = new Node(value);
			temp.next = newNode;
		}
	}
	
	public static void printLinkedList(LinkedList tempList) {
		Node temp = tempList.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
