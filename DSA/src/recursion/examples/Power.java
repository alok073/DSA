package recursion.examples;

/**
 * Q) Calculate x^n recursively
 * =>
 * 1. O(n)
 * 2. O(log N)
 * -> e.g: - 2^4 = 2^2 * 2^2
 *         - 2^5 = 2 * 2^2 * 2^2
 * @author alok
 *
 */

public class Power {

	public static void main(String[] args) {
		System.out.println("2^3 = " + power(2,3));
		System.out.println("2^5 = " + powerInLogN(2, 5));
	}
	
	public static int power(int x, int n) {
		if(n == 0) {
			return 1;
		}
		
		return x * power(x, n-1);
	}
	
	public static int powerInLogN(int x, int n) {
		if(n == 0) {
			return 1;
		}
		
		if(n%2 == 0) {
			return powerInLogN(x, n/2) * powerInLogN(x, n/2);
		}
		else {
			return x * powerInLogN(x, n/2) * powerInLogN(x, n/2);
		}
	}

}
