package recursion.examples;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("5th element of fibonacci = " + fibonacci(5));
	}
	
	public static int fibonacci(int n) {
		if(n <= 1) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
