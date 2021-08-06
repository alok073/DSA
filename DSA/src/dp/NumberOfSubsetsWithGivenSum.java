package dp;

/**
 * Q6) Given an array and a sum, return number of subsets having sum equal to the given target sum
 * i/p: array = {2,3,5,6,8,10}
 * 		sum = 10
 * o/p: 3
 * {2,3,5}, {2,8}, {10}
 * 
 * @author alok
 *
 */

public class NumberOfSubsetsWithGivenSum {

	public static void main(String[] args) {
		int array[] = new int[] {2,3,5,6,8,10};
		int sum = 10;
		int n = array.length;
		
		int numberOfSubsets = findNumberOfSubsetsIterative(array, sum, n);
		System.out.println("Number of subsets with a given sum is = " + numberOfSubsets);
	}
	
	static int findNumberOfSubsetsRecursive(int[] array, int sum, int n) {
		if(sum == 0) {
			return 1;
		}
		if(n == 0) {
			return 0;
		}
		
		if(array[n-1] <= sum) {
			return findNumberOfSubsetsRecursive(array, sum-array[n-1], n-1) + findNumberOfSubsetsRecursive(array, sum, n-1);
		}
		else return findNumberOfSubsetsRecursive(array, sum, n-1);
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
