package dp;

/**
 * Q19] Given 2 strings, print the shortest common super-sequence(SCS) string
 * i/p: x = "aggtab"
 * 		y = "gxtxayb"
 * o/p: "aggxtxayb"
 * 
 * @author alok
 *
 */

public class PrintSCS {

	public static void main(String[] args) {
		String x = "aggtab";
		String y = "gxtxayb";
		
		int lcsDpMatrix[][] = lcsDp(x, y, x.length(), y.length());
		for(int i=0; i<=x.length(); i++) {
			for(int j=0; j<=y.length(); j++) {
				System.out.print(lcsDpMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		String scsString = printSCS(lcsDpMatrix, x, y, x.length(), y.length());
		
		System.out.println("The shortest common super-sequence string  = " + scsString);
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
	
	
	static String printSCS(int[][] dp, String x, String y, int n, int m) {
		StringBuilder str = new StringBuilder("");
		int i=n, j=m;
		while(i > 0 && j > 0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				str.append(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(dp[i][j-1] >= dp[i-1][j]) {
					str.append(y.charAt(j-1));
					j--;
				}
				else {
					str.append(x.charAt(i-1));
					i--;
				}
			}
		}
		while(i>0) {
			str.append(x.charAt(i-1));
			i--;
		}
		while(j>0) {
			str.append(y.charAt(j-1));
			j--;
		}
		
		String ans = str.reverse().toString();
		
		return ans;
	}

}
