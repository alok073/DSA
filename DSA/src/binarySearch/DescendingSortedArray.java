package binarySearch;

public class DescendingSortedArray {

	public static void main(String[] args) {
		int array[] = new int[] {18,15,12,11,8,6,5,2};
		int search = binarySearch(array, 6);
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
			int mid = start - (start - end)/2;
			if(target == array[mid]) return mid;
			else if(target < array[mid]) start = mid+1;
			else end = mid-1;
		}
		return -1;
	}

}
