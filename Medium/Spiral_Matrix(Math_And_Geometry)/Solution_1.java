// This is a solution for Q.54(Spiral Matrix) from Leetcode
// We are doing four traverals (left to right, top to bottom, right to left, and bottom to top) repeatedly until we visit every cell
// Look at this link for more description of the algorithm: https://leetcode.com/problems/spiral-matrix/editorial/
import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<Integer> answer = new ArrayList<>();
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        while (answer.size() < rows * columns) {
            for (int col = left; col <= right; col++) {
                answer.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                answer.add(matrix[row][right]);
            }
            if (bottom != top) {
                for (int col = right - 1; col >= left; col--) {
                    answer.add(matrix[bottom][col]);
                }
            }
            if (left != right) {
                for (int row = bottom - 1; row > top; row--) {
                    answer.add(matrix[row][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return answer;
    }
    // Let m be the number of rows and n be the number of columns
	// Time Complexity: O(m*n) - we are visiting each cell once
	// Space Complexity: O(1) - we are only using constant extra space. 
	// Here it is important to recognize that we don't include the output list (answer) in out space complexity analysis
}
