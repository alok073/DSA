package dp;

/**
 * Q3) 0-1 knapsack iterative version
 * 
 * @author alok
 *
 */

public class knapsackBottomUp {

	public static void main(String[] args) {
		int val[] = new int[] { 4, 5, 3, 7 };
		int weight[] = new int[] { 2, 3, 1, 4 };
		int W = 5;
		int n = val.length;
		
		int maxProfit = knapsack01(val, weight, W, n); 
		System.out.println("Max profit is = " + maxProfit);
	}
	
	static int knapsack01(int val[], int wt[], int w, int n) {
		int dp[][] = new int[n+1][w+1];
		
		//Initialization
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=w; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
			}
		}
		
		//choice diagram
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=w; j++) {
				if(wt[i-1] <= j) {
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][w];
	}

}
