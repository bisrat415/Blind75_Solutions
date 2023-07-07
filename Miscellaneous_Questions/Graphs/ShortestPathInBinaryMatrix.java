import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    // Solution #1 (BFS while updating the input grid)
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int distance = -1;
        if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) {
            return distance;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int row = currCell[0];
            int column = currCell[1];
            distance = grid[row][column];
            if (row == rows - 1 && column == columns - 1) {
                return distance;
            }
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 0) {
                    grid[newRow][newColumn] = distance + 1;
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
        return -1;
        // Let m be the number of rows and n be the number of columns
        // Time Complexity: O(n * m) - In the worst case we are visiting cell in the grid once
        // Space Complexity: O(n * m) - Because the possible maximum that we can put in the queue is the total number of cells. 
        // Given that BFS will have nodes of at most two unique distances on the queue at any one time, it would be reasonable to wonder if the worst-case space complexity is actually lower. 
        // But actually, it turns out that there are cases with massive grids where the number of cells at a single distance is proportional to m * n. 
        // So even with cells of a single distance on the queue, in the worst case, the space needed is O(m * n)
    }
}
