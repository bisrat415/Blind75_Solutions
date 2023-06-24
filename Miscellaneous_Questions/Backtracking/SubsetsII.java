// This file has a solution for Q90(SubsetsII). It uses backtracking through DFS traversal to find all the possibe subsets and sorts the array to make it easier to avoid duplicates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, result, comb, index);
        return result;
    }

    public static void subsetsWithDupHelper(int[] nums, List<List<Integer>> result, List<Integer> comb, int index) {
        result.add(new ArrayList(comb));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            comb.add(nums[i]);
            subsetsWithDupHelper(nums, result, comb, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
    // Let n be the length of nums
    // Time Complexity: O(n * 2^n) - sorting takes O(nlogn). In the worst case (the
    // set contains no duplicates) we will generate 2^n subsets. And adding each
    // generated subset into result takes O(n) because we are creating a new copy of
    // comb. So overall it will be O(n2^n)

    // Space Complexity: O(n) - in the worst case, the depth of the recursion (and
    // therefore the height of the call stack) can be as large as the number of
    // elements in the input set
    // We don't take result into account for calculating space complexity because it
    // is part of the output
}
