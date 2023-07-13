// This is a solution for Q.53(Maximum Subarray) from Leetcode
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));

    }

    // Solution #1 (Brute-Force) - Time Limit Exceeds
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = currSum > maxSum ? currSum : maxSum;
            }
        }
        return maxSum;
        // Let n be the length of nums
        // Time Complexity: O(n^2) because of the double forloop. And all the operations
        // in the forloop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }

    // Solution #2 (Dynamic Programming)
    public static int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]); // if the current element is greater than the sum of all the elements before it, we assign the value of that element to the variable sum
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
        // Let n be the length of nums
        // Time Complexity: O(n) - we have one forloop that iterates through the whole
        // array once and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }
}
