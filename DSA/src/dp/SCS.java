package dp;

/**
 * Q18] Given 2 strings, print the length of the shortest common super-sequence(SCS)
 * i/p: x = "aggtab"
 * 		y = "gxtxayb"
 * o/p: 9
 * 
 * -->
 * SCS = "aggxtxayb"
 * length = 9
 * 
 * @author alok
 *
 */

public class SCS {

	public static void main(String[] args) {
		String x = "aggtab";
		String y = "gxtxayb";
		
		int lcsLength = lengthOfLCS(x, y, x.length(), y.length());
		int scsLength = lengthOfSCS(lcsLength, x.length(), y.length());
		
		System.out.println("Length of shortest common supersequence = " + scsLength);
	}
	
	static int lengthOfLCS(String x, String y, int n, int m) {
		int dp[][] = new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
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
	
	static int lengthOfSCS(int lcsLength, int n, int m) {
		return n + m - lcsLength;
	}

}
