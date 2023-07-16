// This solution uses bottom-up dp (tabulation)
public class Solution_2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m, n));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        // Time Complexity: O(m * n) because we have a double forloop. And all the operations in the loops are constant time
        // Space Complexity: O(m * n) because of the array, dp
    }
}
