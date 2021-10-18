package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KClosestUsingPairClass {

	public static void main(String[] args) {
		int array[] = new int[] {10, 2, 14, 4, 7, 6};
		int k = 3;
		int x = 5;
		
		ArrayList<Integer> ans = kClosestNumbersLambda(array, k, x);
		for(int i : ans) {
			System.out.println(i);
		}

	}
	
	//using Comparator
	static ArrayList<Integer> kClosestNumbers(int[] array, int k, int x) {		
		MaxHeapComparator comp = new MaxHeapComparator();
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(comp);
		
		for(int i=0; i<array.length; i++) {
			maxHeap.add(new Pair(Math.abs(x-array[i]), array[i]));
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(!maxHeap.isEmpty()) {
			ans.add(maxHeap.poll().value);
		}
		
		return ans;
	}
	
	//using lambda expression
	static ArrayList<Integer> kClosestNumbersLambda(int[] array, int k, int x) {		
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((p1,p2) -> p2.key-p1.key);
		
		for(int i=0; i<array.length; i++) {
			maxHeap.add(new Pair(Math.abs(x-array[i]), array[i]));
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(!maxHeap.isEmpty()) {
			ans.add(maxHeap.poll().value);
		}
		
		return ans;
	}

}

class Pair {
	int key, value;
	
	public Pair(int key, int value) {
		this.key= key;
		this.value = value;
	}
}

class MaxHeapComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair p1, Pair p2) {
		if(p1.key > p2.key) return -1;
		if(p1.key < p2.key) return 1;
		return 0;
	}
	
}
