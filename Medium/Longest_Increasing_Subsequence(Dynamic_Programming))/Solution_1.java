// This solution uses tabular dp to divide the problem into smaller problems and combine those to find the final solution
import java.util.Arrays;
public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums)); // Should print 4 because the longest increasing subsequence is [2,3,7,101]
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
	    int[] dp = new int[n];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
		        if (nums[i] > nums[j]) {
	                dp[i] = Math.max(dp[i], 1 + dp[j]);
                }           
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
	        if (dp[i] > result) {
	            result = dp[i];
            }
        }
        return result;
        // Time Complexity: O(n^2) because of the double forloop
        // Space complexity: O(n) because of dp
    }
}
