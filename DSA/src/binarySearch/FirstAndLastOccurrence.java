package binarySearch;

public class FirstAndLastOccurrence {

	public static void main(String[] args) {
		int array[] = new int[] {1, 3, 5, 5, 5, 5, 67, 123, 125};
		int first = firstOccurrence(array, 5);
		if(first == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("First occurrence of target element is = " + first);
		}
	}
	
	/**
	 * - if target == array[mid]...res=mid & go left......rest everything is same as normal BS
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of first occurrence of target element
	 */
	public static int firstOccurrence(int[] array, int target) {
		int res = -1;
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				res = mid;
				end = mid-1;
			}
			else if(target < array[mid]) end = mid-1;
			else start = mid+1;
		}
		return res;
	}
	
	/**
	 * - if target == array[mid]...res=mid & go right......rest everything is same as normal BS
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of first occurrence of target element
	 */
	public static int lastOccurrence(int[] array, int target) {
		int res = -1;
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				res = mid;
				start = mid+1;
			}
			else if(target < array[mid]) end = mid-1;
			else start = mid+1;
		}
		return res;
	}

}
