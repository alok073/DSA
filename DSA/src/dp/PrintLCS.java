package dp;

/**
 * Q17] Given 2 strings, print the longest common sub-sequence string
 * i/p: s1 = "abcdgh"
 * 		s2 = "abedfhr"
 * o/p: "abdh"
 * 
 * @author alok
 *
 */

public class PrintLCS {

	public static void main(String[] args) {
//		String x = "abcdgh";
//		String y = "abedfhr";
		
		String x = "aggtab";
		String y = "gxtxayb";
		
		int lcsDpMatrix[][] = lcsDp(x, y, x.length(), y.length());
		
		String lcsString = printLCS(lcsDpMatrix, x, y, x.length(), y.length());
		System.out.println("LCS string = " + lcsString); 
	}
	
	static int[][] lcsDp(String x, String y, int n, int m) {
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
		
		return dp;
	}
	
	/**
	 * - If x[i-1] == y[j-1]...add the char to ans string..... then move diagonally up by 1 step
	 * - else... find max(dp[i-1], dp[j-1]) and move to that place
	 * 
	 * @param dp
	 * @param x
	 * @param y
	 * @param n
	 * @param m
	 * @return String
	 */
	static String printLCS(int[][] dp, String x, String y, int n, int m) {
		StringBuilder str = new StringBuilder("");
		int i=n, j=m;
		while(i > 0 && j > 0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				str.append(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(dp[i][j-1] > dp[i-1][j]) {
					j--;
				}
				else {
					i--;
				}
			}
		}
		String ans = str.reverse().toString();
		
		return ans;
	}

}
