// This solution follows the Sliding Window approach for each unique character in the String, s

import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));

    }
    public static int characterReplacement(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        int maxLength = 0;
        for (char ch : set) {
            int left = 0;
            int right = 0;
            int charCount = 0;
            while (right < s.length()) {
                if (s.charAt(right) == ch) {
                    charCount++;
                }
                while ((right - left + 1) - charCount > k) {
                    if (s.charAt(left) == ch) {
                        charCount--;
                    }
                    left++;
                }
                maxLength = Math.max(maxLength, (right - left + 1));
                right++;
            }
        }
        return maxLength;

        // Let n be the length of the String s and m be the number of unique chracters in the string
        // Time Complexity: O(n * m) - the outer forloop that goes through the hashset has O(m) runtime and the while loop is O(n) because each character in the string is visited at most twice (once by the right pointer and once by the left)
        // Space Complexity: O(m) because of the hashset that is used to store unique characters in s. 
        // Since there are only uppercase English letters in the string, m = 26
    }

}
