// This solution is based on the realization that after we sort the array, any duplicate integers will be consecutive 

import java.util.Arrays;

public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {2, 8, 4, 5, 1, 4};
        System.out.println(containsDuplicate(nums));

    } 
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) { // Compare i with the integer immediately before it
                return true;
            }
        }
        return false;
    }

}
// Time Complexity: O(nlogn) - Sorting is O(nlogn) and we are going through the whole array once which is O(n). So the whole algorithm will be dominated by the sorting step
// Space Complexity: O(1) - assuming that the sorting does not use extra space that is not constant