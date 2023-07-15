// This is a solution for Q.162(Find Peak Element) from Leetcode
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {3, 5, 9, 4, 2};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement2(nums));
    }

    // Solution #1 (Brute-Force)
    public static int findPeakElement(int[] nums) {
        // We only need to compare out current element to the element on it's right because when we reach a certain element in the forloop it will always be guaranteed that the element before it is less
        for (int i = 0; i < nums.length - 1; i++) {
	        if (nums[i] > nums[i + 1]) {
	            return i;
            }
        }
        return nums.length - 1;
        // Let n be the length of the input array, nums
        // Time Complexity: O(n) - we traverse through the array once and all the operations in the forloop are constant time
        // Space Complexity: O(1) - we are only using constant extra space 
    }

    // Solution #2 (Customized Binary Search)
     public static int findPeakElement2(int[] nums) {
        int left = 0;
	    int right = nums.length - 1;
	    while (left < right) {
		    int mid = (left + right) / 2;
		    if (nums[mid] > nums[mid + 1]) { // Peak is on the left side of mid
			    right = mid;
            } else { // Peak is on the right side of mid
	            left = mid + 1;
            }
        }
        return left;
        // Let n be the length of the input array, nums
        // Time Complexity: O(logn) - in each iteration of the while loop we are splitting our array into half and all the operations in the while loop are constant time
        // Space Complexity: O(1) - we are only using constant extra space 

     }
}
