
// Question: Given a binary array nums, return the maximum number of consecutive 1's in the array.
// We solve it through a one pass approach using two variables 
public class FindMaxConsecutiveOnesI {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(maxConsecutiveOnesI(nums));
    }

    public static int maxConsecutiveOnesI(int[] nums) {
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length++;
            } else {
                maxLength = length > maxLength ? length : maxLength;
                length = 0;
            }

        }
        return Math.max(length, maxLength);
        // Time Complexity: O(n) because the forloop is going through the array once and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we only use constant extra space
    }

}
