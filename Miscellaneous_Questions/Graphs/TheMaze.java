public class TheMaze {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(hasPath(maze, start, destination));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, destination, visited);
    }

    public static boolean dfs(int[][] maze, int[] node, int[] destination, boolean[][] visited) {
        int m = maze.length;
        int n = maze[0].length;
        int row = node[0];
        int col = node[1];
        // If node is already visited, we return false because we have already traversed this cell and could not reach destination
        if (visited[row][col]) {
            return false;
        }
        // If node is the same as destination, we return true
        if (row == destination[0] && col == destination[1]) {
            return true;
        }
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            row = node[0];
            col = node[1];
            while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                row += direction[0];
                col += direction[1];
            }
            if (dfs(maze, new int[]{row - direction[0], col - direction[1]}, destination, visited)) {
                return true;
            }
        }
        return false;
    }
    // Let m be the total number of rows and n be the total number of columns
    // Time Complexity: O(m*n*(m + n)) - The function dfs visits each node at most once, resulting in O(m*n) calls. For each call, we loop through the node's neighbors. 
    // To discover neighboring nodes for a node, we check in each direction with a while loop and it would take O(m) steps for vertical directions or O(n) steps for horizontal directions to reach a wall, resulting in O(m+n) operations. It would take O(m*n*(m+n)) in total for all the nodes

    // Space Complexity: O(m*n) - visited array takes O(m*n) space and the depth of the recursive call stack for dfs is bounded by m*n

}
