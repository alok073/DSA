package dp;

import java.util.Arrays;

/**
 * Q24]Given a string, find minimum number of partitions in a string such that each partitioned string is a palindrome
 * i/p: String s = "geek"
 * o/p: 2
 * 
 * -->
 * "geek" -> "g" , "ee", "k"
 * 2 partitions, 3 pallindromic sub-strings
 * 
 * @author alok
 *
 */

public class PalindromPartioning {
	static int dp[][] = new int[501][501];

	public static void main(String[] args) {
		String s = "geek";
		int n = s.length();
		
		//initialize DP matrix
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		//int partitions = partitioningRecursive(s, 0, n-1);
		//int partitions = partitioningMemoized(s, 0, n-1);
		int partitions = partitioningMoreOptimized(s, 0, n-1);
		System.out.println(partitions);
	}
	
	/**
	 * - if i>=j return 0.... bcoz a String of length=1 is a pallindrome. Hence 0 partitions
	 * - check if s(i,j) subString is a pallindrome. If it is return 0
	 * - iterate k from 1 to j-1
	 * 		- tempAns = (i,k) + (k+1, j) + 1 (extra +1 bcoz we've already made a partition)
	 * 		- ans = min(Ans, tempAns)
	 * - return ans
	 * 
	 * @param String s
	 * @param index i
	 * @param index j
	 * @return Integer minPartitions
	 */
	static int partitioningRecursive(String s, int i, int j) {
		if(i >= j) return 0;
		if(checkPalindrome(s, i, j)) {
			return 0;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns = partitioningRecursive(s, i, k) + partitioningRecursive(s, k+1, j) + 1;
			
			ans = Math.min(tempAns, ans);
		}
		
		return ans;
	}
	
	
	static int partitioningMemoized(String s, int i, int j) {
		if(i >= j) return 0;
		if(checkPalindrome(s, i, j)) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns = partitioningMemoized(s, i, k) + partitioningMemoized(s, k+1, j) + 1;
			
			ans = Math.min(tempAns, ans);
		}
		
		return dp[i][j] = ans;
	}
	
	static int partitioningMoreOptimized(String s, int i, int j) {
		if(i >= j) return 0;
		if(checkPalindrome(s, i, j)) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int left = 0;
			if(dp[i][k] != -1) left = dp[i][k];
			else left = partitioningMemoized(s, i, k);
			
			int right = 0;
			if(dp[k+1][j] != -1) right = dp[k+1][j];
			else right = partitioningMemoized(s, k+1, j);
			
			int tempAns = left + right + 1;
			
			ans = Math.min(tempAns, ans);
		}
		
		return dp[i][j] = ans;
	}
	
	static boolean checkPalindrome(String s, int i, int j) {
		String s1 = s.substring(i,j+1);
		StringBuilder str = new StringBuilder(s1);
		String s2 = str.reverse().toString();
		if(!s1.equalsIgnoreCase(s2)) {
			return false;
		}
		
		return true;
	}

}
