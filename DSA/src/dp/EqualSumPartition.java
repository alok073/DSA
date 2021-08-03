package dp;

/**
 * Q5) Given an array, check if the array can be partitioned into 2 subsets of equal sum?
 * 
 * @author alok
 *
 */

public class EqualSumPartition {

	public static void main(String[] args) {
		int array[] = new int[] {1, 5, 11, 5};
		int  n = array.length;
		int arraySum = calculateSum(array, n);
		if(arraySum%2 != 0) {
			System.out.println("Can the array be equally partitioned? false");
		}
		else {
			boolean subsetPresent = findSubsetIterative(array, arraySum/2, n);
			System.out.println("Can the array be equally partitioned? " + subsetPresent);
		}
	}
	
	static boolean findSubsetIterative(int[] array, int sum, int n) {
		boolean dp1[][] = new boolean[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j == 0) dp1[i][j] = true;
				if(i == 0 && j != 0) dp1[i][j] = false;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(array[i-1] <= j) {
					dp1[i][j] = dp1[i-1][j-array[i-1]] || dp1[i-1][j];
				}
				else dp1[i][j] = dp1[i-1][j];
			}
		}
		
		return dp1[n][sum];
	}
	
	static int calculateSum(int[] array, int n) {
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum = sum + array[i];
		}
		return sum;
	}

}
