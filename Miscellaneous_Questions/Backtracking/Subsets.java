// This file has a solution for Q78(Subsets). It uses backtracking through DFS traversal to find all the possibe subsets

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int index = 0;
        subsetsHelper(nums, result, comb, index);
        return result;
    }

    public static void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> comb, int index) {
        result.add(new ArrayList(comb));
        for (int i = index; i < nums.length; i++) {
            comb.add(nums[i]);
            subsetsHelper(nums, result, comb, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
    // Let n be the length of nums
    // Time Complexity: O(n * 2^n) - the algorithm generates 2^n subsets (since
    // that's the number of subsets a set can have).
    // And for each subset, it takes O(n) time to process it (add to result list)
    // because we are copying comb everytime we add to result. Therefore, the
    // overall time complexity is O(n2^n)

    // Space Complexity: O(n) because in the worst case the depth of the recursion
    // (and therefore the height of the call stack) can be as large as the number of
    // elements in the input set.
    // We don't take result into account for calculating space complexity because it
    // is part of the output
}
