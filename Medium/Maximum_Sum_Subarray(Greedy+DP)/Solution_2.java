// This solution utilizes the Kadane's Algorithm which is a Greedy + DP Approach
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int runningSum = 0;
        for (int num : nums) {
            runningSum = Math.max(0, runningSum) + num;
            maxSum = Math.max(runningSum, maxSum);
        }
        return maxSum;
        // Let n be the length of nums  
        // Time Complexity: O(n) - we have one forloop that iterates through the whole array once and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }
}
