package recursion.examples;

/**
 * Q) given an array find min and max of array recursively
 * @author alok
 */

public class MinMaxOfArray {

	public static void main(String[] args) {
		int[] array = new int[] {6,3,1,4,2,8};
		System.out.println(maxOfArray(array, 6));
		System.out.println(minOfArray(array, 6));
	}
	
	public static int maxOfArray(int[] array, int n) {
		if(n == 1) {
			return array[n-1];
		}
		
		return Math.max(array[n-1], maxOfArray(array, n-1));
	}
	
	public static int minOfArray(int[] array, int n) {
		if(n == 1) {
			return array[n-1];
		}
		return Math.min(array[n-1], minOfArray(array, n-1));
	}

}