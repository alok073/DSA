package linkedList.insertAtIndex;
/**
 * Insert a node at position K in a linked list
 * NOTE -> edge cases = head, k > linked list size
 * - if(k<0) "invalid"
 * - else if(k==0) 
 * 		- head node
 *  - else
 *  	- traverse till K-1 node
 *  	- If K-1 node != null....insert after K-1 node
 *  	- If null...invalid
 * @author alok
 */

public class LinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int value) {
			data = value;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		// 10 -> 20 -> 30 -> 40
		
		System.out.println("Linked list before insertion");
		printLinkedList(list);
		
		insertAt(list, 6, 50);
		
		System.out.println("\nLinked list after insertion");
		printLinkedList(list);
	}
	
	public static void insertAt(LinkedList list, int k, int value) {
		if(k < 0) {
			System.out.println("invalid");
		}
		else if(k == 0) {
			Node newNode = new Node(value);
			newNode.next = list.head;
			list.head = newNode;
		} 
		else {
			int i = 0;
			Node temp = list.head;
			while(i < k) {
				if(temp!= null && i+1 == k) {
					Node newNode = new Node(value);
					newNode.next = temp.next;
					temp.next = newNode;
					break;
				}
				else if(temp == null) {
					System.out.println("index value out of range");
					break;
				}
				temp = temp.next;
				i++;
			}
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
