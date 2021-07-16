package heaps;

import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * Q8) Given a 2D array consisting of (x,y) points and int k, print k (x,y) points which are the closest to origin
 * i/p: {
 * 		  {3,3},
 * 		  {5,-1},
 * 		  {-2,4}
 * 		}
 * o/p: {
 * 		  {-2,4},
 * 		  {3,3}
 * 		}
 * 
 * Explanation:-
 * - {3,3} -> dist from this point to origin is sqrt( (3-0)^2 + (3-0)^2);
 * - {5,-1} -> dist from this point to origin is sqrt( (5-0)^2 + (-1-0)^2);
 * - {-2,4} -> dist from this point to origin is sqrt( (-2-0)^2 + (4-0)^2);
 * 
 * @author alok
 *
 */

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int array[][] ={{3,3}, {5,-1}, {-2,4}};
		int k = 2;
		
		printKClosestPointsToOrigin(array, k);
	}
	
	/**
	 * - create a maxHeap of pairs....store dist as key and i(row number) as value
	 * - insert entries to maxHeap....pop when size>k
	 * - print the points 
	 * 
	 * Time = O(n * log k)
	 * Space = O(n)
	 * 
	 * @param array
	 * @param k
	 */
	public static void printKClosestPointsToOrigin(int[][] array, int k) {
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer,Integer>>( (a,b) -> b.getKey() - a.getKey());
		int distSquare;
		for(int i=0; i<array.length; i++) {
			distSquare = 0;
			for(int j=0; j<array[0].length; j++) {
				distSquare = distSquare + array[i][j]*array[i][j];
			}
			maxHeap.add(new Pair<Integer, Integer>(distSquare, i));
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		int heapSize = maxHeap.size();
		for(int a=0; a<heapSize; a++) {
			Pair<Integer, Integer> pair = maxHeap.poll();
			int i = pair.getValue();
			System.out.println(array[i][0] + " " + array[i][1]);
		}
	}

}
