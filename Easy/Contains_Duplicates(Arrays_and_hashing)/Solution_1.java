// This is a brute force approach that employs the linear search algorithm (Checks if a particular value is in a list by checking each of its elements, one at a time and in sequence until the desired one is found.)
// We use a double for loop to go through all integers in nums. For the ith integer we search through all the integers after it and return true if there is a duplicate

class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {2, 8, 4, 5, 1, 4};
        System.out.println(containsDuplicate(nums));

    } 

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}

// Time Complexity: O(n^2) because we have a double for loop and there are n(n - 1)/2 integers to check
// Space Complexity: O(1) because we only use i and j as extra spaces and those are constant (not related to how many elements we have in our array, nums)