// This solution optimizes solution one by using memoization. Read this for more information about the approach: https://leetcode.com/problems/house-robber/editorial/
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
         if (nums == null) {
            return 0;
        }
        Integer[] memo = new Integer[nums.length];
        return robHelperMemo(nums, memo, 0);
    }
    public static int robHelperMemo(int[] nums, Integer[] memo, int n) {
        if (n >= nums.length) {
            return 0;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int result = Math.max(nums[n] + robHelperMemo(nums, memo, n + 2), robHelperMemo(nums, memo, n + 1));
        memo[n] = result;
        return result;
    }   
     // Let n be the length of nums
    // Time Complexity: O(n) - for each index we are calling the recursive method at most twice 
    // Space Complexity: O(n) - the memo array has size n and the depth of the recursive call stack is limited by n
}
