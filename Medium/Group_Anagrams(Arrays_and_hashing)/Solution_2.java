// This solution is based on the idea that if t is an anagram of s, the occurrence of each character on t and s is both the same
// Therefore, we use a string containing the count of each character of a string as a key our hashmap
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i]);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }
        return new ArrayList(map.values());
        // let n be the length of the array and k be the maximum length of a string in strs
        // Time Complexity: O(nk) - the outer forloop is O(n) as we are iterating through the array and the first inner forloop iterates through each character of a string. 
        // Space Complexity: O(nk + nA) = O(nk) - A is the size of the count array (26, total number of english alphabets)

    }
}
