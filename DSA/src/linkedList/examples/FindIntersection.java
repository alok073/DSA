package linkedList.examples;

/**
 * Q) Given 2 LL find the intersecting node, if none then return null
 * -          l1 =  1 -> 2 -
 *                         |
 *                         -> 8 -> 7 -> 6 -> null
 *                         |
 *   l2 = 2 -> 8 -> 1 -> 3 -      
 *   intersecting node = 8
 *   NOTE = Intersecting node is a node with same address not same value
 *   - 2 dummy nodes pointing at head of either list
 *   - while either of them is not null:
 *       - if(temp1 == null) 
 *       	- make temp1 refer to head of list2
 *       - if(temp2 == null)
 *       	- make temp2 refer to head of list1
 *       - if(temp1 == temp2)
 *       	- return temp1
 *       - increment temp1 and temp2
 *   - return null   
 *   - Time = O(m+n)
 *     Space = O(1)
 * 
 * - Another of doing this is using HashMaps -> Time = O(m+n), space = O(n)
 * @author alok
 */

class Node1 {
	int data;
	Node1 next;
	
	public Node1(int value) {
		this.data= value;
		this.next = null;
	}
}

public class FindIntersection {
	Node1 head;

	public static void main(String[] args) {
		FindIntersection list1 = new FindIntersection();
		list1.head = new Node1(1);
		list1.head.next = new Node1(2);
		list1.head.next.next = new Node1(8);
		list1.head.next.next.next = new Node1(7);
		list1.head.next.next.next.next = new Node1(6);
		
		FindIntersection list2 = new FindIntersection();
		list2.head = new Node1(2);
		list2.head.next = new Node1(8);
		list2.head.next.next = new Node1(1);
		list2.head.next.next.next = new Node1(3);
		list1.head.next.next.next.next = list1.head.next.next;
		list1.head.next.next.next.next.next = list1.head.next.next.next;
		list1.head.next.next.next.next.next.next = list1.head.next.next.next.next;
		
		Node1 intersectionNode = findIntersection(list1, list2);
		if(intersectionNode == null) {
			System.out.println("No Intersection");
		}
		else {
			System.out.println(intersectionNode.data);
		}
	}
	
	public static Node1 findIntersection(FindIntersection list1, FindIntersection list2) {
		Node1 temp1 = list1.head;
		Node1 temp2 = list2.head;
		while(temp1 != null || temp2 != null) {
			if(temp1 == null) {
				temp1 = list2.head;
			}
			if(temp2 == null) {
				temp2 = list1.head;
			}
			if(temp1 == temp2) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return null;
	}

}
