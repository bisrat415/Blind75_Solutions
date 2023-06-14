// This is a brute-force solution

import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        int  maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (validWindow(s, i, j)) {
                    maxLength = Math.max(j - i + 1, maxLength);
                } else {
                    break;
                }
                
            }
        }
        return maxLength;
    }

    public static boolean validWindow(String s, int i, int j) {
        HashSet<Character> seen = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (seen.contains(s.charAt(k))) {
                return false;
            }
            seen.add(s.charAt(k));
        }
        return true;
    }
    // Time Complexity: O(n^3) - the outer forloop takes O(n) and the inner loop also takes O(n) time. 
    // The validWindow function is called within the inner loop and has a time complexity of O(k), where k is the length of the substring being checked. 
    // Since the length of each substring can range from 1 to n, the worst-case time complexity for validWindow is O(n). So overall the time complexity is O(n^3)
    // Space Complexity: O(n) because of the hashset in the helper method, validWindow
 
}
