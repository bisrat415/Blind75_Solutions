// In this solution we are utilizing a hashset that supports a fast search and insert operation

import java.util.*;

class Solution_3 {
    public static void main(String[] args) {
        int[] nums = {2, 8, 4, 5, 1, 4};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;

    }
}
// Time Complexity: O(n) - we are going through the array once and adding to and searching the hashset is constant time
// Space Complexity: O(n) - the space used by the hashset is linearly proportional to the number of elements we have in the array, nums
