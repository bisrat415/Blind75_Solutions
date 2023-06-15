// This solution utilizes the sliding window approach to find a valid window and trim it to the possible lowest length
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int charCount = map.size();
        int minLength = Integer.MAX_VALUE;
        String result = "";
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    charCount--;
                }
            }
            while (charCount == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        charCount++;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
        // Let n be the length of s and m be the the length of t
        // And let k be the number of unique characters in t
        // Time Complexity: O(n + m) because we pass through t once to add to the hashmap (O(m)) and we pass through each character in s at most twice (once with the right pointer and once with the left) (O(n))
        // Space Complexity: O(k) because of the hashmap
    }

}
