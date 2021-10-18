package heaps;

/**
 * Given an unsorted array, int k, int x; print K closest numbers to 'x' present in the array
 * i/p: array = {10, 2, 14, 4, 7, 6};
		k = 3;
		x = 5;
 * o/p: {4, 7, 6}
 * 
 * @author alok
 *
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class KClosestUsingHashing {

	public static void main(String[] args) {
		int array[] = new int[] {10, 2, 14, 4, 7, 6};
		int k = 3;
		int x = 5;
		
		solve(array, x, k);
	}
	
	
	public static void solve(int[] A, int x, int k) {
	  TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
	  for(int i=0;i<A.length;i++) {
		  
		  int diff = Math.abs(x - A[i]);
		  if(map.containsKey(diff)) {
		  	ArrayList<Integer> temp = map.get(diff);
		  	temp.add(A[i]);
		  }
		  else {
		  	ArrayList<Integer> temp = new ArrayList<Integer>();
		  	temp.add(A[i]);
		  	map.put(diff, temp);
		  }
	  }
	  
	  int cnt = 0;
	  for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
		  
		  int key = entry.getKey();
		  ArrayList<Integer> list = entry.getValue();
		  //System.out.println("key = " + key + " values = " + list.toString());
		  for(int i : list) {
		  	if(cnt == k) return;
		  	System.out.print(i + " ");
		  	cnt++;
		  }
	  }

}

}
