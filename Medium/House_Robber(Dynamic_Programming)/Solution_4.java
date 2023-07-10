// This is another version of Solution #3 with a better space complexity
public class Solution_4 {
     public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int robWithoutIncludingLastHouse = 0;
        int robIncludingLastHouse = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(robWithoutIncludingLastHouse + nums[i], robIncludingLastHouse);
            robWithoutIncludingLastHouse = robIncludingLastHouse;
            robIncludingLastHouse = curr;
        }
        return robIncludingLastHouse;
        // Time Complexity: O(n) because of the forloop and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only utilizing constant extra space   
    }
}
