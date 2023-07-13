// This solution uses brute force to find the subarray that has the largest product, and return its product
public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currProd = 1;
            for (int j = i; j < nums.length; j++) {
                currProd *= nums[j];
                maxProd = Math.max(currProd, maxProd);
            }
        }
        return maxProd;
        // Let n be the length of nums  
        // Time Complexity: O(n^2) because of the double forloop. And all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
}
