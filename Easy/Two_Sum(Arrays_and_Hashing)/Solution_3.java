// This solution uses a hashmap just like solution 2 but this time we will only have one forloop
// While we are iterating and inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table. 
// If it exists, we have found a solution and return the indices immediately.
import java.util.*;
public class Solution_3 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[]{i, hm.get(diff)};
            }
            hm.put(nums[i], i);
        }
        return null;
        // Time Complexity: O(n) - we are going through the array once using the forloop and all the operations in the loop are constant time
        // Space Complexity: O(n) - in the worst case (when the second number is at the end of the array) the hashmap will contain n - 1 elements
    }
}
