// This is a solution for Q.66(Plus One) from Leetcode
// If the current number is 9 we change it to zero and go to the next iteration
// Otherwise add one to that number and return the array

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        int[] digits1 = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(digits1)));
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;

        // Let n be the number of elements in the array, digits
        // Time Complexity: O(n) because we are going through the array once
        // Space Complexity: O(n) - in the worst case where the number of digits increases by one, we have to create a new array with size n + 1
    }
}
