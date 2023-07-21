// This solution uses the the logic of House Robber I (interative DP approach, Tabulation) and customizes it for this case

public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int includeFirst = basicRob(nums, 0, n - 2);
        int includeLast = basicRob(nums, 1, n - 1);
        return Math.max(includeFirst, includeLast);
    }

    public static int basicRob(int[] nums, int start, int end) {
        int robWithoutIncludingLastHouse = 0;
        int robIncludingLastHouse = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int curr = Math.max(nums[i] + robWithoutIncludingLastHouse, robIncludingLastHouse);
            robWithoutIncludingLastHouse = robIncludingLastHouse;
            robIncludingLastHouse = curr;
        }
        return robIncludingLastHouse;
    }
    // Let n be the length of nums
    // Time Complexity: O(n) because of the forloop and all the operations in the forloop are constant time
    // Space Complexity: O(1) because we are only utilizing constant extra space   
}
