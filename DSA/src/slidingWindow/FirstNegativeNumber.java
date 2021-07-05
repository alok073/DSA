package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Q) Given an array and int K, find the 1st negative element in each subArray of size=k. If there is no -ve element in a subArray print 0 for that particular subAarray
 * -> array = {12, -1, -7, 8, -15, 30, 16, 28}
 * o/p: [-1, -1, -7, -15, -15, 0]
 * 
 * @author alok
 *
 */

public class FirstNegativeNumber {

	public static void main(String[] args) {
		int array[] = new int[] {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		
		findFirstNegativeNumberInEveryWindow(array, k);
	}
	
	/**
	 * - i=0,j=0
	 * - keep on doing the foll. steps tile j<A.length
	 * 		- if A[j] is -ve...push it to the list
	 * 		- increment j till windowSize==k
	 * 		- if windowSize==k....
	 * 			- if list is empty...print "0"....else print print list[0]
	 * 			- check if A[i] is -ve....if yes....remove the 1st element from the list
	 * 			- i++, j++
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param k
	 */
	public static void findFirstNegativeNumberInEveryWindow(int[] array, int k) {
		int size = array.length;
		int i=0, j=0;
		List<Integer> list = new ArrayList<Integer>();
		while(j < size) {
			if(array[j] < 0) {
				list.add(array[j]);
			}
			
			int windowSize = j-i+1;
			if(windowSize < k) {
				j++;
			}
			else if(windowSize == k) {
				if(!list.isEmpty()) {
					System.out.println(list.get(0) + " ");
				}
				else {
					System.out.println("0");
				}
				
				if(array[i] < 0) {
					list.remove(0);
				}
				i++;
				j++;
			}
		}
	}

}
