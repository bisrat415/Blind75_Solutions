// This an implementation of binary search 
// It is Q.704(Binary Search) from leetcode
// Don't forget that an array should be first sorted before we try to use binary search on it
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while(first <= last) {
            int mid = (first + last) / 2;
            if (nums[mid] > target) {
                last = mid - 1;
            } else if (nums[mid] < target) {
                first = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
        // Time Complexity: O(nlogn): nums is divided into half each time
        // Space Complexity: O(1): During the loop, we only need to record three indexes, left, right, and mid, and they all take constant space.
    }
}