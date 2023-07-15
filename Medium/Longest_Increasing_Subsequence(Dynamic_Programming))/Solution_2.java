// This solution uses a special logic to build the longest increasing subsequence and then just return the size of that subsequence
// For more detail about the logic visit this link: https://leetcode.com/problems/longest-increasing-subsequence/editorial/
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums)); // Should print 4 because the longest increasing subsequence is
                                               // [2,3,7,101]
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> increasingSS = new ArrayList<>();
        increasingSS.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > increasingSS.get(increasingSS.size() - 1)) {
                increasingSS.add(nums[i]);
            } else {
                int index = binarySearch(nums[i], increasingSS);
                increasingSS.set(index, nums[i]);
            }
        }
        return increasingSS.size();
    }

    public static int binarySearch(int num, List<Integer> nums) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == num) {
                return mid;
            }
            if (num > nums.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    // Time Complexity: O(nlogn) - the forloop traverses through each element in the
    // array so it takes O(n) time
    // Binary search takes O(logn) time and it is inside the forloop. So in the
    // worst case the algorithm take O(nlogn)
    // Space Complexity: O(n) - when the input array is strictly increasing
    // increasingSS will have the same size as the input array

}
