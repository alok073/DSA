package sorting.insertionSort;
/**
 * - start from i=1
 * - find the index(j) of smallest no. which is greater than A[i] to the left side (<i)
 * - shift all elements(A[j] to A[i-1]) to right side by 1
 * - A[j] = A[i-1]
 * - i++
 * e.g: {3, 4, 2, 5, 1}
 * ~ i=1, no element smaller than A[i] before i=1
 * ~ i=2, 3 > A[i], {2, 3, 4, 5, 1}
 * ~ i=3, no element smaller than A[i] before i=1
 * ~ i=4, 2 > A[i], {1, 2, 3, 4, 5}
 */

public class InsertionSort {

	public static void main(String[] args) {
		
		int array[] = new int[] {3,4,2,5,1};
		solve(array);
		
	}
	
	public static void solve(int array[]) {
		for(int i=1;i<array.length;i++) {
			int j=i;
			
			while(j>0 && array[j-1] > array[i]) {
				j--;
			}
			
			int temp = array[i];
			for(int k=i; k>j; k--) {
				array[k] = array[k-1];
			}
			array[j] = temp;
		}
	}

}
