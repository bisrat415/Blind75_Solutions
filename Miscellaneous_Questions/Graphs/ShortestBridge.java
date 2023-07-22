import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        int[][] grid = {{0,1,0}, {0,0,0}, {0,0,1}};
        System.out.println(shortestBridge(grid)); // the shortest bridge for this grid has length 2
    }

    public static int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] firstIsland = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    firstIsland[0] = i;
                    firstIsland[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        traverseFirstIsland(grid, firstIsland[0], firstIsland[1], queue); // assign 2's to one island to differentiate it from the other
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] currCell = queue.poll();
                int currRow = currCell[0];
                int currCol = currCell[1];
                for (int[] direction : DIRECTIONS) {
                    int newRow = currRow + direction[0];
                    int newCol = currCol + direction[1];
                     if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                         if (grid[newRow][newCol] == 1) {
                             return count;
                         }
                         if (grid[newRow][newCol] == 0) {
                             queue.offer(new int[]{newRow, newCol});
                             grid[newRow][newCol] = -1;
                         }
                         
                     }
                }
                size--;
            }
            count++;
        }
        return -1;


    }

    public static void traverseFirstIsland(int[][] grid, int row, int col, Queue<int[]> queue) {
        queue.offer(new int[]{row, col});
        grid[row][col] = 2;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                traverseFirstIsland(grid, newRow, newCol, queue);
            }
        }
    }

    // Let n rows and columns (the matrix is guaranteed to be a square)
    // Time Complexity: O(n^2) because we are visited each cell once and all other operations are constant time
    // Space Complexity: O(n^2) because the maximum depth of the recursive call stack in the dfs (traverseFirstIsland) is n^2 in the worst case. And the space used by the bfs queues is limited by n^2
}
