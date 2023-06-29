// This solution utilizes DFS through recursion to find the number of islands 
// We scan the 2d array with a double forloop.  if a node contains a '1', then it is a root node that triggers a Depth First Search. During DFS, every visited node should be set as '0' to mark as visited node. 
// Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island.
public class Solution_2 {
    public static void main(String[] args) {
        char[][] grid = {
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
    };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    numIslands += 1;
                    dfs(grid, r, c);
                }  
            }
        }
        return numIslands;
    }
    public static void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    // Let m be the number of rows and n be the number of columns
    // Time Complexity: O(m * n) - in the worst case (all the cells are 1's) we are visiting each cell at most twice so it takes O(2mn) which simplifies to O(mn)
    // Space Complexity: O(m * n) - in the worst case (all the cells are 1's) the depth of the recursion (the height of the call stack) can be the total number of cells in the grid
}
