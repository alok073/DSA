package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Q4) Given an array and int k, find max of each subarray of size k
 * e.g: array = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * o/p: 10 10 10 9 15 15 90 90
 * 
 * @author alok
 *
 */

public class MaxInEveryWindow {

	public static void main(String[] args) {
		int array[] = new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k = 3;
		
		findMaxInEveryWindow(array, k);
	}
	
	/**
	 * - we will use a deque of size k
	 * - we will insert an index 'i' at the back of queue until there is no element smaller than it
	 * - so the front of the deque will be the max of the current window....if the index at the front is not part of the current window we will remove it
	 * 
	 * Time = O(n)
	 * Space = O(k)
	 * 
	 * @param array
	 * @param k
	 */
	public static void findMaxInEveryWindow(int[] array, int k) {
		int size = array.length;
		if(k > size) {
			System.out.println("Invalid input");
			return;
		}
		
		Deque<Integer> deque = new LinkedList<Integer>();
		int i;
		for(i=0;i<k;i++) {
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		
		for(i=k;i<size;i++) {
			System.out.print(array[deque.peek()] + " ");
			
			if(!deque.isEmpty() && deque.peek() < i-k+1) {
				deque.removeFirst();
			}
			
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.print(array[deque.peek()] + " ");
		
	}

}
