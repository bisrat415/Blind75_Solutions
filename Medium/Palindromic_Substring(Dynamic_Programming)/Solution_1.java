// This solution starts from each character in the string and spreads out
public class Solution_1 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            int oddCount = expand(s, i, i);
            totalCount += oddCount;
            int evenCount = expand(s, i, i + 1);
            totalCount += evenCount;
        }
        return totalCount;
    }

    public static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--; 
            right++;
        }
        return count;
    }
    // Let n be the length of the string
    // Time Complexity: O(n^2) - in the worst case (when all the characters are the same) the inner loop (the while loop in the expand method) can run up to n times
    // Space Complexity: O(1) - we are only using constant extra space
}
