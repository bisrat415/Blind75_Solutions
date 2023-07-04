// This is a solution for Q.977(Squares of a Sorted Array) from leetcode
// On the first solution, we put the square of each element in a new array and sort the array which takes O(nlogn) time
// In the second solution, we use the Two-Pointer approach to come up with O(n) solution

import java.util.Arrays;

public class SortedArraySquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    // Solution #1 (sort)
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squared = new int[n];
        for (int i = 0; i < n; i++) {
            squared[i] = nums[i] * nums[i];
        }
        Arrays.sort(squared);
        return squared;
        // Let n be the the length of the input array, nums
        // Time Complexity: O(nlogn) - the forloop takes linear time because we are just traversing through the input array once. And the sorting takes O(nlogn) so we take the dominant time
        // Space Complexity: O(1) - the output array (squared) will not be considered for space complexity analysis. And for the rest, we are only using constant extra space
    }
}
