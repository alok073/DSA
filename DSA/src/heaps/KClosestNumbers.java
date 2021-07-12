package heaps;

import java.util.PriorityQueue;
import javafx.util.Pair;

/**
 * Q5) Given an unsorted array, int k, int x; print K closest numbers to 'x' present in the array
 * i/p: array = {10, 2, 14, 4, 7, 6};
		k = 3;
		x = 5;
 * o/p: {4, 7, 6}
 * 
 * @author alok
 *
 */

public class KClosestNumbers {

	public static void main(String[] args) {
		int array[] = new int[] {10, 2, 14, 4, 7, 6};
		int k = 3;
		int x = 5;
		
		PriorityQueue<Pair<Integer, Integer>> KClosest = findKClosestNumbers(array, k, x);
		for(Pair<Integer, Integer> pair : KClosest) {
			System.out.print(array[pair.getValue()] + " ");
		}
		
	}
	
	public static PriorityQueue<Pair<Integer, Integer>> findKClosestNumbers(int[] array, int k, int x) {
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>> ((a,b) -> b.getKey()-a.getKey());
		for(int i=0; i<array.length; i++) {
			maxHeap.add(new Pair<Integer, Integer> (Math.abs(x-array[i]), i));
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap;
	}
	
	/**
	 * - minHeap with type Pair<Integer, Integer>
	 * 		- PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>> ((a,b) -> a.getKey() - b.getKey());
	 * 
	 * - maxHeap with type Pair<Integer, Integer>
	 * 		- PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>> ((a,b) -> b.getKey() - a.getKey());
	 */

}
