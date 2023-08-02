// This is a brute-force approach with a double forloop
// Time limit exceeds on Leetcode
public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
        // Let n be the length of nums  
        // Time Complexity: O(n^2) because of the double forloop. And all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
}
