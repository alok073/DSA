package recursion.examples;

/**
 * Q) Given an array and it's length....print it's element recursively both in given order as well as reverse order
 * @author alok
 */

public class PrintArray {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5};
		printArray(array, 5);
		System.out.println("");
		printReverseArray(array, 5);
	}
	
	public static void printArray(int[] array, int n) {
		if(n == 0) {
			return;
		}
		
		printArray(array, n-1);
		System.out.print(array[n-1] + " ");
	}
	
	public static void printReverseArray(int[] array, int n) {
		if(n == 0) {
			return;
		}
		
		System.out.print(array[n-1] + " ");
		printReverseArray(array, n-1);
	}

}
