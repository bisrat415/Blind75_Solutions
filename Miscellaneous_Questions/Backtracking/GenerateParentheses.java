import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, n, 0, 0, new StringBuilder());
        return result;

    }
    public static void backTrack(List<String> result, int n, int left, int right, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            result.add(String.valueOf(sb));
            return;
        }
        if (left < n) {
            sb.append("(");
            backTrack(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backTrack(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        // Time Complexity: O(4^n/sqrt(n)) - visit this link for the explanation: https://leetcode.com/problems/generate-parentheses/editorial/
        // Space Complexity: O(n) - the space complexity of a recursive call depends on the maximum depth of the recursive call stack, which is 2n. As each recursive call either adds a left parenthesis or a right parenthesis, and the total number of parentheses is 2n 
    }
}
