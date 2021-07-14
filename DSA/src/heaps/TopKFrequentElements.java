package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Q6) Given an array & an int k, print top k elements that occur maxm number of times. (If 2 elements occur same no. of times, prefer the element greater in them)
 * i/p: array = {3, 1, 4, 4, 5, 2, 6, 1}
 * 		k = 3
 * o/p: {4, 1, 6}
 * 
 * @author alok
 *
 */

public class TopKFrequentElements {

	public static void main(String[] args) {
		int array[] = new int[] {3, 1, 4, 4, 5, 2, 6, 1};
		int k = 3;
		
		findTopKFrequentElement(array, k);
		
	}
	
	/**
	 * - Create a hashMap, insert all the elements. key->A[i], Value->count(A[i])
	 * - Create a maxHeap, insert each entry of hashMap in maxHeap
	 * - print 1st k elements of maxHeap
	 * 
	 * Time = O(n * log k)
	 * Space = O(n)
	 * 
	 * @param array
	 * @param k
	 */
	public static void findTopKFrequentElement(int[] array, int k) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			hashMap.put(array[i], hashMap.getOrDefault(array[i], 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a,b) -> a.getValue().equals(b.getValue())
				? Integer.compare(b.getKey(), a.getKey())
				: Integer.compare(b.getValue(), a.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			maxHeap.offer(entry);
		}
		
		for(int i=0; i<k; i++) {
			Map.Entry<Integer, Integer> a = maxHeap.poll();
			System.out.println("element:" + a.getKey() + " frequency:" + a.getValue());
		}
				
	}

}
