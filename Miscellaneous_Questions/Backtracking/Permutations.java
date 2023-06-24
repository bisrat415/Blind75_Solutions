// This file has the solution for Q46(Permutations) from leetcode
// We use backtracking to find all the possible permutations of the provided numbers

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println( permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        permuteHelper(nums, result, perm);
        return result;
    }
    public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> perm) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (perm.contains(nums[i])) {
                    continue;
                }
                perm.add(nums[i]);
                permuteHelper(nums, result, perm);
                perm.remove(perm.size() - 1); // You could use this as well: perm.remove(Integer.valueOf(nums[i]) because nums has distinct integers
            }  
        }
    }
    // Let n be the length of the array, nums
    // Time Complexity: O(n * n!) - for an array of size n (with distinct integers) there are n! permutations
    // And for each permutation, the algorithm uses the contain method of an arraylist which takes O(n) time. So overall it is O(n*n!)

    // Space Complexity: O(n) or θ(n) - the maximum depth of the recursion (the height of the call stack) is n 
    // We don't take result into account for calculating space complexity because it is part of the output
}
