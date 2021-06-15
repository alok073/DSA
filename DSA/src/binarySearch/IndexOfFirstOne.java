package binarySearch;

/**
 * Q) Given an infinite sorted array containing only 0's & 1's {0,0,0,0,1,1,1,1......}....find the 1st occurrence of 1 in the array
 * 
 * @author alok
 *
 */
public class IndexOfFirstOne {

	public static void main(String[] args) {
		int array[] = new int[]{0,0,0,0,0,0,0,1,1,1,1,1,1};
		
		int targetIndex = searchFirstOccurrenceOfOne(array, 1);
		if(targetIndex == -1) {
			System.out.println("Target element not present in the array");
		}
		else {
			System.out.println("Index of first occurrence of 1 is = " + targetIndex);
		}
	}
	
	/**
	 * - start = 0, end = 1
	 * - while A[end] < 1.....start=end, end=end*2
	 * - with the given start and end index apply first occurrence of target element=1
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer index of first occurrence of target element = 1
	 */
	public static int searchFirstOccurrenceOfOne(int[] array, int target) {
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
		return firstOccurrence(start, end, array, target);
	}
	
	public static int firstOccurrence(int start, int end, int[] array, int target) {
		int res = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				res = mid;
				end = mid-1;
			}
			else if(target < array[mid]) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return res;
	}

}
