package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q9) John goes with his mom to buy toys from a mall. His mom tells him that he can have only 'K' types of toys and the toys should be placed next to each other in the 
 * 	   rack. John can buy as many toys he can but he should follow the 2 conditions given by his mother
 * A string is provided which refers to a rack in a mall and each character refers to as the type of a toy
 * 
 * I/p: s = "abaccab", k=2 
 * 		//here... in the string there are 3 types of toys namely {'a','b','c'} and k indicates the maxm type of toys that john can buy
 * O/P: 4 i.e "acca" //here john buys 4 toys of type {'a', 'c'}
 * 
 * @author alok
 *
 */

public class PickToys {

	public static void main(String[] args) {
		String toysArray = "abaccab";
		int maxTypesOfToys = 2;
		
		int totalToys = pickToys(toysArray, maxTypesOfToys);
		System.out.println("Total number of toys bought by john is = " + totalToys);
		
	}
	
	/**
	 * This is exactly similar LongestSubArrayWithKUniqueCharacters problem
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * @param s
	 * @param k
	 * @return Integer maximum number of toys of types 'k' bought by john
	 */
	public static int pickToys(String s, int k) {
		int ans = 0;
		int size = s.length();
		int i=0, j=0;
		Map<Character, Integer> hashMap = new HashMap<Character, Integer> ();
		int mapSize = 0;
		
		while(j < size) {
			//calculations
			char c = s.charAt(j);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) + 1);
			}
			else {
				hashMap.put(c, 1);
				mapSize++;
			}
			
			if(mapSize < k) {
				j++;
			}
			
			if(mapSize == k) {
				ans = Math.max(ans, j-i+1);
				j++;
			}
			
			if(mapSize > k) {
				while(mapSize > k) {
					hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))-1);
					if(hashMap.get(s.charAt(i)) == 0) {
						mapSize--;
						hashMap.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		
		return ans;
	}
	
	

}
