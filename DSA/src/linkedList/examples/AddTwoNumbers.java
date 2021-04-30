package linkedList.examples;

/**
 * Q) Given 2 numbers(in reverse order) in 2 linkedList...add them and store it in another LL
 * e.g: num1 = 2->4->3 (original num1 = 342)
 *      num2 = 5->6->7->9 (original num2 = 9765)
 *    +   op = 7->0->1->0->1 (Actual op = 10107)  
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

public class AddTwoNumbers {
	Node head;

	public static void main(String[] args) {
		AddTwoNumbers number1 = new AddTwoNumbers();
		AddTwoNumbers number2 = new AddTwoNumbers();
		AddTwoNumbers addition = new AddTwoNumbers();
		
		number1.head = new Node(2);
		number1.head.next = new Node(4);
		number1.head.next.next = new Node(3);
		//2->4->3 (original num1 = 342)
		
		number2.head = new Node(5);
		number2.head.next = new Node(6);
		number2.head.next.next = new Node(7);
		number2.head.next.next.next = new Node(9);
		//5->6->7->9 (original num2 = 9765)
		
		System.out.println("Number 1");
		printLinkedList(number1);
		System.out.println("\nNumber 2");
		printLinkedList(number2);
		System.out.println("\nAddition");
		addTwoNumbers(number1, number2, addition);
		printLinkedList(addition);
	}
	
	public static void addTwoNumbers(AddTwoNumbers number1, AddTwoNumbers number2, AddTwoNumbers addition) {
		Node list1 = number1.head;
		Node list2 = number2.head;
		int carry = 0;
		while(list1 != null && list2 != null) {
			int value = (list1.data + list2.data + carry)%10;
			carry = (list1.data + list2.data + carry)/10;
			addLast(addition, value);
			list1 = list1.next;
			list2 = list2.next;
		}
		//check if any list as any elements
		while(list1 != null) {
			int value = (list1.data + carry)%10;
			carry = (list1.data + carry)/10;
			addLast(addition, value);
			list1 = list1.next;
		}
		while(list2 != null) {
			int value = (list2.data + carry)%10;
			carry = (list2.data + carry)/10;
			addLast(addition, value);
			list2 = list2.next;
		}
		//check if carry is still present
		if(carry > 0) {
			addLast(addition, carry);
		}
		//reverse the list
		reverseLinkedList(addition);
	}
	
	public static void addLast(AddTwoNumbers list, int value) {
		if(list.head == null) {
			list.head = new Node(value);
		}
		else {
			Node temp = list.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(value);
		}
	}
	
	public static void reverseLinkedList(AddTwoNumbers list) {
		Node prev = null;
		Node current = list.head;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			list.head = prev;
		}
	}
	
	public static void printLinkedList(AddTwoNumbers tempList) {
		Node temp = tempList.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
