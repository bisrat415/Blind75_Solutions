// This solution uses DFS through recursion to find a solution
// Instead of starting from each cell and checking if they have a valid path, we start from the ocean and try to work our way to the cells which is way more efficient
// Read this for the detailed descrption of the algorithm: https://leetcode.com/problems/pacific-atlantic-water-flow/editorial/
import java.util.*;
public class Solution_1 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
   
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int numRows = heights.length;
        int numColumns = heights[0].length;
        boolean[][] pacificReachable = new boolean[numRows][numColumns];
        boolean[][] atlanticReachable = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            dfs(heights, i, 0, pacificReachable);
            dfs(heights, i, numColumns - 1, atlanticReachable);
        }
        for (int j = 0; j < numColumns; j++) {
            dfs(heights, 0, j, pacificReachable);
            dfs(heights, numRows - 1, j, atlanticReachable);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public static void dfs(int[][] heights, int r, int c, boolean[][] reachable) {
        if (reachable[r][c]) {
            return;
        }
        reachable[r][c] = true;
        for (int[] direction : DIRECTIONS) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            if (nextR >= 0 && nextC >= 0 && nextR <= heights.length - 1 && nextC <= heights[0].length - 1 && heights[r][c] <= heights[nextR][nextC]) {
                dfs(heights, nextR, nextC, reachable);
            }
        }
    }
    // Let m be the number of rows and n be the number of columns
    // Time Complexity: O(m * n) - in the worst case (all the cells have the same height), we will be visiting each cell twice (one by pacificReachable and one by atlanticReachable). So it will take O(2mn) and we can drop the coefficient, 2
    // Space Complexity: O(m * n) - we are creating two arrays with the same size as heights (pacificReachable and atlanticReachable).
    // The height of the recursive call stack is also bounded by O(mn) because in the worst case scenario, where DFS could potentially go through all cells, the maximum depth of the recursion stack would be mn
}
