// This is a solution for Q.344(Reverse String) 
// First solution uses two pointers, one at the start (index = 0) and one at the end (index = n - 1), swaps the characters on those positions and goes to the next pair to swap until we cover every pair
// The second solution uses the same logic as the first but through recursion
import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'b', 'i', 's', 'r', 'a', 't'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    // Solution #1 (Iterative)
    public static void reverseString(char[] s) {
        
        if (s == null) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        // Time Complexity: O(n) because of the while loop which takes O(n/2) time and we drop the constant coefficent(1/2)
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }

    // Solution #2 (Recursive)
    // An in-place algorithm is an algorithm which transforms input using no auxiliary data structure. 
    // So the space used by the recursive call stack does not matter as long as we don't any auxiliary data structures
    public static void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        reverseHelper(s, left, right);

    }
    public static void reverseHelper(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverseHelper(s, ++left, --right);
    }
    // Time Complexity: O(n) because the recursive method takes O(n/2) time and we drop the constant coefficient(1/2)
    // Space Complexity: O(n) because the maximum height of the recursive call stack is n/2
}
