// This solution uses a hashmap to come up with a way more efficient solution
// We use two iterations. In the first iteration, we add each element's value as a key and its index as a value to the hash table.
// In the second iteration we take a difference of target with the current value and check if that difference exists in the map in which case we found an answer
// Beware that the diff we find in the hashmap must not be the current value itself
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null;
        // Time Complexity: O(n) - we have two forloops and each of them go through the array once (O(2n)) and all the operations in the loops are constant time
        // Space Complexity: O(n) - because of the hashmap 


    }
}
