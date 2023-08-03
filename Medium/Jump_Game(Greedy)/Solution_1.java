// This a brute-forced recursive approach
import java.util.*;
public class Solution_1 {
    private static Map<Integer, Boolean> memo;
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }
     public static boolean canJump(int[] nums) {
        memo = new HashMap<>();
        return helper(nums, 0);
     }

     public static boolean helper(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        boolean result = false;
        for (int i = 1; i <= nums[index]; i++) {
            if (helper(nums, index + i)) {
                result = true;
                break;
            }
        }
        memo.put(index, result);
        return memo.get(index);
    }
    // let n be the length of the array, nums
    // Time Complexity: O(n^2) - we are calling the recursive method for each method once and we have a forloop in each recursive call so in the worst case it will take O(n^2) time
    // Space Complexity: O(n) - in the worst case the maximum depth of the recursive call stack is O(n)
}
