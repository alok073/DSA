package binarySearch;

/**
 * Q) Given a bitonic array, find the maximum element
 * -> bitonic array = An array which keeps on increasing first then after a particular index starts decreasing
 *   e.g = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}....max = 500
 *   
 * @author alok
 *
 */
public class MaxInABitonicArray {

	public static void main(String[] args) {
		int[] array = new int[] {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		
		int maxElementIndex = findMaxIndex(array);
		System.out.println("Index of max element in the array is = " + maxElementIndex);
	}
	
	/**
	 * - if A[mid] is max i.e A[mid]>A[mid-1] and A[mid+1]...return mid
	 * - else if A[mid-1]>A[mid]....go left
	 * - else go right
	 * NOTE = take care of edge cases when mid is at first or last index
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @return Integer index of maximum element
	 */
	public static int findMaxIndex(int[] array) {
		int n = array.length;
		if(n == 0) return -1;
		if(n == 1) return 0;
		
		int start = 0, end = n-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(mid != 0 && mid != n-1) {
				if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
					return mid;
				}
				else if(array[mid] < array[mid+1]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			else if(mid == 0) {
				if(array[0] > array[1]) return 0;
				else return 1;
			}
			else if(mid == n-1) {
				if(array[n-1] > array[n-2]) return n-1;
				else return n-2;
			}
		}
		return -1;
	}

}
