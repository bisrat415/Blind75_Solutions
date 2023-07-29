// This is a solution for Q.486 (Predict the Winner) from Leetcode
// We use top-down DP approach (recursion with Memoization) to solve it
// Since we are asked if Player one has a chance to win or not we ony have to worry about the difference of their score
// For detailed description of the solution visit this link: https://leetcode.com/problems/predict-the-winner/editorial/

public class PredictTheWinner {
    static Integer[][] memo;
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(predictTheWinner(nums));
    }
    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return maxDiff(nums, 0, n - 1) >= 0;
    }
    public static int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int pickLeft = nums[left] - maxDiff(nums, left + 1, right);
        int pickRight = nums[right] - maxDiff(nums, left, right - 1);
        int result = Math.max(pickLeft, pickRight);
        memo[left][right] = result;
        return result;
        // Time Complexity: O(n^2) - We use a cache memo to store the computed states. During the recursion, the cache makes sure we don't calculate a state more than once. The number of states (left, right) is O(n^2) 
        // Space Complexity: O(n^2) because of memo. And the maximum depth of the recursive call stack is limited by n^2.
    }
}
