package dp;

/**
 * Q1) 0-1 Knapsack recursive solution
 * 
 * @author alok
 *
 */

public class KnapsackRecursive {

	public static void main(String[] args) {
		int val[] = new int[] { 4, 5, 3, 7 };
		int weight[] = new int[] { 2, 3, 1, 4 };
		int W = 5;
		int n = val.length;
		
		int maxProfit = knapsack01(val, weight, W, n); 
		System.out.println("Max profit is = " + maxProfit);
	}
	
	static int knapsack01(int val[], int wt[], int w, int n) {
		if(w==0 || n==0) {
			return 0;
		}
		
		if(wt[n-1] <= w) {
			return Math.max(val[n-1] + knapsack01(val, wt, w-wt[n-1], n-1), knapsack01(val, wt, w, n-1));
		}
		else {
			return knapsack01(val, wt, w, n-1);
		}
	}

}
