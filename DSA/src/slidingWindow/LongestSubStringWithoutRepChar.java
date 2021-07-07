package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q8) Given a string, find the length of the longest subString that has only unique characters
 * e.g: s = "GEEKSFORGEEKS"
 * o/p: 7 i.e "KSFORGE"
 * 
 * @author alok
 *
 */

public class LongestSubStringWithoutRepChar {

	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		
		int maxSubString = lengthOfLongestSubStringWithoutRepeatingChar(s);
		System.out.println("Size of longest subArray with K unique characters is = " + maxSubString);
	}
	
	/**
	 * - maintain a hashMap which will store characters and their count
	 * - i=0, j=0, notUnique=0 // notUnique -> this indicates no. of characters that are not unique.... if notUnique=0 then it means all char are unique
	 * - check if s[j] is present in hashMap
	 * 		- yes
	 * 			- increment its value
	 * 			- check if its count/value > 1 then increment notUnique by 1
	 * 		- no
	 * 			- insert s[i] in hashMap
	 * - check if notUnique == 0
	 * 		- ans = max(ans, j-i+1) ..j++
	 * - if notUnique > 0
	 * 		- while notUnique > 0
	 * 			- decrement count of s[i] by 1
	 * 			- if prevCount of s[i] was >1 && currentCount is equal to 1....then...notUnique--
	 * 			- i++
	 * 		- j++
	 * 
	 * Time = O(n)
	 * Space = O(n)
	 * 
	 * @param s
	 * @return Integer length of longest subString having no repetitive character
	 */
	public static int lengthOfLongestSubStringWithoutRepeatingChar(String s) {
		int ans = 0;
		int i=0, j=0;
		int size = s.length();
		Map<Character, Integer> hashMap = new HashMap<Character, Integer> ();
		int notUnique = 0;
		
		while(j < size) {
			//calculations
			char c = s.charAt(j);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)+1);
				if(hashMap.get(c) > 1) {
					notUnique++;
				}
			}
			else {
				hashMap.put(c, 1);
			}
			
			if(notUnique == 0) {
				ans = Math.max(ans, j-i+1);
				j++;
			}
			
			if(notUnique > 0) {
				while(notUnique > 0) {
					int prevCount = hashMap.get(s.charAt(i));
					hashMap.put(s.charAt(i), prevCount-1);
					if(prevCount > 1 && hashMap.get(s.charAt(i))==1) {
						notUnique--;
					}
					if(hashMap.get(s.charAt(i)) == 0) {
						hashMap.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			}
			//System.out.println(hashMap + " " + i + " " + j + " " + notUnique + " " + ans);
		}
		
		return ans;
	}

}
