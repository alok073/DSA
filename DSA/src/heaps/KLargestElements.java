package heaps;

import java.util.PriorityQueue;

/**
 * Q3) Given an array and int K, find K largest elements in the array
 * i/p: array = {7, 10, 3, 4, 15, 9, 25, 77, 12}
 * 		k = 3
 * o/p: {15, 25, 77}
 * 
 * @author alok
 *
 */

public class KLargestElements {

	public static void main(String[] args) {
		int array[] = new int[] {7, 10, 3, 4, 15, 9, 25, 77, 12};
		int k = 3;
		
		Object KLargestElementsArray[] = findKLargestElements(array, k);
		System.out.print("The K Largest elements are: ");
		for(Object i : KLargestElementsArray) {
			System.out.print(i + " ");
		}
		
	}
	
	/**
	 * k + largest = minHeap
	 * - traverse the array, add elements in minHeap
	 * - if there are more than K elements in minHeap....pop the top element
	 * - convert minHeap to an Array and return it
	 * 
	 * Time - O(n * log k)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 * @return Object Array consisting K largest elements
	 */
	public static Object[] findKLargestElements(int array[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0; i<array.length; i++) {
			minHeap.add(array[i]);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.toArray();
	}

}
