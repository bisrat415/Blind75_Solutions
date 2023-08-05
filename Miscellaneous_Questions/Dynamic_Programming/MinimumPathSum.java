// This is a solution for Q.64 (Minimum Path Sum) from Leetcode
public class MinimumPathSum {
     private static Integer[][] memo;
    public static void main(String[] args) {
        
    }

     // Solution #1 (DP - Top-Down or Recursive Approach with Memoization)
    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return Integer.MAX_VALUE;
        }
        memo = new Integer[grid.length][grid[0].length];
        return helper(grid, 0, 0);
        // Let m be the total number of rows and n be the total number of columns
        // Time Complexity: O(m*n) - due to memoization each cell will be visited only once
        // Space Complexity: O(m*n) because of the array, memo and the maximum depth of the recursive call stack is limited by m*n 
    }

    // Solution #2 (DP - Bottom-Up or Iterative Approach with Tabulation)
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                }
                if (i != m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                if (i != m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
        // Let m be the total number of rows and n be the total number of columns
        // Time Complexity: O(m*n) because each cell is visited only once through the double forloop and all the operations in the loop are constant time
        // Space Complexity: O(m*n) because of the array, dp
    }


    // Helper method for Solution #1
    public static int helper(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int result = 0;
        if (i == m - 1 && j == n - 1) {
            result = grid[i][j];
        } else {
            result = grid[i][j] + Math.min(helper(grid, i + 1, j) , helper(grid, i, j + 1));
        }
        memo[i][j] = result;
        return result;
    }

}
