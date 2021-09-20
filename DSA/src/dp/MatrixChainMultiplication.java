package dp;

import java.util.Arrays;

/**
 * Q23] Matrix chain multiplication
 * i/p: int[] = {40, 20, 30, 10, 30}
 * o/p: 26000
 * 
 * @author alok
 *
 */

public class MatrixChainMultiplication {
	static int dp[][] = new int[101][101];
	
	public static void main(String[] args) {
		int array[] = new int[] {40, 20, 30, 10, 30};
		int n = 5;
		
		//initialize DP matrix
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		//int matrixProduct = mcmRecursive(array, 1, n-1);
		//int matrixProduct = mcmMemoized(array, 1, n-1);
		int matrixProduct = mcmMoreOptimized(array, 1, n-1);
		System.out.println(matrixProduct);
	}
	
	static int mcmRecursive(int array[], int i, int j) {
		if(i >= j) {
			return 0;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns = mcmRecursive(array, i, k) + mcmRecursive(array, k+1, j) + array[i-1]*array[k]*array[j];
			
			ans = Math.min(ans,  tempAns);
		}
		
		return ans;
	}
	
	static int mcmMemoized(int array[], int i, int j) {
		if(i >= j) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns = mcmRecursive(array, i, k) + mcmRecursive(array, k+1, j) + array[i-1]*array[k]*array[j];
			
			ans = Math.min(ans,  tempAns);
		}
		
		return dp[i][j] = ans;
	}
	
	static int mcmMoreOptimized(int array[], int i, int j) {
		if(i >= j) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int left = 0;
			if(dp[i][k] != -1) left = dp[i][k];
			else left = mcmRecursive(array, i, k);
			
			int right = 0;
			if(dp[k+1][j] != -1) right = dp[k+1][j];
			else right = mcmRecursive(array, k+1, j);
			
			int tempAns = left + right + array[i-1]*array[k]*array[j];
			
			ans = Math.min(ans,  tempAns);
		}
		
		return dp[i][j] = ans;
	}
	

}


