package dp;

/**
 * Q21] Given a string, find the length of the longest pallindromic sub-sequence(LPS)
 * i/p: a = "agbcba"
 * o/p: 5 
 * 
 * -->
 * LPS = "abcba"
 * 
 * @author alok
 *
 */

public class LPS {

	public static void main(String[] args) {
		String a = "agbcba";
		String b = reverseString(a);
		
		int lengthOfLPS = lpsLength(a, b, a.length(), b.length());
		System.out.println("Length of longest pallindromic sub-sequence is = " + lengthOfLPS);
	}
	
	/**
	 * Exact code of LCS... string 'y' is reverse of string 'x'
	 * @param x
	 * @param y
	 * @param n
	 * @param m
	 * @return Integer
	 */
	static int lpsLength(String x, String y, int n, int m) {
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
	
	static String reverseString(String s) {
		StringBuffer str = new StringBuffer(s);
		return str.reverse().toString();
	}

}
