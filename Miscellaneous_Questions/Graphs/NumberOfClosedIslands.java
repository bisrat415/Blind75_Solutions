// This is a solution for Q.1254(Number of Closed Islands)

public class NumberOfClosedIslands {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}}; // There are two closed islands in this grid
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (rows == 1 || columns == 1) {
            return 0;
        }
        int countIslands = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && dfs(grid, i, j, visited)) {
                    countIslands++;
                }
            }
        }
        return countIslands;
    }

    public static boolean dfs(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return false;
        }
        if (grid[row][column] == 1 || visited[row][column]) {
            return true;
        }
        visited[row][column] = true;
        boolean isClosedIsland = true;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (!dfs(grid, nextRow, nextColumn, visited)) {
                isClosedIsland = false;
            }
        }
        return isClosedIsland;
        // Let m be the number of rows and n be the number of columns
        // Time Complexity: O(m * n) because we are visiting each cell in the grid once
        // Space Complexity: o(m * n) - the visited array takes m * n space and the depth of the recursive call stack for dfs is bounded by m * n
    }

}
