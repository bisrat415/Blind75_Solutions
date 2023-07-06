// This is a solution for Q.2022(Convert 1D Array Into 2D Array) from leetcode
import java.util.Arrays;
public class Convert1Dto2D {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;
        System.out.println(Arrays.toString(construct2DArray(original, m, n)));
        
    }
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] newArray = new int[m][n];
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                if (index < original.length) {
                    newArray[i][j] = original[index];
                    index++;
                }  
            }
        }
        return newArray;
        // We know that m be the number of rows and n be the number of columns
        // Time Complexity: O(m * n) : In the worst case (the 1D array fits perfect in the 2D array), we will be visiting each cell of the 2D array once because of the double forloop
        // Space Complexity; O(1) - we don't include newArray in our analysis because it is the output. And other than that we are only using constant extra space
    }
}
