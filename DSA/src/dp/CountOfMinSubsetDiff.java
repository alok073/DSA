package dp;

/**
 * Q8) Given an array and int diff, find the count of subsets whose difference is equal to diff
 * i/p: array = {1,1,2,3}
 * 		diff = 1
 * o/p: 3
 * 
 * -->
 * 1. {1,3} & {1,2} = 4-3 = 1
 * 2. {1,3} & {1,2} = 4-3 = 1
 * 3. {1,1,2} & {3} = 4-3 = 1
 * 
 * @author alok
 *
 */

public class CountOfMinSubsetDiff {

	public static void main(String[] args) {
		int array[] = new int[] {1,1,2,3};
		int diff = 1;
		int n = array.length;
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + array[i];
		}
		
		int numberOfSubsetsWithGivenDiff = countOfMinSubsetSumDiff(array, sum, diff, n);
		System.out.println("Number of subset sum with given difference = " + numberOfSubsetsWithGivenDiff);
	}
	
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
