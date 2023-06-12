// This file implements a function that takes in two strings and returns true if the second string is substring of the first, and false otherwise
import java.util.*;
public class isSubstring {
    public static void main(String[] args) {
        String str = "laboratory";
        String potentialSubStr = "ory";
        System.out.println(isSubstring(str, potentialSubStr));
        
    }
    public static boolean isSubstring(String str, String potentialSubStr) {
        int strLength = str.length();
        int subStrLength = potentialSubStr.length();
        if (strLength < subStrLength) {
            return false;
        }
        for (int i = 0; i <= strLength - subStrLength; i++) {
            for ( int j = 0; j < subStrLength; j++) {
                if (str.charAt(i + j) != potentialSubStr.charAt(j)) {
                    break;
                }
                if (j == subStrLength - 1) {
                    return true;
                }
            }
           
        }
        return false;
    }
    // let n be the length of str and m be the length of potentialStr
    // Time Complexity: O(n * m) - the outer loop runs (n - m) + 1 times and the inner loop runs m times. 
    // Therefore, the overall complexity is m * ((n - m) + 1) which becomes O(m * n). And the operations in the loop are constant time.
    
    // Space Complexity: O(1) - because we only used constant extra space
}
