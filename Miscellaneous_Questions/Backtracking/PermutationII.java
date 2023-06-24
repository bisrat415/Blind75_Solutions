// Solution for Q.47(PermutationII) from leetcode
// We use backtracking through DFS and sort the array to make it easier to avoid duplicates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // Solution #1 (sort)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums, result, perm, used);
        return result;
    }

    public static void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> perm, boolean[] used) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                used[i] = true;
                permuteUniqueHelper(nums, result, perm, used);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }
    // Time Complexity: O(n * n!) - in the worst case scenario (no duplicates),
    // generating all the permutations takes n! time.
    // And for each permutation it takes O(n) time to add to results (because we are
    // creating a new arraylist)
    // And sorting is O(nlogn) < o(n*n!) so overall it is O(n*n!)

    // Space Complexity: O(n) - the max depth of each recursive call (the height of
    // the call stack) is O(n) and the boolean array 'used' takes O(n) time as well
    // We don't take result into account for calculating space complexity because it
    // is part of the output
}
