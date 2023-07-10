// This solution uses the concept of prefix product and suffix product to get the answer
// For nums[i] in the input array, we calculate the prefix product (the product of all the numbers to the left of i) and suffix product (the product of all the numbers to the right of i) 
// And then we multiply the two to get the answer

import java.util.Arrays;

public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProds = new int[n];
        int[] suffixProds = new int[n];
        prefixProds[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProds[i] = prefixProds[i - 1] * nums[i - 1];
        }
        suffixProds[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProds[i] = suffixProds[i + 1] * nums[i + 1];
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProds[i] * suffixProds[i];
        }
        return answer;
        // Time Complexity: O(n) - all three forloops take O(n) time and all the operations in the loops are constant time
        // Space Complexity: O(n) - suffixProds and prefixProds arrays take O(n) extra space
    }
    
}
