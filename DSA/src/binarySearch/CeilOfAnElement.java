package binarySearch;

public class CeilOfAnElement {

	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 8, 10, 10, 12, 19};
		
		int ceilOfTarget = ceil(array, 100);
		System.out.println("ceil of target element is = " + ceilOfTarget);
	}
	
	/**
	 * NOTE => ceilOfAnElement = smallest larger element than the the target....or if the target is already present then ceil = target
	 * - if target == A[mid]...then target is the ceil itself
	 * - else if target < A[mid]....then make A[mid] as ceil and go left
	 * - else go right
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * @param array
	 * @param target
	 * @return Integer ceil element value of the target element
	 */
	public static int ceil(int[] array, int target) {
		int res = -1;
		int start = 0, end = array.length - 1;
		while(start <= end) {
			int mid = start - (start - end)/2;
			if(target == array[mid]) {
				return target;
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
