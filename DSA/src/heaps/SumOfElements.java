package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Q10) Given an array and int k1 & k2, find all the elements in the array that are greater than K1th & K2th smallest numbers in the array
 * i/p: {1,3,12,5,15,11}, k1=3, k2=6
 * o/p: 23
 * 
 * Explanation:-
 * K1th smallest = 5
 * K2th smallest = 15
 * elements greater than 5 & less than 15 = 12 + 11 = 23
 * 
 * @author alok
 *
 */

public class SumOfElements {

	public static void main(String[] args) {
		int array[] = new int[] {1,3,12,5,15,11};
		int k1 = 3;
		int k2 = 6;
		
		int k1thSmallest = KthSmallest(array, k1);
		int k2thSmallest = KthSmallest(array, k2);
		
		int sum = 0;
		for(int i=0; i < array.length; i++) {
			if(array[i] > k1thSmallest && array[i] < k2thSmallest) {
				sum = sum + array[i];
			}
		}
		
		System.out.println("Sum of all elements between K1th & K2th smallest numbers = " + sum);
		
	}
	
	/**
	 * - create a maxHeap
	 * - insert elements...if heap size>k...pop it
	 * - The Kth smallest element will be at the top of heap
	 * 
	 * Time = O(n * log k)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 * @return Integer Kth smallest element in the array
	 */
	public static int KthSmallest(int[] array, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<array.length; i++) {
			maxHeap.add(array[i]);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.poll();
	}

}
