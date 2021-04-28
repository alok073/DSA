package linkedList.midNode;

/**
 * Q)Find mid node of a linkedList
 * -> what is midNode -> if size(linkedList)=odd then midNode=size/2 +1 -> [1,2,3] then mid=2
 * 					  -> if size(linkedList)=even then midNode=size/2 +1 -> [1,2,3,4] then mid=3
 * - Two ways
 * 1. using size of linkedList
 * - find size of linkedList (O(n))
 * - calculate mid
 * - traverse till mid and return node (O(n/2))
 * - O(n) + O(n/2)
 * 
 * 2. Tortoise method
 * - 2 pointers, slow and fast
 * - both assigned with head node
 * - increment slow by 1 and fast by 2 until fast reaches end node or null
 * - at that point slow is your mid node
 * - O(n/2)
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
		
		Node midNode = midOfLinkedList(list);
		System.out.println("Value of midNode is = " + midNode.data);
	}
	
	public static Node midOfLinkedList(LinkedList list) {
		Node slow = list.head;
		Node fast = list.head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
