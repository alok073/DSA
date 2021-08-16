package dp;

/**
 * Q13) Given 2 strings, find the length of the largest common subsequence
 * i/p: x = "abcdgh", y = "abedfhr"
 * o/p: 4
 * 
 * -->
 * lcs = "abdh"
 * 
 * @author alok
 *
 */

public class LCSrecursive {

	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		
		int lcs = lcsRecursive(x, y, x.length(), y.length());
		System.out.println("Length of Longest common subsequence = " + lcs);
	}
	
	static int lcsRecursive(String x, String y, int n, int m) {
		//base condition
		if(n == 0 || m == 0) {
			return 0;
		}
		
		//choice diagram
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return 1 + lcsRecursive(x, y, n-1, m-1);
		}
		else {
			return Math.max(lcsRecursive(x, y, n-1, m), lcsRecursive(x, y, n, m-1));
		}
	}

}
