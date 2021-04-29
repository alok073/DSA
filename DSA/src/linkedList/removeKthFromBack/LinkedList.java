package linkedList.removeKthFromBack;

/**
 * Q)Remove Kth node from back
 *- e.g = 1->2->3->4 ; k=2 i.e remove 2nd node from back
 *      o/p = 1->2->4
 * #METHOD 1
 *- find size of list
 *- index = size-k
 *- delete node at index position
 *NOTE -> edge case = node to be deleted is head node
 *- time = O(n) + O(n)
 *  space = O(1) 
 * -------------------------
 * #METHOD 2 
 *- make 2 node fast & slow....point them to head
 *- move the fast node forward K times
 *- now move both fast & slow node by 1 till fast.next==null or fast node becomes tail
 *- delete next node of slow node
 *NOTE -> edge case = node to be deleted is head node
 *- time = O(n)
 *  space = O(1) 
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
		// 10 -> 20 -> 30 -> 40
		
		System.out.println("Linked list before removing Kth node from back");
		printLinkedList(list);
		
		int size = sizeOfLinkedList(list);
		//removeKthNodeFromBack(list, size, 4);
		removeKthNodeFromBackUsingPointers(list, 3);
		
		System.out.println("\nLinked list after removing Kth node from back");
		printLinkedList(list);
	}
	
	public static void removeKthNodeFromBack(LinkedList list, int size, int k) {
		int index = size - k;
		Node temp = list.head;
		int i=0;
		if(index == 0) {
			list.head = temp.next;
			temp = temp.next;
			return;
		}
		while(temp != null && i<index) {
			if(i == index-1) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
			i++;
		}
	}
	
	public static void removeKthNodeFromBackUsingPointers(LinkedList list, int k) {
		Node slow = list.head;
		Node fast = list.head;
		for(int i=0; i<k; i++) {
			fast = fast.next;
		}
		if(fast == null) {
			//delete head node
			list.head = slow.next;
		}
		else {
			while(fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next;
		}
	}
	
	public static int sizeOfLinkedList(LinkedList list) {
		int size=0;
		Node temp = list.head;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

}
