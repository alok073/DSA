package linkedList.examples;

class Node2 {
	int data;
	Node2 next;
	
	public Node2(int value) {
		this.data = value;
		this.next = null;
	}
}
public class KreverseGroup {
	Node2 head;

	public static void main(String[] args) {
		KreverseGroup list = new KreverseGroup();
		int k = 3;
		
		list.head = new Node2(1);
		list.head.next = new Node2(2);
		list.head.next.next = new Node2(3);
		list.head.next.next.next = new Node2(4);
		list.head.next.next.next.next = new Node2(5);
		list.head.next.next.next.next.next = new Node2(6);
		list.head.next.next.next.next.next.next = new Node2(7);
		list.head.next.next.next.next.next.next.next = new Node2(8);
		
		Node2 newHead = reverseKelements(list, k);
		printLinkedList(newHead);
	}
	
	public static Node2 reverseKelements(KreverseGroup list, int k) {
		Node2 dummy = new Node2(0);
		dummy.next = list.head;
		
		Node2 pre = dummy;
		Node2 current = dummy;
		Node2 nex = dummy;
		
		//calculate size of LinkedList
		int size = 0;
		while(current.next != null) {
			current = current.next;
			size++;
		}
		
		while(size >= k) {
			current = pre.next;
			nex = current.next;
			for(int i=1; i<k; i++) {
				current.next = nex.next;
				nex.next = pre.next;
				pre.next = nex;
				nex = current.next;
			}
			pre = current;
			size = size-k;
		}
		return dummy.next;
	}
	
	public static void printLinkedList(Node2 node) {
		Node2 temp = node;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
