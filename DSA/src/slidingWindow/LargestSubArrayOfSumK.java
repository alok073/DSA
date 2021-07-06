package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q6) Given an array and sum (k), find the length of the largest subArray whose sum equals k. If no such subArray found then return 0.
 * e.g: array = {-5, 8, -14, 2, 4, 12}; k = -5
 * o/p: 5 i.e {-5,8,-14,2,4}
 * 
 * @author alok
 *
 */

public class LargestSubArrayOfSumK {

	public static void main(String[] args) {
		//int array[] = new int[] { 10, 5, 2, 7, 1, 9 };
		int array[] = new int[] {-5, 8, -14, 2, 4, 12}; // -5 3 -11 -9 -5 7
		int k = -5;
		
		int maxSubArrayLength = findLargestSubArrayOfSumK(array, k);
		if(maxSubArrayLength == 0) {
			System.out.println("No subArray found whose sum equals k");
		}
		else {
			System.out.println("Largest subArray size = " + maxSubArrayLength);
		}
	}
	
	/**
	 * Logic is an extension of prefix sum
	 * - maintain a hashMap which will store all the prefix sum and index
	 * - calculate prefix sum
	 * - if sum == k....maxLength = i+1
	 * - if sum is not present in hashMap then insert it
	 * - check if (sum - k) is present in hashMap...if yes....maxLength = max of maxLength & diff between i and the index of (sum-k) present in hashMap
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int findLargestSubArrayOfSumK(int[] array, int k) {
		int maxLength = 0;
		int sum = 0;
		int n = array.length;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer> ();
		
		for(int i=0; i<n; i++) {
			sum = sum + array[i];
			
			if(sum == k) {
				maxLength = i+1;
			}
			
			if(!hashMap.containsKey(sum)) {
				hashMap.put(sum, i);
			}
			
			if(hashMap.containsKey(sum - k)) {
				maxLength = Math.max(maxLength, i - hashMap.get(sum-k));
			}
			
		}
		
		return maxLength;
	}

}
