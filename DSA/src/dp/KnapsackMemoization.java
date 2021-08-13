package dp;

import java.util.Arrays;

/**
 * Q2) 0-1 knapsack memoized 
 * 
 * @author alok
 *
 */

public class KnapsackMemoization {
	
	static int dp[][] = new int[101][1001];

	public static void main(String[] args) {
		//initialize with -1
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		int val[] = new int[] { 4, 5, 3, 7 };
		int weight[] = new int[] { 2, 3, 1, 4 };
		int W = 5;
		int n = val.length;
		
		int maxProfit = knapsack01(val, weight, W, n); 
		System.out.println("Max profit is = " + maxProfit);
	}
	
	static int knapsack01(int val[], int wt[], int w, int n) {
		//base condition
		if(w==0 || n==0) {
			return 0;
		}
		
		//memoization
		if(dp[n][w] != -1) {
			return dp[n][w];
		}
		
		//choice diagram
		if(wt[n-1] <= w) {
			return dp[n][w] = Math.max(val[n-1] + knapsack01(val, wt, w-wt[n-1], n-1), knapsack01(val, wt, w, n-1));
		}
		else {
			return knapsack01(val, wt, w, n-1);
		}
	}

}
