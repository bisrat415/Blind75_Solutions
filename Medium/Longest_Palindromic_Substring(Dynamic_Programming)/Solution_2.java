// This solution starts from each character in the string and spreads out
public class Solution_2 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            int oddLength = expand(s, i, i);
            int spread = oddLength / 2;
            int currLeft = i - spread;
            int currRight = i + spread;
            if (currRight - currLeft > answer[1] - answer[0]) {
                answer[0] = currLeft;
                answer[1] = currRight;
            }
        }
        for (int i = 0; i < n; i++) {
            int evenLength = expand(s, i, i + 1);
            int spread = evenLength / 2;
            int currLeft = i - spread + 1;
            int currRight = i + spread;
            if (currRight - currLeft > answer[1] - answer[0]) {
                answer[0] = currLeft;
                answer[1] = currRight;
            }
        }
        int left = answer[0];
        int right = answer[1];
        return s.substring(left, right + 1); 
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    // Let n be the length of the string
    // Time Complexity: O(n^2) - in the worst case (all the characters are the same) the inner loop (in the expand methld) can run up to n times
    // Space Complexity: O(1) - we are only using constant extra space
}
