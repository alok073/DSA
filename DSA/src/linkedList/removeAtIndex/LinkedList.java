package linkedList.removeAtIndex;

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
		
		System.out.println("Linked list before removing element at index K");
		printLinkedList(list);
		
		removeAtIndex(list, 1);
		
		System.out.println("\nLinked list after removing element at index K");
		printLinkedList(list);
	}
	
	public static void removeAtIndex(LinkedList list, int k) {
		if(k<1) {
			System.out.println("invalid index");
		}
		else if(k == 1) {
			Node tempNext = list.head.next;
			list.head.next = null;
			list.head = tempNext;
		}
		else {
			int cnt=1;
			Node temp = list.head;
			while(temp.next != null) {
				if(cnt+1 == k) {
					temp.next = temp.next.next;
					return;
				}
				cnt++;
				temp = temp.next;
			}
			System.out.println("Index out of range");
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
