package binarySearch;

/**
 * Q) Given a rotated sorted array, find the index of a target element
 * 
 * @author alok
 *
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int array[] = new int[] {11,12,15,18,2,5,6,8};
		
		int targetIndex = searchTarget(array, 2);
		if(targetIndex == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("Index of target element is = " + targetIndex);
		}
	}
	
	/**
	 * - if target == A[mid]....return mid
	 * - else if check A[start] to A[mid] is sorted
	 * 		- check if target lies in between A[start] to A[mid]...yes....go left...else...go right
	 * - else
	 * 		- check if target lies in between A[mid+1] to A[end]...yes....go right...else...go left
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of target element
	 */
	public static int searchTarget(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				return mid;
			}
			else if(array[start] < array[mid]) {
				if(target >= array[start] && target <= array[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
			else {
				if(target >= array[mid+1] && target <= array[end]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
