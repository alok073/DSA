package linkedList.merge2SortedList;

/**
 * Merge 2 sorted list 
 * e.g: list1 = 1 -> 2 -> 4 ; list2 = 1 -> 3 -> 4
 *      O/P: 1 -> 1 -> 2 -> 3 -> 4 -> 4
 * - 3 list objects l1->list1, l2->list2, l->opList
 * - while numbers are present in both lists
 * 		- if num1<num2
 * 			- call insertLast(num1) and insert into opList
 * 			- increment node of l1
 * 		- else if num2<num1
 * 			- call insertLast(num2) and insert into opList
 * 			- increment node of l2
 * 		- else
 * 			- call insertLast(num1) and insert into opList
 * 			- call insertLast(num2) and insert into opList
 * 			- increment node of l1,l2
 * 		- //at this point either both list will be empty or 1 list will have some numbers
 * 		- //check which list has numbers and then insert them all into opList in same order
 * - time = O(sizeL1 + sizeL2)
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
		LinkedList list1 = new LinkedList();
		list1.head = new Node(1);
		list1.head.next = new Node(2);
		list1.head.next.next = new Node(4);
		// 1 -> 2 -> 4
		
		LinkedList list2 = new LinkedList();
		list2.head = new Node(1);
		list2.head.next = new Node(3);
		list2.head.next.next = new Node(4);
		// 1 -> 3 -> 4
		
		LinkedList list = new LinkedList();
		mergeTwoSortedList(list, list1, list2);
		printLinkedList(list);
	}
	
	public static void mergeTwoSortedList(LinkedList list, LinkedList list1, LinkedList list2) {
		Node temp1 = list1.head;
		Node temp2 = list2.head;
		while(temp1 != null && temp2 != null) {
			if(temp1.data < temp2.data) {
				insertLast(list, temp1.data);
				temp1 = temp1.next;
			}
			else if(temp1.data > temp2.data) {
				insertLast(list, temp2.data);
				temp2 = temp2.next;
			}
			else {
				insertLast(list, temp1.data);
				insertLast(list, temp2.data);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		
		while(temp1 != null) {
			insertLast(list, temp1.data);
			temp1 = temp1.next;
		}
		
		while(temp2 != null) {
			insertLast(list, temp2.data);
			temp2 = temp2.next;
		}
		
	}
	
	public static void insertLast(LinkedList list, int value) {
		Node temp = list.head;
		if(temp == null) {
			Node newNode = new Node(value);
			temp = newNode;
			list.head = newNode;
			return;
		}
		while(temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(value);
		temp.next = newNode;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
