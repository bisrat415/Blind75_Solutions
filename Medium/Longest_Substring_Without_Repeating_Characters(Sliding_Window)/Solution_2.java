import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        boolean isDuplicate = false;
        while (right < s.length()) {
            if (seen.contains(s.charAt(right))) {
                isDuplicate = true;
            } else {
                seen.add(s.charAt(right));
            }
            
            while(isDuplicate) {
                maxLength = right - left > maxLength ? right - left : maxLength;
                if (s.charAt(left) == s.charAt(right)) {
                    isDuplicate = false;
                } else {
                    seen.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }

        return Math.max(right - left, maxLength);
        // Time Complexity: O(n) because each character in the string will be visited at most twice (once by the right pointer and once by the left)
        // Space Complexity: O(n) because of the hashmap (in the case where all characters in the String s are unique)
    }
}
