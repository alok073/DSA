package linkedList.insertLast;

public class LinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		//constructor
		Node(int value) {
			data = value;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list = insertLast(list, 10);
		list = insertLast(list, 20);
		list = insertLast(list, 30);
		list = insertLast(list, 40);
		list = insertLast(list, 50);
		
		printLinkedList(list);
	}
	
	public static LinkedList insertLast(LinkedList list, int value) {
		//check if head is null
		if(list.head == null) {
			Node newNode = new Node(value);
			list.head = newNode;
		} else {
			//traverse until you get a null node
			Node tempNode = list.head;
			while(tempNode.next != null) {
				tempNode = tempNode.next;
			}
			
			//at the last node
			tempNode.next = new Node(value);
		}
		
		return list;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	

}
