package linkedList.examples;

import java.util.HashMap;

class Node4 {
	int data;
	Node4 next;
	
	public Node4(int value) {
		this.data= value;
		this.next = null;
	}
}

public class DetectCycle {
	Node4 head;

	public static void main(String[] args) {
		DetectCycle list = new DetectCycle();
		
		list.head = new Node4(1);
		list.head.next = new Node4(2);
		list.head.next.next = new Node4(3);
		list.head.next.next.next = new Node4(4);
		list.head.next.next.next.next = new Node4(5);
		list.head.next.next.next.next.next = new Node4(6);
		list.head.next.next.next.next.next.next = list.head.next.next;
		
		//detectCycleUsingHashTable(list);
		detectCycleUsingPointers(list);
	}
	
	/**
	 * - create 2 nodes slow and fast referring to head in the beginning
	 * - increment slow by 1 and fast by 2
	 * - traverse through LL until fast is null or the last node
	 * - if at any time slow == fast then "Cycle detected" and return
	 * - els"No cycle"
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param list
	 */
	public static void detectCycleUsingPointers(DetectCycle list) {
		Node4 slow = list.head;
		Node4 fast = list.head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				System.out.println("Cycle detected");
				return;
			}
		}
		System.out.println("No cycle");
	}
	
	/**
	 * - create a hashMap with key as Node4 and value as int
	 * - traverse through the LL until currNode is null
	 * - insert nodes in the LL
	 * - check if the currNode is present in LL
	 * - If yes...."Cycle detected" else "No cycle"
	 * - Time = O(n)
	 *   Space = O(n)
	 * @param list
	 */
	public static void detectCycleUsingHashTable(DetectCycle list) {
		Node4 temp = list.head;
		HashMap<Node4, Integer> cycleHash = new HashMap<>();
		while(temp != null) {
			if(cycleHash.containsKey(temp)) {
				System.out.println("Cycle detected");
				return;
			}
			else {
				cycleHash.put(temp, temp.data);
			}
			temp = temp.next;
		}
		System.out.println("No cycle");
	}

}
