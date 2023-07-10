// This solution uses iteration and DP. Read this for more information about the approach: https://leetcode.com/problems/house-robber/editorial/
public class Solution_3 {
     public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
         if (nums == null) {
            return 0;
        }
        int n = nums.length;
        int[] maxRobbed = new int[n + 1];
        maxRobbed[1] = nums[0];
        for (int i = 2; i < maxRobbed.length; i++) {
            maxRobbed[i] = Math.max(nums[i - 1] + maxRobbed[i - 2], maxRobbed[i - 1]);
        }
        return maxRobbed[n];
        // Let n be the length of nums
        // Time Complexity: O(n) because of the forloop and all the operations in the loop are constant time
        // Space Complexity: O(n) because of maxRobbed array
    }
}
