package dp;

/**
 * Q15) LCS bottom up DP code
 * 
 * @author alok
 *
 */

public class LCSbottomUpDp {

	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		
		int lcs = lcsBottomUpDp(x, y, x.length(), y.length());
		System.out.println("Length of Longest common subsequence = " + lcs);
	}
	
	static int lcsBottomUpDp(String x, String y, int n, int m) {
		int dp[][] = new int[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 || j == 0) dp[i][j] = 0;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[n][m];
	}

}
