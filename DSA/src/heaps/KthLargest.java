package heaps;

import java.util.PriorityQueue;

/**
 * Q2) Given an array and an int K, find the K'th largest element in the array
 * 
 * @author alok
 *
 */

public class KthLargest {

	public static void main(String[] args) {
		int array[] = new int[] {7, 10, 4, 3, 20, 15};
		int k = 3;
		
		int KthLargestElement = findKthLargestElement(array, k);
		System.out.println("The Kth largest element is = " + KthLargestElement);
	}
	
	/**
	 * k + largest = minHeap
	 * - traverse the array, add elements in minHeap
	 * - if there are more than K elements in minHeap....pop the top element
	 * - return top of the minHeap as answer
	 * 
	 * Time = O(n * log k)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 * @return Integer K'th largest element in the array
	 */
	public static int findKthLargestElement(int[] array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0; i<array.length; i++) {
			minHeap.add(array[i]);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.peek();
	}

}
