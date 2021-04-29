package recursion.examples;

/**
 * Q1) Given an int n...print 1 to n recursively
 * @author alok
 */

public class Print1ToN {

	public static void main(String[] args) {
		printIncreasing(5);
	}
	
	public static void printIncreasing(int n) {
		if(n == 0) {
			return;
		}
		
		printIncreasing(n-1);
		System.out.println(n);
	}

}
