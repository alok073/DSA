package heaps;

import java.util.HashMap;

public class BooleanParenthization {
	static int dp[][][] = new int[201][201][2];
	//static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		//hashMap.clear();
		
		for(int i=0;i<201;i++) {
			for(int j=0;j<201;j++) {
				for(int k=0;k<2;k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		int totalWays = numberOfWays(s, 0, s.length()-1, 1);
		System.out.println("hello");
		System.out.println(totalWays); //4
	}
	
	public static int numberOfWays(String s, int i, int j, int trueOrFalse) {
		if(i > j) return 0;
		if(i == j) {
			if(trueOrFalse == 1) {
				if(s.charAt(i) == 'T') return 1;
				else return 0;
			}
			else if(trueOrFalse == 0) {
				if(s.charAt(i) == 'F') return 1;
				else return 0;
			}
		}
		
		//memoization
		if(dp[i][j][trueOrFalse] != -1) {
			return dp[i][j][trueOrFalse];
		}
		
		//HashMap based memoization
//		String temp = Integer.toString(i) + " " + Integer.toString(j) + " " + Integer.toString(trueOrFalse);
//		if(hashMap.containsKey(temp)) {
//			System.out.println("yes " + hashMap.get(temp));
//			return hashMap.get(temp);
//		}
		
		int sum = 0;
		for(int k=i+1; k<j; k=k+2) {
			int leftTrue = numberOfWays(s, i, k-1, 1);
			int leftFalse = numberOfWays(s, i, k-1, 0);
			int rightTrue = numberOfWays(s, k+1, j, 1);
			int rightFalse = numberOfWays(s, k+1, j, 0);
			
			if(s.charAt(k) == '|') {
				if(trueOrFalse == 1) {
					sum = sum + leftTrue*rightFalse + leftFalse*rightTrue + leftTrue*rightTrue;
				}
				else if(trueOrFalse == 0) {
					sum = sum + leftFalse*rightFalse;
				}
			}
			else if(s.charAt(k) == '&') {
				if(trueOrFalse == 1) {
					sum = sum + leftTrue*rightTrue;
				}
				else if(trueOrFalse == 0) {
					sum = sum + leftTrue*rightFalse + leftFalse*rightTrue + leftFalse*rightFalse;
				}
			}
			else if(s.charAt(k) == '^') {
				if(trueOrFalse == 1) {
					sum = sum + leftFalse*rightTrue + leftTrue*rightFalse;
				}
				else if(trueOrFalse == 0) {
					sum = sum + leftFalse*rightFalse + leftTrue*rightTrue;
				}
			}
			//System.out.println(sum);
			//hashMap.put(temp, sum);
		}
		//hashMap.put(temp, sum);
		return dp[i][j][trueOrFalse] = sum;
	}

}
