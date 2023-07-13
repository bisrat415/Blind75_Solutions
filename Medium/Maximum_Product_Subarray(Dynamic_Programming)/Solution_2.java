// This solution uses dynamic programming to solve smaller subproblems and come up with the final answer from those subproblems
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    
    public static int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = 1; // Maximum product subarray of all the elements before the curr element in the iteration
        int min = 1; // Minimum product subarray of all the elements before the curr element in the iteration
        for (int num : nums) {
            int temp = num * max;
            max = Math.max(num, Math.max(temp, num * min)); // It's important to check num * min as well because if both of them are negative their product will give a large positive number
            min = Math.min(num, Math.min(temp, num * min));
            answer = Math.max(max, answer);
        }
        return answer;
        // Let n the length of nums
        // Time Complexity: O(n) - we have one forloop that traverses through the array once and all the operations in the array are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
}
