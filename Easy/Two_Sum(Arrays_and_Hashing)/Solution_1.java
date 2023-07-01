// This is a brute forced solution that goes through each possible pair and check if they add to target

import java.util.Arrays;

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
        // Time Complexity: O(n^2) because of the double for loop. n + n - 1 + n - 2 ... + 2 + 1 = n(n - 1)/2 
        // Space Compexity: O(1) because we are only using constant extra space (not related to the input size)
    }
}
