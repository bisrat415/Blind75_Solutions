// The straight-forward approach is to go through the array and find the minium element. But the question ask for a solution that runs in O(logn) time.
// So we use binary search that is customized to this question

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {
        if (nums.length == 1)  {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
        // Time Complexity: O(logn) because in each iteration, the search range is halved
        // Space Complexity: O(1) because we are using constant extra space

    }
}
