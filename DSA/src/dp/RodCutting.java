package dp;

/**
 * Q10) Given a rod of length n and two arrays namely length which contains values from 1 to n & price which contains price of each piece. Find the maxm profit by cutting
 *      the rod into pieces and selling those pieces against the prices given.
 * i/p: length = {1,2,3,4,5,6,7,8}
 * 		price = {1,5,8,9,10,17,17,20}
 * 		rodLength = 8
 * o/p: 22
 * 
 * -->
 * cutting the rod into 2 pieces i.e 1st piece of length=6 and 2nd piece of length=2
 * total profit = 17 + 5 = 22
 * 
 * @author alok
 *
 */

public class RodCutting {

	public static void main(String[] args) {
		int length[] = {1,2,3,4,5,6,7,8};
		int price[] = {1,5,8,9,10,17,17,20};
		int rodLength = 8;
		int n = rodLength;
		
		//int maxProfit = rodCuttingRecursive(length, price, rodLength, n);
		int maxProfit = rodCuttingIterative(length, price, rodLength, n);
		System.out.println("Maxm profit by rod cutting is = " + maxProfit);
	}
	
	static int rodCuttingRecursive(int length[], int price[], int rodLength, int n) {
		if(rodLength == 0) return 0;
		if(n == 0) return 0;
		if(length[n-1] <= rodLength) {
			return Math.max(price[n-1] + rodCuttingRecursive(length, price, rodLength-length[n-1], n), rodCuttingRecursive(length, price, rodLength, n-1));
		}
		else {
			return rodCuttingRecursive(length, price, rodLength, n-1);
		}
	}
	
	/**
	 * Unbounded Knapsack
	 * 
	 * @param length
	 * @param price
	 * @param rodLength
	 * @param n
	 * @return int : Maxm profit on cutting a rod
	 */
	static int rodCuttingIterative(int length[], int price[], int rodLength, int n) {
		int dp[][] = new int[n+1][rodLength+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=rodLength; j++) {
				if(j == 0 || i == 0) dp[i][j] = 0; 
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=rodLength; j++) {
				if(length[i-1] <= j) {
					dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][rodLength];
	}

}
