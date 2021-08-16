package dp;

import java.util.Arrays;

/**
 * Q14) LCS memoized code
 * 
 * @author alok
 *
 */

public class LCSmemoized {
	
	private static int dp[][] = new int[1001][1001];

	public static void main(String[] args) {
		for(int i=0; i<1001; i++) {
			for(int[] row : dp) {
				Arrays.fill(row, -1);
			}
		}
		
		String x = "abcdgh";
		String y = "abedfhr";
		
		int lcs = lcsMemoized(x, y, x.length(), y.length());
		System.out.println("Length of Longest common subsequence = " + lcs);

	}
	
	static int lcsMemoized(String x, String y, int n, int m) {
		if(n == 0 || m == 0) {
			return 0;
		}
		
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return dp[n][m] = 1 + lcsMemoized(x, y, n-1, m-1);
		}
		else {
			return dp[n][m] = Math.max(lcsMemoized(x, y, n-1, m), lcsMemoized(x, y, n, m-1));
		}
	}

}
