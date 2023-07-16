// This solution uses DP (recursion with memoization)
public class Solution_1 {
    private static Integer[][] memo;;
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return lCSHelper(text1, text2, 0, 0);
    }

    public static int lCSHelper(String text1, String text2, int i, int j) {
	    if (i == text1.length() || j == text2.length()) {
	        return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        Integer result = null;
        if (text1.charAt(i) == text2.charAt(j)) {
	        result = 1 + lCSHelper(text1, text2, i + 1, j + 1);
        } else {
            result = Math.max(lCSHelper(text1, text2, i + 1, j), lCSHelper(text1, text2, i, j + 1));
        }
        
        memo[i][j] = result;
        return result;
        // Let m be the length of text1 and n be the length of text2
        // Time Complexity: O(m * n) - due to memoization we are calling the recursive method for the same set of substrings only once. And there are m*n unique set of substrings (subproblems)
        // Space Complexity: O(m * n) because we are storing the answer of each subproblem in memo. And the max height of the recursive call stack is bounded by m*n
    }
}
