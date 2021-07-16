package heaps;

import java.util.PriorityQueue;

/**
 * Q9) Given an array where each element is a rope of length A[i], find min cost to connect all the ropes into a single rope
 * i/p: {1,2,3,4,5}
 * o/p: 33
 * 
 * Explanation:-
 * - initially, {1,2,3,4,5}
 * - 1+2 = 3....{3,3,4,5}
 * - 3+3 = 6....{6,4,5}
 * - 4+5 = 9....{6,9}
 * - 6+9 = 15
 * Hence,
 * ropeLength = 15
 * minCost = 3+6+9+15 = 33
 * 
 * @author alok
 *
 */

public class ConnectRopes {

	public static void main(String[] args) {
		int array[] = new int[] {1,2,3,4,5};
		
		int minCostToConnectRopes = minimizeCost(array);
		System.out.println("Minimum cost to connect ropes = " + minCostToConnectRopes);
	}
	
	/**
	 * - push all elements of array to minHeap
	 * - pop 1st 2 elements...add it...insert this newRope into minHeap...add this newRope to cost
	 * - return cost
	 * 
	 * Time = O(n * log n)
	 * Space = O(n)
	 * 
	 * @param array
	 * @return
	 */
	public static int minimizeCost(int[] array) {
		int cost = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0;i<array.length;i++) {
			minHeap.add(array[i]);
		}
		
		int first, second, newRope;
		while(minHeap.size() >= 2) {
			first = minHeap.poll();
			second = minHeap.poll();
			newRope = first + second;
			cost = cost + newRope;
			minHeap.add(newRope);
		}
		
		return cost;
	}

}
