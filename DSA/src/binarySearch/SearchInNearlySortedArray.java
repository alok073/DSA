package binarySearch;

/**
 * Q) Given a nearly sorted array, find the index of the target element
 * - A nearly sorted array is an array wherein an element at index=i could be at index i-1 or i+1
 * 
 * @author alok
 *
 */
public class SearchInNearlySortedArray {

	public static void main(String[] args) {
		int array[] = new int[] {10, 3, 40, 20, 50, 80, 70};
		
		int searchIndex = searchElement(array, 3);
		if(searchIndex == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("Index of target element is = " + searchIndex);
		}
	}
	
	/**
	 * - Compare target with mid, mid-1 & mid+1 (NOTE -> take care of out of bound exception)
	 * - if it matches...return the index
	 * - check if target is smaller than A[mid]....go left...make end=mid-2
	 * - else....go right...make start=mid+2
	 * 
	 * Time = O(n)
	 * Space = O(1)
	 * @param array
	 * @param target
	 * @return
	 */
	public static int searchElement(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				return mid;
			}
			if(mid-1 >= start && target == array[mid-1]) {
				return mid-1;
			}
			if(mid+1 <= end && target == array[mid+1]) {
				return mid+1;
			}
			
			if(target < array[mid]) {
				end = mid-2;
			}
			else {
				start = mid+2;
			}
		}
		return -1;
	}

}
