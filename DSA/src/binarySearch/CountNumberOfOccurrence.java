package binarySearch;

/**
 * Q) Given a sorted array and a target value, find how many times the target value occurs in the array
 * 
 * @author alok
 *
 */
public class CountNumberOfOccurrence {

	public static void main(String[] args) {
		int array[] = new int[] {1, 3, 5, 5, 5, 5, 67, 123, 125};
		int first = firstOccurrence(array, 5);
		int last = lastOccurrence(array, 5);
		
		int totalOccurrence = last - first + 1;
		System.out.println("Number of occurrence of target element is = " + totalOccurrence);
	}
	
	public static int firstOccurrence(int[] array, int target) {
		int res = -1;
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start - (start - end)/2;
			if(target == array[mid]) {
				res = mid;
				end = mid-1;
			}
			else if(target < array[mid]) end = mid-1;
			else start = mid+1;
		}
		return res;
	}
	
	public static int lastOccurrence(int[] array, int target) {
		int res = -1;
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start - (start - end)/2;
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
