package recursion.examples;

/**
 * Q3) given an integer n...print n to 1 followed by 1 to n...inside a single recursive function
 * @author alok
 */

public class PrintDecreasingIncreasing {

	public static void main(String[] args) {
		printDecreasingIncreasing(3);
	}
	
	public static void printDecreasingIncreasing(int n) {
		if(n == 0) {
			return;
		}
		
		System.out.println(n);
		printDecreasingIncreasing(n-1);
		System.out.println(n);
	}

}
