package heaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
		
		//findTopKFrequentElement(array, k);
		findTopKFrequentElementHashLambda(array, k);
		
	}
	
	/**
	 * - Create a hashMap, insert all the elements. key->A[i], Value->count(A[i])
	 * - Create a maxHeap, insert each entry of hashMap in maxHeap(Custom Comparator)
	 * - print 1st k elements of maxHeap
	 * 
	 * Time = O(n * log n)
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
	
	/**
	 * Using Hashing: Time=O(n*log n), Space=O(n)
	 * 
	 * 1) create a hashMap & input A[i] as key and increment its value whenever A[i] occurs in the array
	 * 2) sort this hashMap by a custom Comparator. if value of 2 entries in a map is equal, sort by key else sort by value
	 * 3) print 'k' elements of the sorted hashMap
	 * 
	 * @param array
	 * @param k
	 */
	static void findTopKFrequentElementHashLambda(int[] array, int k) {
		Map<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			hashMap.put(array[i], hashMap.getOrDefault(array[i], 0)+1);
		}
		
		Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
		hashMap.entrySet()
		.stream()
		.sorted((a1,a2) -> a1.getValue().equals(a2.getValue())
				? a2.getKey() - a1.getKey()
				: a2.getValue() - a1.getValue())
		.forEachOrdered(x -> map1.put(x.getKey(), x.getValue()));

		int cnt = 0;
		for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			if(cnt >= k) break;
			System.out.println("element:" + entry.getKey() + " frequency:" + entry.getValue());
			cnt++;
		}
	}
}
