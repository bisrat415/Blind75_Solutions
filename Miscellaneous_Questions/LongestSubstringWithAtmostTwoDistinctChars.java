import java.util.*;
public class LongestSubstringWithAtmostTwoDistinctChars {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (!seen.containsKey(rightChar)) {
                seen.put(rightChar, 1);
            } else {
                seen.put(rightChar, seen.get(rightChar) + 1);
            }
            while (seen.size() > 2) {
                maxLength = right - left > maxLength ? right - left : maxLength;
                char leftChar = s.charAt(left);
                if (seen.containsKey(leftChar)) {
                    seen.put(leftChar, seen.get(leftChar) - 1);
                    if (seen.get(leftChar) == 0) {
                        seen.remove(leftChar);
                    }
                } 
                left++;
            }
            right++;
        }
        return Math.max(right - left, maxLength);
        // Let n be the length of the String s
        // Time Complexity: O(n) - In the worst case, each character in the string is visited twice (once by the right pointer and once by the left pointer). Therefore, the overall time complexity is linear
        // Space Complexity: O(1) because the hashmap will have at most 3 elements at once regardless of the size of the string 
    }
}