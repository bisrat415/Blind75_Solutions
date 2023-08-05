// This solution uses two hashsets, one to store all the rows that should be converted to zero and another for all the columns 
// And then go through all the cells again and convert them to zeros if their row number exists in the row set or their column number exists in the column set
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Let m be the total number of rows and n be the total number of columns
        // Time Complexity: O(m*n) - because we have two double for loops that visit each cell in the matrix and all the operations in the forloops are constant time
        // Space Complexity: O(m + n) - because of the two hashsets
    }
}
