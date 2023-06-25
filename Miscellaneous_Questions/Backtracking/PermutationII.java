// Solution for Q.47(PermutationII) from leetcode
// Solution #1: We use backtracking through DFS and sort the array to make it easier to avoid duplicates
// Solution #2: We use backtracking trough DFS and put the result in a set to remove duplicates
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
        System.out.println(permuteUnique2(nums));

    }

    // Solution #1 (sort)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        // The used array keeps track of whether we have added a number at a specific index to the current permutation (at the current depth in the recursion/decision tree). 
        // This is used to avoid using the same number multiple times in a permutation.
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums, result, perm, used);
        return result;
    }

    public static void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> perm, boolean[] used) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // If the whole condition after || is true, it means we've just backtracked from a branch where the previous duplicate was used, so we skip the current number to avoid creating a duplicate permutation.
                // This condition essentially enforces the rule that, among duplicate numbers, we always use the leftmost one first. This way, we avoid ending up with duplicate permutations
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

    // Solution #2 (hashset)
    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        permuteUniqueHelper2(nums, perm, set, used);
        return new ArrayList(set);
    }

    public static void permuteUniqueHelper2(int[] nums, List<Integer> perm, Set<List<Integer>> set, boolean[] used) {
        if (perm.size() == nums.length) {
            set.add(new ArrayList(perm));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;
                permuteUniqueHelper2(nums, perm, set, used);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }
    // Time Complexity: O(n * n!) - There are n! permutations for any given sequence
    // of n distinct numbers
    // For each permutation, the algorithm spends O(N) time for adding each
    // permutation into the hash set (we are copying the arraylist)

    // Space Complexity: O(n) - the max depth of each recursive call (the height of
    // the call stack) is O(n) and the boolean array 'used' takes O(n) time as well
    // We don't take result into account for calculating space complexity because it
    // is part of the output
}
