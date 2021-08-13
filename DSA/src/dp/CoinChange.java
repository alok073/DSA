package dp;

/**
 * Q11) Given an array denoting values of coins available and a target change to reach, find no. of ways you can make the target change if the supply of coins is unlimited
 * i/p: array = {1,2,3}
 * 		targetSum = 4
 * o/p: 4
 * 
 * -->
 * {2,2} = 4
 * {1,1,2} = 4
 * {1,3} = 4
 * {1,1,1,1} = 4
 * 
 * @author alok
 *
 */

public class CoinChange {

	public static void main(String[] args) {
		int array[] = {2,5,3,6};
		int targetSum = 10;
		int n = array.length;
		
		//int totalWays = coinChangeRecursive(array, targetSum, n);
		int totalWays = coinChangeDP(array, targetSum, n);
		System.out.println("Total no. of ways to make the target change = " + totalWays);
	}
	
	/**
	 * - Unbounded knapsack
	 * - Exactly like count number of subsets... just that we can repeat a coin multiple times
	 * 
	 * @param array
	 * @param sum
	 * @param n
	 * @return int : total ways to make the given change
	 */
	static int coinChangeRecursive(int[] array, int sum, int n) {
		if(sum == 0) return 1;
		if(n == 0) return 0;
		
		if(array[n-1] <= sum) {
			return coinChangeRecursive(array, sum-array[n-1], n) + coinChangeRecursive(array, sum, n-1);
		}
		else {
			return coinChangeRecursive(array, sum, n-1);
		}
	}
	
	static int coinChangeDP(int[] array, int sum, int n) {
		int dp[][] = new int[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j == 0) dp[i][j] = 1;
				if(i == 0 & j != 0) dp[i][j] = 0;
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(array[i-1] <= j) {
					dp[i][j] = dp[i][j-array[i-1]] + dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}

}
