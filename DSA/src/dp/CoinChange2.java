package dp;

import java.util.Arrays;

/**
 * Q12) Given an array denoting values of coins available and a target change to reach, find minm no. of coins to make the target change if the supply of coins is unlimited
 * i/p: array = {1,2,3}
 * 		targetSum = 4
 * o/p: 2 coins
 * 
 * -->
 * {2,2} = 2 coins
 * {1,1,2} = 3 coins
 * {1,3} = 2 coins
 * {1,1,1,1} = 4 coins
 * 
 * @author alok
 */

public class CoinChange2 {
	
	private static int dp[][] = new int[101][10001];

	public static void main(String[] args) {
		//long startTimeMilliSecond = System.currentTimeMillis();
		for(int i=0; i<=101; i++) {
			for(int[] row: dp) {
				Arrays.fill(row, -1);
			}
		}
		
		int array[] = {2,5,3,6};
		int targetSum = 10;
		int n = array.length;
		
		int minNumberOfCoins = coinChangeTwoRecursive(array, targetSum, n, 0);
		System.out.println("Minimum number of coins = " + minNumberOfCoins);
		
		
		//long endTimeMilliSecond = System.currentTimeMillis();
		//System.out.println("Time Taken is "+(endTimeMilliSecond - startTimeMilliSecond) + " ms");
		
	}
	
	static int coinChangeTwoRecursive(int[] array, int sum, int n, int count) {
		if(sum == 0) {
			return count;
		}
		if(n == 0) return Integer.MAX_VALUE;
		
		if(dp[n][sum] != -1) {
			return dp[n][sum];
		}
		
		if(array[n-1] <= sum) {
			return dp[n][sum] = Math.min(coinChangeTwoRecursive(array, sum-array[n-1], n, count+1), coinChangeTwoRecursive(array, sum, n-1, count));
		}
		else {
			return coinChangeTwoRecursive(array, sum, n-1, count);
		}
	}

}
