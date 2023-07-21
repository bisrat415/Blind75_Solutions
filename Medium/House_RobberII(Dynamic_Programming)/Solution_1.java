// This solution uses the the logic of House Robber I and customizes it for this case

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        // Solution #1 (Recursive Approach with Memoization)
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Integer[] memo = new Integer[n];
        int includeFirst = basicRob(nums, memo, 0, n - 2);
        memo = new Integer[n];
        int includeLast = basicRob(nums, memo, 1, n - 1);
        return Math.max(includeFirst, includeLast);
    }

    public static int basicRob(int[] nums, Integer[] memo, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        int result = Math.max(nums[start] + basicRob(nums, memo, start + 2, end), basicRob(nums, memo, start + 1, end));
        memo[start] = result;
        return result;
    }
    // Let n be the length of nums
    // Time Complexity: O(n) - for each index we are calling the recursive method at most twice 
    // Space Complexity: O(n) - the memo array has size n and the depth of the recursive call stack is limited by n


}
