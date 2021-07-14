package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Q7) Given an array, sort it based on the frequency of the elements 
 * i/p: array = {3, 1, 4, 4, 5, 2, 6, 1}
 * o.p: { 4 4 1 1 6 5 3 2 }
 * 
 * @author alok
 *
 */

public class FrequencySort {

	public static void main(String[] args) {
		int array[] = new int[] {3, 1, 4, 4, 5, 2, 6, 1};	
		
		int freqSortedArray[] = frequencySort(array);
		System.out.print("Frequency sorted array: ");
		for(int i=0; i<freqSortedArray.length; i++) {
			System.out.print(freqSortedArray[i] + " ");
		}
		
	}
	
	/**
	 * - Create a hashMap, insert all elements of array & increment count of each occurrence
	 * - Create a maxHeap, insert all map entry in it
	 * - pop the top element, and change array based on the no. of count of occurrence of an element
	 * - return the array
	 * 
	 * Time = O(n * log n)
	 * Space = O(n)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] frequencySort(int[] array) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			hashMap.put(array[i], hashMap.getOrDefault(array[i], 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(
				(a,b) 
				-> a.getValue().equals(b.getValue())
				? Integer.compare(b.getKey(), a.getKey())
				: Integer.compare(b.getValue(), a.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			maxHeap.add(entry);
		}
		int heapSize = maxHeap.size();
		int j=0;
		for(int i=0; i<heapSize; i++) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			int key = entry.getKey();
			int value = entry.getValue();
			while(value > 0) {
				array[j] = key;
				j++;
				value--;
			}
		}
		
		return array;
	}

}
