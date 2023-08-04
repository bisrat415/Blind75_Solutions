// Step 1: Find the transpose of the matrix (reverse the matrix along the main diagonal)
// Step 2: invert the transpose horizontally (reverse from left to right)

import java.util.Arrays;

public class Solution_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        transpose(matrix);
        invertHorizontally(matrix);
    }
    public static void transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void invertHorizontally(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    // Let m be the total number of rows and n be the total number of columns
    // Time Complexity: O(m*n) - both transpose and invertHorizontally have double forloops that go through the matrix
    // Space Complexity: O(1) because we are only utilizing constant extra space
}
