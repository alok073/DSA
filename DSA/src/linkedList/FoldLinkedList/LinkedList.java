package linkedList.FoldLinkedList;

/**
 * Q)Given a linkedList, fold the LinkedList
 * e.g: 1->2->3->4 = 1->4->2->3
 *      1->2->3->4->5 = 1->5->2->4->3
 * - find midNode using slow and fast pointers (1st mid for even length LinkedList)
 * - reverse list after the slow node (apply kreverse)
 * - create a dummy node referring to head
 * - while slow node is not null
 * 		- addLast(dummy.data)
 * 		- addLast(slow.data)
 * 		- increment dummy and slow forward by 1
 * NOTE -> edge case = for odd length LinkedList you need to separately print the mid Node after the above steps
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
		LinkedList foldList = new LinkedList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		// 10 -> 20 -> 30 -> 40 -> 50
		
		System.out.println("LinkedList before fold");
		printLinkedList(list);
		
		Fold(list, foldList);
		System.out.println("\nLinkedList after fold");
		printLinkedList(foldList);
		
	}
	
	public static void Fold(LinkedList list, LinkedList foldList) {
		Node slow = list.head;
		Node fast = list.head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//reverse all elements right of slow node
		slow.next = kreverse(slow.next);
		//store the mid node...will be used to verify if midNode is printed or not in case of odd length LinkedList
		Node midNode = slow;
		slow = slow.next;
		//create a dummy node referring to head
		Node temp = list.head;
		while(slow != null) {
			addLast(foldList, temp.data);
			addLast(foldList, slow.data);
			temp = temp.next;
			slow = slow.next;
		}
		//print midNode if odd length LinkedList
		if(temp == midNode) {
			addLast(foldList, temp.data);
		}
	}
	
	public static Node kreverse(Node node) {
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
