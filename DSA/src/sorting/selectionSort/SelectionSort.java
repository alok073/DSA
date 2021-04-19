package sorting.selectionSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Crux -> find min element in unSortedArray and place it in the end of SortedArray
 * e.g = 3 4 2 5 1
 * - (i=0 to 4, min=1, swap A[i] & 1, i++) = 1 4 2 5 3 
 * - (i=1 to 4, min=2, swap A[i] & 2, i++) = 1 2 4 5 3
 * - (i=2 to 4, min=3, swap A[i] & 3, i++) = 1 2 3 5 4
 * - (i=3 to 4, min=4, swap A[i] & 4, i++) = 1 2 3 4 5
 * Time complexity = O(n^2)
 * Space complexity = O(1)
 */

public class SelectionSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<Integer>(
				Arrays.asList(3, 4, 2, 5, 1));
		
		solve(array);
	}
	
	public static void solve(ArrayList<Integer> array) {
		for(int i=0;i<array.size()-1;i++) {
			int minimumIndex = findMinimumIndex(i, array);
			
			int temp = array.get(i);
			array.set(i, array.get(minimumIndex));
			array.set(minimumIndex, temp);
		}
	}
	
	public static int findMinimumIndex(int start, ArrayList<Integer> array) {
		int minimum = Integer.MAX_VALUE;
		int minimumIndex = 0;
		for(int i=start;i<array.size();i++) {
			if(array.get(i) < minimum) {
				minimum = array.get(i);
				minimumIndex = i;
			}
		}
		
		return minimumIndex;
	}

}
