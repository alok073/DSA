package linkedList.insertFirst;

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
		
		list = insertFirst(list, 10);
		list = insertFirst(list, 20);
		list = insertFirst(list, 30);
		list = insertFirst(list, 40);
		list = insertFirst(list, 50);
		
		printLinkedList(list);
	}
	
	public static LinkedList insertFirst(LinkedList list, int value) {
		Node newNode = new Node(value);
		
		if(list.head == null) {
			list.head = newNode;
		}
		else {
			newNode.next = list.head;
			list.head = newNode;
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
