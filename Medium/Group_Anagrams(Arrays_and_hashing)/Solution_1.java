// This solution is based on the logic that if t is an anagram of s, sorting both strings will result in two identical strings

import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            // we sort the string and use it as a key in our hashmap
            Arrays.sort(arr); 
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
        // let n be the length of the array, strs and k be the maximum length of a string in strs
        // Time Complexity: O(nklogk) - The outer loop is O(n) as we are iterating through the array and then we sort each string in O(klogk) time
        // Space Complexity: O(nk) which is the total data stored in the hashmap 
    }

    
}
