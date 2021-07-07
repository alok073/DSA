package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q7) Given a String and int K, find the length of the longest subArray which has 'K' unique characters
 * e.g: s = "aabacebebebe" , k=3
 * o/p: 8 i.e "cebebebe"
 * 
 * @author alok
 *
 */

public class LongestSubArrayWithKUnique {

	public static void main(String[] args) {
		String s = "aabacebebebe";
		int k = 3;
		
		int maxSize = findLongestSubArrayWithKUniqueCharacters(s, k); //8 "cebebebe"
		if(maxSize == 0) {
			System.out.println("No subArray found with k unique characters");
		}
		else {
			System.out.println("Size of longest subArray with K unique characters is = " + maxSize);
		}
	}
	
	/**
	 * Variable size sliding window
	 * - maintain a hashMap that will store characters and their count of occurrences
	 * - i=0, j=0, mapSize=0 //mapSize -> this will tell number of unique entries in hashMap
	 * - check if s[j] is present in hashMap....yes? increase its count by 1....no? insert in hashMap and increment mapSize by 1
	 * - if mapSize < k....j++
	 * - if mapSize == k.... ans = max(ans, j-i+1) // j-i+1 = windowSize
	 * - if mapSize > k...
	 * 		- //now we need to start removing chars from i until mapSize<=k
	 * 		- reduce count of s[i] from hashMap by 1
	 * 		- check if count of s[i] == 0 in hashMap....yes? decrement mapSize by 1 & remove s[i] from hashMap
	 * 		- i++
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * @param s
	 * @param k
	 * @return Integer size of longest subArray with K unique characters
	 */
	public static int findLongestSubArrayWithKUniqueCharacters(String s, int k) {
		int ans = 0;
		int i=0, j=0;
		int size = s.length();
		Map<Character, Integer> hashMap = new HashMap<Character, Integer> ();
		int mapSize = 0;
		
		while(j < size) {
			//calculations
			char c = s.charAt(j);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)+1);
			}
			else {
				hashMap.put(c, 1);
				mapSize++;
			}
			
			// <k
			if(mapSize < k) {
				j++;
			}
			
			// ==k
			if(mapSize == k) {
				ans = Math.max(ans, j-i+1);
				j++;
			}
			
			// >k
			if(mapSize > k) {
				while(mapSize > k) {
					hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))-1);
					if(hashMap.get(s.charAt(i)) == 0) {
						hashMap.remove(s.charAt(i));
						mapSize--;
					}
					i++;
				}
				j++;
			}
			//System.out.println(hashMap + " " + i + " " + j + " " + mapSize + " " + ans);
		}
		return ans;
	}

}
