package binarySearch;

/**
 * Q) Given a bitonic array, return index of the target element
 * -> bitonic array = An array which keeps on increasing first then after a particular index starts decreasing
 * e.g = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
 * 
 * @author alok
 *
 */
public class SearchInBitonicArray {

	public static void main(String[] args) {
		int[] array = new int[] {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int searchIndex = searchTarget(array, 20);
		
		if(searchIndex == -1) {
			System.out.println("Target element not present");
		}
		else {
			System.out.println("Index of target element is = " + searchIndex);
		}
	}
	
	/**
	 * - find index of max element...then apply binary search(asc) on left side A[0] to A[max-1]...apply binary search(desc) on right side A[max] to A[n-1]
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of target element
	 */
	public static int searchTarget(int[] array, int target) {
		int n = array.length;
		
		int maxIndex =  maxOfBitonicArray(array, target);
		
		int ascSearchIndex = ascendingBinarysearch(0, maxIndex-1, target, array);
		if(ascSearchIndex != -1) return ascSearchIndex; //element found
		
		int descSearchIndex = descendingBinarySearch(maxIndex, n-1, target, array);
		return descSearchIndex;
	}
	
	public static int maxOfBitonicArray(int[] array, int target) {
		int n = array.length;
		if(n == 0) return -1;
		if(n == 1) return 0;
		
		int start=0, end=n-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(mid != 0 && mid != n-1) {
				if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
					return mid;
				}
				else if(array[mid] < array[mid+1]) {
					start = mid+1;
				}
				else {
					end = mid-1;
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
	
	public static int ascendingBinarysearch(int start, int end, int target, int[] array) {
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(array[mid] == target) {
				return mid;
			}
			else if(target < array[mid]) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static int descendingBinarySearch(int start, int end, int target, int[] array) {
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(array[mid] == target) {
				return mid;
			}
			else if(target < array[mid]) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return -1;
	}

}
