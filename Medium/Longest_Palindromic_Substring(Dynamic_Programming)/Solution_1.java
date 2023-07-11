// This solution uses brute-force to get all the possible substrings and check if they are palindromes or not and then get the longest one from those that are palindromes
// Time limit exceeds on Leetcode so it is not optimal
public class Solution_1 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int longest = 0;
        String result = "" + s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i > longest) {
                        longest = j - i;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // Time Complexity: O(n^3) - isPalindrome takes O(n) time in the worst case. And it is in a double forloop that interates through the whole string.
    // So the over all time complexity is n^2 * n = O(n^3)
    // Space Complexity: O(1) because we are only using constant extra space
    // We don't usually include the output (result) in our space complexity analysis 
}
