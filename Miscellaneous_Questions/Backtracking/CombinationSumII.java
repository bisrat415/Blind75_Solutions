// This file solves Q40(Combination Sum II) from leetcode
// It uses backtracking like Combination Sum but it also sorts the array to make it easy to avoid duplicates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> possibleRes = new ArrayList<>();
        int index = 0;
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, result, possibleRes, target, index);
        return result;
    }

    public static void combinationSum2Helper(int[] candidates, List<List<Integer>> result, List<Integer> possibleRes,
            int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(possibleRes));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            possibleRes.add(candidates[i]);
            combinationSum2Helper(candidates, result, possibleRes, target - candidates[i], i + 1);
            possibleRes.remove(possibleRes.size() - 1);
        }
    }
    // Let n be the length of the array, candidates
    // Time Complexity: O(2^n) - In the worst case scenario (assuming that each
    // number is unique), The number of combination for an array of size n would be
    // 2^n because each number is either included or excluded in a combination.
    // Sorting takes O(nlogn) and it takes O(n) time to make a new array from
    // possibleRes when we find an answer set.
    // So the overall time complexity is dominated by the backtracking (2^n)

    // Space Complexity: O(n) - in the worst case (each number is unique) the
    // recursive call stack will pile up to O(n)
    // We don't take result into account for calculating space complexity because it
    // is part of the output
}
