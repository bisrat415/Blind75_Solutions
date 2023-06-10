// In this solution we use brute force to go through each and every pair in the array, calcuate the area and pick the highest
public class Solution_1 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int currentArea = Math.min(height[i], height[j]) * width;
                maxArea = currentArea > maxArea ? currentArea : maxArea;
            }
        }
        return maxArea;
        // Time Complexity: O(n^2) because of the double forloop (n * (n - 1))/2
        // Space Complexity: O(1) - only constant extra space is used
    }
}
