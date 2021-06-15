package binarySearch;

/**
 * Q) Given a infinite sorted array, find the index of the target array
 * -> Infinite sorted array = A sorted array which has not end to its size
 * 
 * @author alok
 *
 */
public class SearchInInfiniteSortedArray {

	public static void main(String[] args) {
		int array[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		
		int targetIndex = searchTarget(array, 170);
		if(targetIndex == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("Index of target element is = " + targetIndex);
		}
	}
	
	/**
	 * - start=0, end=1
	 * - while array[end] < target....start=end, end=end*2...NOTE=> if end goes out of index range then assign it to the last index and break out of the loop
	 * - apply binary search with the current start & end values
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of the target element
	 */
	public static int searchTarget(int[] array, int target) {
		int start = 0, end = 1;
		int n = array.length;
		while(array[end] < target) {
			start = end;
			end = end * 2;
			if(end >= n) {
				end = n-1;
				break;
			}
		}
		return applyBinarySearch(start, end, target, array);
	}
	
	public static int applyBinarySearch(int start, int end, int target, int[] array) {
		int res = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				res = mid;
				break;
			}
			else if(target < array[mid]) end = mid-1;
			else start = mid+1;
		}
		return res;
	}

}
