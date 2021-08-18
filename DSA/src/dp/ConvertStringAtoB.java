package dp;

/**
 * Q20] Given 2 strings a & b, find min no. of characters to be inserted & deleted to make String A -> B
 * i/p: a = "heap"
 * 		b = "pea"
 * o/p: minInsertions = 1 {'p'}
 * 		minDeletions = 2 {'h', 'p'}
 * 
 * @author alok
 *
 */

public class ConvertStringAtoB {

	public static void main(String[] args) {
		String a = "heap";
		String b = "pea";
		
		int lengthOfLCS = lcsLength(a, b, a.length(), b.length());
		int minInsertions = b.length() - lengthOfLCS;
		int minDeletions = a.length() - lengthOfLCS;
		
		System.out.println("The min no. of Insertions = " + minInsertions + " & min no. of Deletions = " + minDeletions);
	}
	

	static int lcsLength(String x, String y, int n, int m) {
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
