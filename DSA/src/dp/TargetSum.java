package dp;

/**
 * Q9) Given an array & an int targetSum, find number of ways in which we can reach the target by either subtracting/adding each element in the array
 * i/p: array = {1,1,2,3}
 * 		targetSum = 3
 * o/p = 2
 * 
 * -->
 * 1] -1-1+2+3 = 3
 * 2] +1+1-2+3 = 3
 * 
 * @author alok
 *
 */

public class TargetSum {

	public static void main(String[] args) {
		int array[] = new int[] {1,1,2,3};
		int targetSum = 3;
		int n = array.length;
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + array[i];
		}
		
		int numberOfWays = targetSumRecursive(array, targetSum, n, 0);
		//int numberOfWays = countOfMinSubsetSumDiff(array, targetSum, sum, n);
		System.out.println("Number of ways to reach target sum = " + numberOfWays);
	}
	
	static int targetSumRecursive(int[] array, int targetSum, int n, int currentSum) {
		if(n == 0) {
			if(currentSum == targetSum) return 1;
			return 0;
		}
		
		return targetSumRecursive(array, targetSum, n-1, currentSum + array[n-1]) + targetSumRecursive(array, targetSum, n-1, currentSum - array[n-1]);
	}
	
	/*
	 * - DP solution of this problem is exactly the prev problem i.e CountOfMinSubsetDiff
	 */
	
	/*
	 * - sum(subset1) - sum(subset2) = diff
	 * - sum(subset1) + sum(subset2) = sum(array)
	 * add both equations
	 * - sum(subset1) = (diff + sum(array))/2
	 * i.e find the count of all the subsets whose sum = (diff + sum(array))/2
	 */
	static int countOfMinSubsetSumDiff(int[] array, int diff, int totalSum, int n) {
		int targetSum = (diff + totalSum)/2;
		return findNumberOfSubsetsIterative(array, targetSum, n);
	}
	
	static int findNumberOfSubsetsIterative(int[] array, int sum, int n) {
		int dp[][] = new int[n+1][sum+1];
		//base cases -> initialization
		for(int i=0; i<=n; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=sum; i++) {
			dp[0][i] = 0;
		}
		
		//choice diagram -> iterative
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(array[i-1] <= j) {
					dp[i][j] = dp[i-1][j-array[i-1]] + dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
