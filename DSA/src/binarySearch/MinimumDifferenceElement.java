package binarySearch;

/**
 * Q) Given a sorted array & a target, find an element whose absolute diff with the target is minimum
 * 
 * @author alok
 *
 */
public class MinimumDifferenceElement {

	public static void main(String[] args) {
		int[] array = new int[] {1,3,8,10,12,15};
		
		int minDifferenceElement = findMinimumDiffElement(array, 12); //10
		
		System.out.println("Minimum difference element is = " + minDifferenceElement);
	}
	
	/**
	 * - calculate the floor & ceil of target
	 * - find the abs diff...whose ever diff is min return it
	 * NOTE =  while calculating floor & ceil...if the target is present in the array...keep on calculating the floor/ceil....as the target is not the floor/ceil
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param target
	 * @return Integer element whose abs diff is min with the target element
	 */
	public static int findMinimumDiffElement(int[] array, int target) {
		int floorOfTarget = floor(array, target); //10..diff=2
		int ceilOfTarget = ceil(array, target); //15...diff=3
		
		if(Math.abs(floorOfTarget-target) < Math.abs(ceilOfTarget - target)) {
			return floorOfTarget;
		}
		else {
			return ceilOfTarget;
		}
	}
	
	public static int floor(int[] array, int target) {
		int start = 0, end = array.length - 1;
		int res = Integer.MIN_VALUE;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				end = mid - 1;
			}
			else if(target < array[mid]) {
				end = mid - 1;
			}
			else {
				res = array[mid];
				start = mid + 1;
			}
		}
		return res;
	}
	
	public static int ceil(int[] array, int target) {
		int start = 0, end = array.length - 1;
		int res = Integer.MIN_VALUE;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(target == array[mid]) {
				start = mid + 1;
			}
			else if(target < array[mid]) {
				res = array[mid];
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return res;
	}

}
