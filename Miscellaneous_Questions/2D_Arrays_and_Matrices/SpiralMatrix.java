import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> answer = new ArrayList<>();
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = column - 1;
        while (answer.size() < row * column) {
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            if (bottom != top) {
                for (int i = right - 1; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    answer.add(matrix[i][left]);
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
