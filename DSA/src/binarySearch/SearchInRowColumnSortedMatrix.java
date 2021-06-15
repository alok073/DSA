package binarySearch;

/**
 * Q) Given a 2D matrix whose every column and row is sorted in asc order, find the index of the target element
 * 
 * @author alok
 *
 */
public class SearchInRowColumnSortedMatrix {

	public static void main(String[] args) {
		int matrix[][] = { { 10, 20, 30, 40 },
                		   { 15, 25, 35, 45 },
                		   { 27, 29, 37, 48 },
                		   { 32, 33, 39, 50 } 
                	     };
		
		int searchIndex[] = searchTarget(matrix, 4, 29);
		if(searchIndex == null) {
			System.out.println("Target element not found");
		}
		else {
			System.out.println("Target element found at " + searchIndex[0] + " , " + searchIndex[1]);
		}
		
	}
	
	/**
	 * - assign i=0, j=m-1
	 * - while i<n and j>=0
	 * 		- midE = A[i][j]
	 * 		- if midE equals target....return i,j
	 * 		- else if target > midE...i++
	 * 		- else j--
	 * 
	 * Time = O(n+m)
	 * Space = O(1)
	 * 
	 * @param matrix
	 * @param size
	 * @param target
	 * @return Integer index of target element
	 */
	public static int[] searchTarget(int[][] matrix, int size, int target) {
		int n = size, m = size;
		int i = 0, j = m-1;
		int ans[] = new int[2];
		while(i<n && j>=0) {
			int midElement = matrix[i][j];
			if(target == midElement) {
				ans[0] = i;
				ans[1] = j;
				return ans;
			}
			else if(target > midElement) {
				i++;
			}
			else {
				j--;
			}
		}
		return null;
	}

}
