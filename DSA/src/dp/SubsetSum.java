package dp;

import java.util.Arrays;

/**
 * Q4) Given an array and a target sum, check if there exists a subset with sum equal to the target sum
 * 
 * @author alok
 *
 */

public class SubsetSum {
	
	static boolean dp[][];

	public static void main(String[] args) {
		int array[] = new int[] {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = array.length;
		
		dp = new boolean[101][1001];
		for(boolean[] row: dp) {
			Arrays.fill(row, false);
		}
		
		boolean subsetPresent = findSubsetIterative(array, sum, n);
		System.out.println("Subset with the given sum present? " + subsetPresent);
		
	}
	
	static boolean findSubsetRecursive(int[] array, int sum, int n) {
		if(sum == 0) {
			return true;
		}
		if(n == 0) {
			return false;
		}
		
		if(array[n-1] <= sum) {
			return findSubsetRecursive(array, sum-array[n-1], n-1) || findSubsetRecursive(array, sum, n-1);
		}
		else return findSubsetRecursive(array, sum, n-1);
	}
	
	static boolean findSubsetMemoized(int[] array, int sum, int n) {
		if(sum == 0) {
			return true;
		}
		if(n == 0) {
			return false;
		}
		
		if(dp[n][sum]) {
			return true;
		}
		
		if(array[n-1] <= sum) {
			return findSubsetRecursive(array, sum-array[n-1], n-1) || findSubsetRecursive(array, sum, n-1);
		}
		else return findSubsetRecursive(array, sum, n-1);
	}
	
	static boolean findSubsetIterative(int[] array, int sum, int n) {
		boolean dp1[][] = new boolean[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j == 0) dp1[i][j] = true;
				if(i == 0 && j != 0) dp1[i][j] = false;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(array[i-1] <= j) {
					dp1[i][j] = dp1[i-1][j-array[i-1]] || dp1[i-1][j];
				}
				else dp1[i][j] = dp1[i-1][j];
			}
		}
		
		return dp1[n][sum];
	}

}
