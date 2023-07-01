// This solution utilizes BFS using queues to find a solution
// Instead of starting from each cell and checking if they have a valid path, we start from the ocean and try to work our way to the cells which is way more efficient
// Read this for the detailed descrption of the algorithm: https://leetcode.com/problems/pacific-atlantic-water-flow/editorial/
import java.util.*;
public class Solution_2 {
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
        Queue<List<Integer>> pacificQueue = new LinkedList<>();
        Queue<List<Integer>> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            pacificQueue.add(Arrays.asList(i, 0));
            atlanticQueue.add(Arrays.asList(i, numColumns - 1));
        }
        for (int j = 0; j < numColumns; j++) {
            pacificQueue.add(Arrays.asList(0, j));
            atlanticQueue.add(Arrays.asList(numRows - 1, j));
        }
        bfs(heights, pacificQueue, pacificReachable);
        bfs(heights, atlanticQueue, atlanticReachable);
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

    public static void bfs(int[][] heights, Queue<List<Integer>> queue, boolean[][] reachable) {
        while (!queue.isEmpty()) {
            List<Integer> currCell = queue.remove();
            int currRow = currCell.get(0);
            int currCol = currCell.get(1);
            reachable[currRow][currCol] = true;
            for (int[] direction : DIRECTIONS) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow <= heights.length - 1 && nextCol <= heights[0].length - 1 && heights[nextRow][nextCol] >= heights[currRow][currCol] && !reachable[nextRow][nextCol]) {
                    queue.add(Arrays.asList(nextRow, nextCol));
                }
            }
        }
    }
    // Let m be the number of rows and n be the number of columns
    // Time Complexity: O(m * n) - in the worst case (all the cells have the same height) we visit each cell twice (one by pacificReachable and one by atlanticReachable) which will take O(2mn) time and we can drop 2
    // Space Complexity: O(m * n) - we created two arrays with the same size to heights ( pacificReachable, atlanticReachable)
    // And the size of the queue is bounded by the number of cells (mn)
}
