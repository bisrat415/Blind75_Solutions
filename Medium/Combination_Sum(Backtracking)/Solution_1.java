// This solution uses the backtracking approach through DFS traversal to come up with all the possible valid combinations

import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        List<Integer> possibleRes = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, result, possibleRes, target, index);
        return result;
    }

    public static void combinationSumHelper(int[] candidates, List<List<Integer>> result, List<Integer> possibleRes,
            int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(possibleRes));
            return;
        }
        // You can comment this if-block out if you sort the array and have the code
        // from line 20 to 22
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            possibleRes.add(candidates[i]);
            combinationSumHelper(candidates, result, possibleRes, target - candidates[i], i);
            possibleRes.remove(possibleRes.size() - 1);
        }
        // Let n be the length of candidates, t be the target and m be the minimum value
        // among the candidates
        // Time Complexity: O(n^(t/m)) - The total number of steps during the
        // backtracking would be the number of nodes in the tree.
        // In the worst case, the algorithm explores all possible combinations where the
        // sum equals the target.
        // Since it's allowed to reuse the same number, it could be using the smallest
        // number repeatedly, up to the target value. So, it would be n choices for each
        // of the t/m slots.

        // Space Complexity: O(t/m) - the maximum depth of the tree is t/m. This is
        // because, if the target is a multiple of the smallest candidate, then the
        // recursion can go as deep as t/m.
        // We don't take result into account for calculating space complexity because it
        // is part of the output
    }
}
