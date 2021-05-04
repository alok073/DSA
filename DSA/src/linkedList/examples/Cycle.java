package linkedList.examples;

/**
 * Q) Find starting point of a cycle
 * @author alok
 */

class Node5 {
	int data;
	Node5 next;
	
	public Node5(int value) {
		this.data = value;
		this.next = null;
	}
}

public class Cycle {
	Node5 head;

	public static void main(String[] args) {
		Cycle list = new Cycle();
		
		list.head = new Node5(1);
		list.head.next = new Node5(2);
		list.head.next.next = new Node5(3);
		list.head.next.next.next = new Node5(4);
		list.head.next.next.next.next = new Node5(5);
		list.head.next.next.next.next.next = new Node5(6);
		list.head.next.next.next.next.next.next = list.head.next.next;
		
		Node5 startNode = findStartingPointOfCycle(list);
		if(startNode == null) {
			System.out.println("No cycle found");
		}
		else {
			System.out.println("The starting point of cycle is node with value = " + startNode.data);
		}
	}
	
	/**
	 * - exactly similar to detect cycle with small variation
	 * - when you find slow == fast then...make a dummy node referring to head node of LL
	 * - now until both dummy and slow node become equal keep on incrementing it
	 * - when they become equal...that node is your starting node of the cycle
	 * - Time = O(n)
	 *   Space = O(1)
	 * @param list
	 * @return Node5
	 */
	public static Node5 findStartingPointOfCycle(Cycle list) {
		Node5 slow = list.head;
		Node5 fast = list.head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				Node5 dummy = list.head;
				while(dummy != slow) {
					dummy = dummy.next;
					slow = slow.next;
				}
				return dummy;
			}
		}
		return null;
	}

}
