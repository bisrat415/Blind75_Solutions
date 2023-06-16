// We first find the pivot index
// Then we figure out on which side the target might be (before the pivot or after the pivot) and we a call binary search on that side
public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);
        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }
        if (pivotIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        }
        return binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
    }

    public static int findPivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return 0;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;

    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    // Time Complexity: O(logn) because both helper methods (findPivotIndex and
    // binarySearch) run in O(logn) time
    // Space Complexity:O(1) because we are only using constant extra space

}
