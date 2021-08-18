package dp;

/**
 * Q22] Given a string, find minimum no. of characters to be inserted & deleted to make the string pallindrome
 * i/p: s = "aebcbda"
 * o/p: 2
 * 
 * -->
 * minInsertions = 2 -> "adebcbeda" ... added characters {'d', 'e'}
 * minDeletions = 2 -> "abcba" ... removed characters {'d', 'e'}
 * 
 * @author alok
 *
 */

public class MakePallindrome {

	public static void main(String[] args) {
		String s = "aebcbda";
		String s1 = reverseString(s);
		
		int lengthOfLps = lpsLength(s, s1, s.length(), s1.length());
		int minInsertions = s.length() - lengthOfLps;
		int minDeletions = s.length() - lengthOfLps;
		System.out.println("Min no. Insertions & Deletions to make a string pallindrome is " + minInsertions + " & " + minDeletions + " resp.");
	}
	
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
