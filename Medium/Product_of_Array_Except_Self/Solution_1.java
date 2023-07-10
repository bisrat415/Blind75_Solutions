// In this solution we use brute-force to go through the array for each element in the array with a double for loop and calculate the product
// Inside the double for loop, we take the product of all the elements except the element on the current iteration

import java.util.Arrays;

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        // Solution #1 (Brute-Force) - Time Limit Exceeds
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }
        return answer;
        // Time Complexity: O(n^2) because of the double for loop and all the operations in the loop are constant time
        // Space Complexity: O(1) - the output array (answer) will not be considered as extra space
    }
}
