// This is a solution for 560.(Subarray Sum Equals K) from leetcode

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum2(nums, k));

    }
     // Solution #1 (Brute Force)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
        // Let n be the length of the array
        // Time Complexity: O(n^2) because of the double for loop
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }

    // Solution #2 (HashMap and the concept of Prefix Sum)
    // For detailed explanation of this algorithm watch this: https://leetcode.com/problems/subarray-sum-equals-k/editorial/
    public static int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> presumCount = new HashMap<>();
        presumCount.put(0, 1);
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int subPresum = presum - k;
            if (presumCount.containsKey(subPresum)) {
                count += presumCount.get(subPresum);
            }
            presumCount.put(presum, presumCount.getOrDefault(presum, 0) + 1);
        }
        return count;
        // Let n be the length of the array
        // Time Complexity: O(n) because we are traversing through the array once and all the operations in the forloop are constant time
        // Space Complexity: O(n) because of the hashmap. There can be n unique prefix sums

    }
}
