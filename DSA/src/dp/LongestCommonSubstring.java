package dp;

/**
 * Q16) Given 2 strings, find the length of the largest common subString
 * i/p: x = "wbedgh"
 * 		y = "abedfhr"
 * o/p: 3
 * 
 * -->
 * longest common subString = "bed"
 * 
 * @author alok
 *
 */

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String x = "wbedgh";
		String y = "abedfhr";
		
		//int maxm = longestCommonSubstringRecursive(x, y, x.length(), y.length(), 0);
		int maxm = longestCommonSubstringDP(x, y, x.length(), y.length());
		System.out.println("The length of the longest common substring is = " + maxm);
	}
	
	/**
	 * Whenever the characters are not same, initialize count(length of lcSubstring) as 0)
	 * 
	 * @param x
	 * @param y
	 * @param n
	 * @param m
	 * @param count
	 * @return Integer
	 */
	static int longestCommonSubstringRecursive(String x, String y, int n, int m, int count) {
		if(n == 0 || m == 0) {
			return count;
		}
		
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return longestCommonSubstringRecursive(x, y, n-1, m-1, count+1);
		}
		else {
			return Math.max(count, Math.max(longestCommonSubstringRecursive(x, y, n-1, m, 0), longestCommonSubstringRecursive(x, y, n, m-1, 0)));
		}
	}
	
	
	static int longestCommonSubstringDP(String x, String y, int n, int m) {
		int dp[][] = new int[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 || j == 0) dp[i][j] = 0;
			}
		}
		
		int result = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					result = Math.max(result, dp[i][j]);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		
		return result;
	}

}
