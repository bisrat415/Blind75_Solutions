// In this solution we first sort the array and follow the same two pointer pattern we use for Two Sum II
import java.util.*;
public class Solution_2 {
    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i < nums.length && nums[i] <= 0) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, result);
            } 
            i++;
        }
        return result;

    }
    public static void twoSumII(int[] nums, int i, List<List<Integer>> result) {
        int target = -1 * nums[i];
        int low = i + 1;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;
                while (low < high && nums[low - 1] == nums[low]) {
                    low++;
                }
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }

        }
    }
    // Let n be the size of the array
    // Time Complexity: O(n^2) - the helper function twoSumII is O(n) and we call that n times in the first while loop.
    // Sorting the array is O(nlogn) so the overall complexity is O(n^2 + nlogn) which is asymptotically equivalent to O(n^2) 
    // Space Complexity: if we consider the sorting algorithm it will be between O(logn) and O(n) depending on the implementation of the sorting algorithm
    // Otherwise it is O(1)
}
