package binarySearch;

public class FloorOfAnElement {

	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 8, 10, 10, 12, 19};
		
		int floorOfTarget = floor(array, 11);
		System.out.println("Floor of target element is = " + floorOfTarget);
	}
	
	/**
	 * NOTE => floorOfAnElement = largest smaller element than the the target....or if the target is already present then floor = target
	 * - if target == A[mid]...then target is the floor itself
	 * - else if target < A[mid]....then go left
	 * - else....make A[mid] as floor and...go right
	 * 
	 * Time = O(log n)
	 * Space = O(1)
	 * @param array
	 * @param target
	 * @return Integer floor element value of the target element
	 */ 
	public static int floor(int[] array, int target) {
		int res = -1;
		int start = 0, end = array.length - 1;
		while(start <= end) {
			int mid = start - (start - end)/2;
			if(target == array[mid]) {
				return target;
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

}
