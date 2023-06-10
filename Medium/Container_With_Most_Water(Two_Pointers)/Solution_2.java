// In this solution we will have two pointers (one from the beginning and one from the end)
// And then we calculate the area of the space created from those pointers, update maxArea and move the smaller pointer

public class Solution_2 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int currArea = Math.min(height[left], height[right]) * width;
            maxArea = currArea > maxArea ? currArea : maxArea;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    // let n be the size of the array
    // Time Complexity: O(n) because the while loop is going through the array once and all the operations in the loop are constant time
    // Space Complexity: O(1) - only contant extra space used
}
