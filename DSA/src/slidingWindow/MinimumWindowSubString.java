package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q10) Given 2 strings 's' and 'pattern', find a minimum subString in 's' that atleast contains all the chars in 'pattern'
 * NOTE -> the substring should contain all the chars present in 'pattern' and the quantity of each chars should be either equal to that present in 'pattern' or more than that
 * 		   & the order of the chars is not important, just that all chars should be present
 * 
 * e.g: s = geeksforgeeks", patter = "ork"
 * o/p: "ksfor"
 * 
 * @author alok
 *
 */

public class MinimumWindowSubString {

	public static void main(String[] args) {
		String s = "this is a test string";
		String pattern = "tist";
		
		String minSubString = minimumWindowSubString(s, pattern);
		if(minSubString.equalsIgnoreCase("-1")) {
			System.out.println("No subString found in String 's' that contained all characters of String 'pattern'");
		}
		else {
			System.out.println("Minimum window SubString is = '" + minSubString + "'");
		}
	}
	
	public static String minimumWindowSubString(String s, String pattern) {
		Map<Character, Integer> hashMap = new HashMap<Character, Integer> ();
		int mapSize = 0;
		for(int a=0; a<pattern.length(); a++) {
			char c = pattern.charAt(a);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)+1);
			}
			else {
				hashMap.put(c, 1);
				mapSize++;
			}
		}
		
		int size = s.length();
		int i=0, j=0;
		int minWindow = Integer.MAX_VALUE, start = 0, end = 0;
		while(j < size) {
			char c = s.charAt(j);
			if(hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)-1);
				if(hashMap.get(c) == 0) {
					mapSize--;
				}
			}
			
			if(mapSize == 0) {
				while(mapSize == 0) {
					if(minWindow > (j-i+1)) {
						minWindow = Math.min(minWindow, j-i+1);
						start = i;
						end = j;
					}
					
					if(hashMap.containsKey(s.charAt(i))) {
						hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))+1);
						if(hashMap.get(s.charAt(i)) > 0) {
							mapSize++;
						}
					}
					i++;
				}
			}
			
			j++;
		}
		
		if(minWindow == Integer.MAX_VALUE) {
			return "-1";
		}
		else {
			return s.substring(start, end);
		}
	}

}
