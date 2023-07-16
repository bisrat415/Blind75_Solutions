// This solution uses top-down dp (recursion with memoization)
public class Solution_1 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m, n));

    }

    public static int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return uniquePathsHelper(m, n, memo);
    }

    public static int uniquePathsHelper(int m, int n, Integer[][] memo) {
        if (m - 1 == 0 || n - 1 == 0) {
            return 1;
        }
        if (memo[m - 1][n - 1] != null) {
            return memo[m - 1][n - 1];
        }
        int result = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
        memo[m - 1][n - 1] = result;
        return result;
    }
    // Time Complexity: O(m * n) because we will have m * n subproblems and we are computing the same subproblem only once since we used memoization
    // Space Complexity: O(m * n) because of memo. And the height of the recursive call stack is bound by m*n

}
