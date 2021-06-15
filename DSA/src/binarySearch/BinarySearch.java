package binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int array[] = new int[] {2,5,6,8,11,12,15,18};
		int search = binarySearch(array, 8);
		//int search = binarySearchRecursive(0, array.length-1, array, 18);
		if(search == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("Index of target element is = " + search);
		}
	}
	
	/**
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return int index of target element
	 */
	public static int binarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				return mid;
			}
			else if(target < array[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param start
	 * @param end
	 * @param array
	 * @param target
	 * @return int index of target element
	 */
	public static int binarySearchRecursive(int start, int end, int[] array, int target) {
		if(start > end) {
			return -1;
		}
		
		int mid = start - (start - end)/2;
		if(target == array[mid]) return mid;
		else if(target < array[mid]) return binarySearchRecursive(start, mid-1, array, target);
		else return binarySearchRecursive(mid+1, end, array, target);
	}

}
