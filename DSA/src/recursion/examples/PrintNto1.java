package recursion.examples;

/**
 * Q2) Given an int n....print n to 1 recursively
 * @author alok
 */

public class PrintNto1 {

	public static void main(String[] args) {
		printDecreasing(5);
	}
	
	public static void printDecreasing(int n) {
		if(n == 0) {
			return;
		}
		
		System.out.println(n);
		printDecreasing(n-1);
	}

}
