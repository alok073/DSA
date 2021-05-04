package linkedList.examples;

class Node6 {
	int data;
	Node6 next;
	
	public Node6(int value) {
		this.data = value;
		this.next = null;
	}
}

public class Rotate {
	Node6 head;

	public static void main(String[] args) {
		Rotate list = new Rotate();
		
		list.head = new Node6(1);
		list.head.next = new Node6(2);
		list.head.next.next = new Node6(3);
		list.head.next.next.next = new Node6(4);
		list.head.next.next.next.next = new Node6(5);
		
		System.out.println("Original linked list");
		printLinkedList(list);
		rotateKtimes(list, 12);
		System.out.println("\nAfter rotating K times to right");
		printLinkedList(list);
	}
	
	/**
	 * - find size of LL anf=d make LL as a circular LL i.e lastNode.next = head
	 * - calculate k%size
	 * - go upto (size-k) node
	 * - make the next node as head and current node.next as null
	 * @param list
	 * @param k
	 */
	public static void rotateKtimes(Rotate list, int k) {
		int size = sizeOfLinkedList(list);
		int rotation = k%size;
		int lastNodePos = size - rotation;
		int i=1;
		Node6 temp = list.head;
		while(i < lastNodePos) {
			temp = temp.next;
			i++;
		}
		list.head = temp.next;
		temp.next = null;
	}
	
	public static int sizeOfLinkedList(Rotate list) {
		Node6 temp = list.head;
		int size = 0;
		while(temp.next != null) {
			size++;
			temp = temp.next;
		}
		size++;
		temp.next = list.head;
		return size;
	}
	
	public static void printLinkedList(Rotate list) {
		Node6 temp = list.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
