// This solution uses the same logic as Solution_1 but improves the space complexity to O(1)
import java.util.*;
public class Solution_3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }
        return answer;
        // Time Complexity: O(n) - both forloops take O(n) time
        // Space Complexity: O(1) - the output array (answer) will not be considered as extra space
    }
}
