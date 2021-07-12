package heaps;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * NOTE:- nearly sorted array/K sorted array
 * - each element is at most k index away from its target position i.e the position it would be at if the array was sorted
 * - For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 * 
 * Q4) Given a nearly sorted array/K sorted array, sort the array
 * 
 * @author alok
 *
 */

public class SortNearlySortedArray {

	public static void main(String[] args) {
		int array[] = new int[] {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		
		int sortedArray[] = sortNearlySortedArray(array, k);
		System.out.print("The sorted array is: ");
		for(int i : sortedArray) {
			System.out.print(i + " ");
		}
		
	}
	
	/**
	 * use minHeap as we want the smallest element to be poped first....bcoz we want sort array in ascending order
	 * - j=0, traverse through the array and insert in minHeap
	 * - if there are more than k elements in minHeap, pop the top element and put it in A[j] & then j++
	 * 
	 * Time = O(n * log k)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int[] sortNearlySortedArray(int[] array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int j=0;
		for(int i=0; i<array.length; i++) {
			minHeap.add(array[i]);
			if(minHeap.size() > k) {
				array[j] = minHeap.poll();
				j++;
			}
		}
		
		//for remaining K elements in heap
		Iterator<Integer> itr = minHeap.iterator();
		while(itr.hasNext()) {
			array[j] = minHeap.poll();
			j++;
		}
		
		return array;
	}

}
