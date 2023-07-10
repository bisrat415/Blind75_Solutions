// This solution uses recursion without memoization (Time limit exceeds on Leetcode)
public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
         if (nums == null) {
            return 0;
        }
        return robHelper(nums, 0);
    }
    public static int robHelper(int[] nums, int n) {
        if (n >= nums.length) {
            return 0;
        }
        return Math.max(nums[n] + robHelper(nums, n + 2), robHelper(nums, n + 1));
    }
    // Let n be the length of nums
    // Time Complexity: O(2^n) - we have two recursive calls in each method so the number of recursive calls grows exponentially with the input size
    // Space Complexity: O(n) - in the worst case the maximum depth of the recursive call stack can be n
}
