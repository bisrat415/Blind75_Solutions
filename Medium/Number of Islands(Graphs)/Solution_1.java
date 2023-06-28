// This solution uses iteration through BFS to comeup with a solution
// We Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Breadth First Search. So we put it into a queue and set its value as '0' to mark as visited node. 
// Then we iteratively search the neighbors of enqueued nodes until the queue becomes empty.

// Time Limit Exceeds on leetcode
import java.util.*;
public class Solution_1 {
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
        int num_islands = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1') {
                    num_islands += 1;
                    Queue<List<Integer>> queue = new LinkedList<>();
                    int row = r;
                    int col = c;
                    queue.add(Arrays.asList(row, col));
                    while (!queue.isEmpty()) {
                        List<Integer> curr = queue.remove();
                        row = curr.get(0);
                        col = curr.get(1);
                        grid[row][col] = '0';
                        if (row > 0 && grid[row - 1][col] == '1') {
                            queue.add(Arrays.asList(row - 1, col));
                        }
                        if (row < rowLength - 1 && grid[row + 1][col] == '1') {
                            queue.add(Arrays.asList(row + 1, col));
                        }
                        if (col > 0 && grid[row][col - 1] == '1') {
                            queue.add(Arrays.asList(row, col - 1));
                        }
                        if (col < colLength - 1 && grid[row][col + 1] == '1') {
                            queue.add(Arrays.asList(row, col + 1));
                        }
                    }
                }
            }
        }
        return num_islands;
        // Let m be the number of rows and n be the number of colums
        // Time Complexity: O(m * n) because in the worst case (all cells are 1's) we visit each cell at most twice (one when it is processed by the queue and one by the double forloop)
        // so that will be O(2mn) and the constant coefficient will be ommited for big-O notation

        // Space Complexity: O(min(m,n)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(m,n)
        // Here is a good diagram to explain why: https://imgur.com/gallery/M58OKvB

        // Solution #2: Recursive (DFS) 
        
    }
}
