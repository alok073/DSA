package slidingWindow;

/**
 * Q1) Given an array and int k, find a subArray of length k whose sum is maximum
 * e.g: array = {1,4,2,10,23,3,1,0,20}, k=3
 * o/p: 36 i.e {10, 23, 3}
 * 
 * @author alok
 *
 */

public class MaxSumSubArray {

	public static void main(String[] args) {
		int array[] = new int[] {1,4,2,10,23,3,1,0,20};
		int k = 3;
		
		int maxSum = findMaxSubArray(array, k); //36
		if(maxSum == Integer.MIN_VALUE) {
			System.out.println("K is greater than array length");
		}
		else {
			System.out.println(maxSum);
		}
	}
	
	/**
	 * - Every time when the subArray is equal to 'k' then....maxm=max(maxm, sum)....subtract A[i] from sum....and increment i&j by 1
	 * - do this until 'j' reaches the last index
	 * Time = O(n)
	 * Space = O(1)
	 * 
	 * @param array
	 * @param k
	 * @return Integer max sum of subArray with size K
	 */
	public static int findMaxSubArray(int[] array, int k) {
		int size = array.length;
		if(size < k) return Integer.MIN_VALUE;
		
		int maxm = Integer.MIN_VALUE;
		int sum = 0;
		int i=0, j=0;
		while(j < size) {
			int windowSize = j-i+1;
			sum = sum + array[j];
			if(windowSize < k) {
				j++;
			}
			else if(windowSize == k) {
				maxm = Math.max(maxm, sum);
				sum = sum - array[i];
				i++;
				j++;
			}
		}
		
		return maxm;
	}

}
