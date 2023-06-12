// This file solves Question 438 (Find All Anagrams in a String) from leetcode using the sliding window approach

import java.util.*;
public class allAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || p.length() > s.length()) {
            return ans;
        }
        
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int counter = map.size();
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    counter --;
                }
            }
            end++;
            while (counter == 0) {
                if (end - start == p.length()) {
                    ans.add(start);
                }
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        counter ++;
                    }
                }
                start++;

            }

        }
        return ans;
    }
    // Let n be the length of the String s and m be the length of the String p
    // Time Complexity: O(n + m) - the first for loop has a run time of O(m). The outer while loop iterates through the characters of the string s 
    // The nested while loop also iterates through the characters of string s, but it only runs when the counter is zero, which happens when an anagram is found. 
    // In the worst case, this nested while loop will also iterate through all the characters exactly once. 
    // Therefore, the overall time complexity of the nested while loop is O(n).
    
    // Space Complexity: O(m) because of the hashmap
}
