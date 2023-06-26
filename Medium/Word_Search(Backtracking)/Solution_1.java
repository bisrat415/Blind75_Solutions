// This solution utilizes backtracking through DFS to explore all the available path
// we would walk around the 2D grid, and at each step, we mark our choice before jumping into the next step. And at the end of each step (when the path is invalid or when we find the match), we would also revert our mark so that we will have a clean slate to try another direction

public class Solution_1 {
    private static int ROWS;
    private static int COLUMNS;
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board, word));
    }
    
    public static boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLUMNS = board[0].length;
        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (existHelper(board, word, i, j, index)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean existHelper(char[][] board, String word, int row, int column, int index) {
        // Check the bottom case
        if (index >= word.length()) {
            return true;
        }
        // Check the boundaries and the current two characters. If one of them turns out false, backtrack
        if (row < 0 || row == ROWS || column < 0 || column == COLUMNS || word.charAt(index) != board[row][column]) {
            return false;
        }
        board[row][column] = '*'; // Mark the current character in board as explored
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        boolean result = false;
        // Explore all horizontal and vertical neighbors
        for (int i = 0; i < 4; i++) {
            if (existHelper(board, word, row + rowOffset[i], column + colOffset[i], index + 1)) {
                result = true;
            }
            if (result) {
                break;
            }
        }
        // Clean-up and return the result
        board[row][column] = word.charAt(index);
        return result;
    }
    // Let n be the number of cells in the board and l be the length of the word to be matched
    // Time Complexity: O(n * 3^l) - for each cell we have at most four different options to explore (but it becomes 3 because we are not exploring the direction we came from).
    // Therefore, it will look like a 3-nary tree where each branch represents a potential exploration in the corresponding directon. 
    // So in the worst case, the total number of exploraton will be the number of nodes in the full 3-nary tree
    // We iterate through the board for backtracking, so there could be n times invocation for the backtracking function in the worst case
    // So overall the time complexity is O(n*3^l)

    // Space Complexity: O(l) - in the worst case the depth of the recursion (the height of the call stack) is equal to the length of the word to be matched.
    // The rest of the extra spaces used are constant time (don't depend on the input size)
}
