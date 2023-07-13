// This solution uses recursion with memoization to solve the problem
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
     public static int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return numDecodeHelper(s, memo, 0);
    }
    public static int numDecodeHelper(String s, Map<Integer, Integer> memo, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (i == s.length() - 1) {
            return 1;
        }
        int ans = numDecodeHelper(s, memo, i + 1);
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            ans += numDecodeHelper(s, memo, i + 2);
        }
        memo.put(i, ans);
        return ans;
    }
    // Let n be the length of the string
    // Time Complexity: O(n) because we are calling the recursive method for each character in the string and we are using memoization for any overlapping operations (decoding for a specific index only once)
    // Space Complexity: O(n) because of memo and the recursive call stack which each of them take O(n) space in the worst case
}
