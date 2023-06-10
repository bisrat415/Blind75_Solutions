// In this solution we first sort the array and follow the same hashtable approach we use for Two Sum.
// We move our pivot element nums[i] and analyze elements to its right with the target of finding all pairs whose sum is equal to -nums[i] using the Two Sum: One-pass Hash Table approach

import java.util.*;

public class Solution_3 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }  
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i < nums.length && nums[i] <= 0) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            } 
            i++;
        }
        return result;
    }

    public static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int target = -nums[i];
        HashSet<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int diff = target - nums[j];
            if (seen.contains(diff)) {
                result.add(Arrays.asList(nums[i], nums[j], diff));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }

    }
    // Let n be the size of the array
    // Time Complexity: O(n^2) - twoSum is O(n), and we call it n times.
    // Sorting the array takes O(nlog⁡n), so overall complexity is O(nlog⁡n+n^2). This is asymptotically equivalent to O(n^2)
    // Space Compexity: O(n) for the hashset
}   
