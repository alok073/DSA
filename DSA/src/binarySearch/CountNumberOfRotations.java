package binarySearch;

/**
 * Q) A sorted array is rotated 'x' times...find x
 * @author alok
 *
 */
public class CountNumberOfRotations {

	public static void main(String[] args) {
		//Original sorted array = {2,5,6,8,11,12,15,18}
		int array[] = new int[] {8,11,12,15,18,2,5,6}; //clockWise rotation
		//int array[] = new int[] {8,11,12,15,18,2,5,6}; //Anti-clockWise rotation
		
		int minIndex = minElementIndex(array); //5
		System.out.println("Index of Min element is = " + minIndex);
		
		int numberOfRotationsClockWise = array.length - minIndex; //8-5 = 3
		int numberOfRotationsAntiClockwise = minIndex; // 5
		
		System.out.println(numberOfRotationsClockWise);
	}
	
	/**
	 * - while start <= end
	 * 		- if A[start] < A[end]....array is sorted....min element is at start
	 * 		// min element is the only element whose prev & next element both are greater
	 * 		- if the the above case is met....mid is the min element
	 * 		- else if...check if A[start] to A[mid] is sorted...yes...min element is in the unsorted part...go right
	 * 		- else go left....since if left was not sorted then right part will be sorted...so go to the unsorted part i.e left side
	 * 
	 * Time = O(logn)
	 * Space = O(1)
	 * @param array
	 * @return Integer index of minimum element
	 */
	public static int minElementIndex(int[] array) {
		int n = array.length;
		int res = -1;
		int start = 0;
		int end = n - 1;
		while(start <= end) {
			if(array[start] < array[end]) {
				res = start;
				break;
			}
			
			int mid = start - (start - end)/2;
			int prev = (n - 1 - mid) % n;
			int next = (n + 1) % n;
			if(array[mid] < array[prev] && array[mid] < array[next]) {
				res = mid;
				break;
			}
			else if(array[start] < array[mid]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return res;
	}

}
