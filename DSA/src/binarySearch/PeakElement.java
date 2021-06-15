package binarySearch;

/**
 * Q) Given an unsorted array, find the index of a peak element
 * => peak element = any element which is greater than both of it's neighbor elements i.e elements to its left and right
 * NOTE => there can be more than 1 peak element...return the index of any one of it
 * 
 * @author alok
 *
 */
public class PeakElement {

	public static void main(String[] args) {
		int[] array = new int[] {10, 20, 15, 2, 23, 90, 67};
		
		int peakIndex = findPeakElement(array);
		
		System.out.println("Peak element is at index = " + peakIndex);
	}
	
	/**
	 * - check if mid is peak element...return mid
	 * - else check if A[mid-1]>A[mid]....go left
	 * - else go right
	 * NOTE = take care of the condition where mid is at the first or last index
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @return Integer index of the peak element
	 */
	public static int findPeakElement(int[] array) {
		int n = array.length;
		if(n == 0) return -1;
		if(n == 1) return 0;
		
		int start = 0, end = n - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(mid !=0 && mid != n-1) {
				if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
					return mid;
				}
				else if(array[mid-1] > array[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
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
