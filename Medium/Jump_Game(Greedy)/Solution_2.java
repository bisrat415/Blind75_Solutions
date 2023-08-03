// This solution goes through the array starting from the end, backwards, and uses a greedy approach to find a solution
// For a detailed description of the algorithm visit this link: https://leetcode.com/problems/jump-game/editorial/
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
        // let n be the length of the array, nums
        // Time Complexity: O(n) because we are visiting each element once and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
}
