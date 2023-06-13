// Question: Given an array of integers of size ‘n’, calculate the maximum sum possible for ‘k’ consecutive elements in the array.
public class maxConsecutiveSum {
    public static void main(String[] args) {
        int[] nums = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSum(nums, k));

    }

    // Solution #1 (brute-force)
    public static int maxSum(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int currSum = 0;
            for (int j = 0; j < k; j++) {
                currSum += nums[j + i];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
        // Let n be the size of the array nums
        // Time Complexity: O((n - k + 1) * k) because the outer loop runs (n - k + 1) and the inner loop iterates k times
        // Space Complexity: O(1) because we are only using constant extra space (does not depend on the size of the input)
    }
     // Solution #2 (sliding window)
     public static int maxSum2(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int j = k; j < nums.length; j++) {
            windowSum = windowSum - nums[j - k] + nums[j];
            maxSum = windowSum > maxSum ? windowSum : maxSum;
        }
        return maxSum;
       // Time Complexity: O(n - k + k) = O(n) because the first forloop takes O(k) time and the second one takes O(n - k)
       // Space Complexity: O(1) because we are only utilizing constant extra space
   }
}
