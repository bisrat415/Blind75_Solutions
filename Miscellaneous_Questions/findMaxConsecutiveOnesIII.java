// Question: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// The solution utilizes the sliding window approach to find all available valid windows and calculate the longest one
public class FindMaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                maxLength = (right - left) > maxLength ? right - left : maxLength;
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            right++;

        }
        return Math.max(maxLength, right - left);
        // let n be the length of the array nums
        // Time Complexity: O(n) because in worst case we only end up visiting every element of array twice, once by left pointer and once by right pointer
        // Space Complexity: O(1) because we are only utilizing constant space
    }
}