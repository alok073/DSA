package slidingWindow;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q3) Given a String text and another String word, count all the occurrences of anagrams of 'word' string in 'text' string
 * e.g: text="aabaabaa"; word="aaba"
 * o/p: 4 i.e {aaba, abaa, aaba, abaa}
 * 
 * @author alok
 *
 */

public class OccurrencesOfAnagrams {

	public static void main(String[] args) {
		String text = "aabaabaa"; //forxxorfxdofr
		String word = "aaba"; //for
		
		int count = countOcurrencesOfAnagram2(text, word);
		if(count == -1) {
			System.out.println("Invalid input");
		}
		else {
			System.out.println("Count of occurrence of anagrams is = " + count); //4
		}
	}
	
	/**
	 * Approach 1
	 * - until windowSize!=k....keep on adding the characters to a String s
	 * - Once windowSize==k...
	 * 		- sort String s & word...compare them
	 * 		- if equal...increment count
	 * 		- now remove the 1st char from string s and i++, j++
	 * 
	 * Time = O(n * klogk) //k = word.length()
	 * Space = O(1)
	 * 
	 * @param text
	 * @param word
	 * @return Integer count of all anagrams
	 */
	public static int countOcurrencesOfAnagram1(String text, String word) {
		int count = 0;
		int size = text.length();
		int i=0, j=0;
		int k = word.length();
		if(k > size) return -1;
		
		List<String> list = new ArrayList<String>();
		while(j < size) {
			list.add(text.substring(j, j+1));
			int windowSize = j-i+1;
			
			if(windowSize < k) {
				j++;
			}
			else {
				String s = String.join("", list);
				String s1 = sortString(s);
				String s2 = sortString(word);
				if(s1.equalsIgnoreCase(s2)) {
					count++;
				}
				list.remove(0);
				i++;
				j++;
			}
		}
		return count;
	}
	
	//forxxorfxdofr
	/**
	 * Approach 2
	 * - create a hashMap and insert all distinct char along with the value
	 * - mapSize is size of hashMap
	 * - while j < text.size
	 * 		- check if A[i] is present in hashMap...if yes....reduce its value by 1
	 * 		- also check if value of key=A[i] equal to 0...yes? then decrement mapSize by 1 
	 * 		- if windowSize < k then j++
	 * 		- else if windowSize == k
	 * 			- check if mapSize==0.... i.e all char are present in current window...hence cnt++ 
	 * 			- check if A[i] is present in hashMap...yes? increment its count...and...check if value of A[i]==1 then increment mapSize by 1
	 * 			- i++, j++
	 * 
	 * Time = O(k + n) =~ O(n) //k=word.length()
	 * Space = O(k)
	 * 
	 * @param text
	 * @param word
	 * @return Integer count of all anagrams
	 */
	public static int countOcurrencesOfAnagram2(String text, String word) {
		int cnt = 0;
		int size = text.length();
		int k = word.length();
		if(k > size) return -1;
		
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			int value = hashMap.containsKey(c) ? hashMap.get(c) : 0;
			hashMap.put(c, value+1);
		}
		
		int mapSize = hashMap.size();
		int i=0, j=0;
		while(j < size) {
			char c = text.charAt(j);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)-1);
				if(hashMap.get(c) == 0) {
					mapSize--;
				}
			}
			
			int windowSize = j-i+1;
			if(windowSize < k) {
				j++;
			}
			else if(windowSize == k) {
				if(mapSize == 0) {
					cnt++;
				}
				c = text.charAt(i);
				if(hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c)+1);
					if(hashMap.get(c) == 1) mapSize++;
				}
				i++; j++;
			}
		}
		return cnt;
	}
	
	private static String sortString(String s) {
		char array[] = s.toCharArray();
		Arrays.sort(array);
		
		return new String(array);
	}

}
