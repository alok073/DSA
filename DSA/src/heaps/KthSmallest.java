package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Q1) Given an array and an int K, find the K'th smallest element in the array
 * 
 * @author alok
 *
 */

public class KthSmallest {

	public static void main(String[] args) {
		int array[] = new int[] {7, 10, 4, 3, 20, 15};
		int k = 3;
		
		int KthSmallestElement = findKthSmallestElement(array, k);
		System.out.println("The Kth smallest element is = " + KthSmallestElement);
		
	}
	
	/**
	 * k + smallest = maxHeap
	 * - traverse the array, add elements in maxHeap
	 * - if there are more than K elements in maxHeap....pop the top element
	 * - return top of the maxHeap as answer
	 * 
	 * Time = O(n * logk)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int findKthSmallestElement(int[] array, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
				Collections.reverseOrder());
		for(int i=0; i<array.length; i++) {
			maxHeap.add(array[i]);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.peek();
	}

}
