package sorting.bubbleSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Goal = for every pass push the greatest number to the last index
 * - if A[i] > A[i+1] then swap...do this n-1 times (n=size of array)
 * Time complexity = O(n^2)
 * Space complexity = O(1)
 *
 */

public class BubbleSort {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(
				Arrays.asList(3,4,2,5,1));
		
		solve(array);
		
	}
	
	public static void solve(ArrayList<Integer> array) {
		for(int i=0;i<array.size()-1;i++) {
			for(int j=0;j<array.size()-i-1;j++) {
				if(array.get(j) > array.get(j+1)) {
					int temp = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, temp);
				}
			}
		}
	}

}
