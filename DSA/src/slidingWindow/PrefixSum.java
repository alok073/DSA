package slidingWindow;

/**
 * Q5) Given an array, find its prefix sum Array
 * e.g: {10, 5, 2, 7, 1, 9}
 * o/p: {10, 15, 17, 24, 25, 34}
 * 
 * @author alok
 *
 */

public class PrefixSum {

	public static void main(String[] args) {
		int array[] = new int[] {-5, 8, -14, 2, 4, 12};
		int n = array.length;
		
		int prefix[] = prefixSum(array, n);
		for(int i:prefix) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * @param array
	 * @param n
	 * @return Integer array of prefix sum
	 */
	public static int[] prefixSum(int[] array, int n) {
		int[] prefixArray = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + array[i];
			prefixArray[i] = sum;
		}
		
		return prefixArray;
	}

}
