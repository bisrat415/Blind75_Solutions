// This file solves Question 487 ( Max Consecutive Ones II) on leetcode
// The question asks given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0
public class findMaxConsecutiveOnesII {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            while (zeroCount >  1) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                } 
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            right++;

        }
        return right - left > maxLength ? right - left : maxLength;
    }
    // Time Complexity: O(n) - even though there is a nested while loop, the inner while loop only executes occasionally (when zeroCount > 1)
    // Another justification is that since both the pointers only move forward, each of the left and right pointer traverse a maximum of n steps
    // Space Complexity: O(1) - only constant extra space is used
}
