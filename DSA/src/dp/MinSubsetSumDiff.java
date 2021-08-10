package dp;

/**
 * Q7) Given an array, find the value of minimum difference between two subsets of the array
 * i/p: array = {1,6,11,5}
 * o/p: 1
 * -> subset1={11}, subset2={1,6,5} .... difference = abs(11-12) = 1
 * 
 * @author alok
 *
 */

public class MinSubsetSumDiff {

	public static void main(String[] args) {
		int array[] = new int[] {1,6,11,5};
		int n = array.length;
		int sum = 0;
		for(int i=0;i<array.length; i++) {
			sum = sum + array[i];
		}
		
		//int minDiff = minSubSetSumDiffRecursive(array, n, sum, 0);
		int minDiff = minSubsetDiffBottomUpApproach(array, n, sum);
		System.out.println("The min subset difference = " + minDiff);
		
	}
	
	static int minSubSetSumDiffRecursive(int[] array, int n, int totalSum, int calculatedSum) {
		if(n == 0) {
			return Math.abs((totalSum - calculatedSum) - calculatedSum);
		}
		
		return Math.min(minSubSetSumDiffRecursive(array, n-1, totalSum, calculatedSum+array[n-1]), minSubSetSumDiffRecursive(array, n-1, totalSum, calculatedSum));
		
	}
	
	static int minSubsetDiffBottomUpApproach(int[] array, int n, int totalSum) {
		boolean dp[][] = subsetSum(array, totalSum, n);
		int minm = Integer.MAX_VALUE;
		for(int i=0; i<=totalSum/2; i++) {
			if(dp[n][i]) {
				minm = Math.min(minm, Math.abs((totalSum-i) - i));
			}
		}
		return minm;
	}
	
	static boolean[][] subsetSum(int[] array, int sum, int n) {
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j == 0) dp[i][j] = true;
				if(i == 0 && j!=0) dp[i][j] = false;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(array[i-1] <= j) {
					dp[i][j] = dp[i-1][j-array[i-1]] || dp[i-1][j];
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp;
	}

}
