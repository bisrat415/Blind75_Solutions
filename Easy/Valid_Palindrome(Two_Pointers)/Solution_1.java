// This solution goes through the string and adds all the characters that are letters or digits to an ArrayList.
// Then it  iterates over half of the ArrayList arr (approximately n/2 iterations) and compares each element with its corresponding element from the other end of the ArrayList.

import java.util.ArrayList;

public class Solution_1 {
    public static void main(String[] args) {
        String s1 = "race a car"; // This should be false
        String s2 = "A man, a plan, a canal: Panama"; // This should be true
        System.out.println(isPalindrome(s2));
        
    }
    public static boolean isPalindrome(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                arr.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            if (arr.get(i) != arr.get(arr.size() - 1 - i)) {
                return false;
            }
        }
        return true;
        // Let n be the length of the input string s
        // Time Complexity: O(n) because the forloops are going through the string and the arraylist and the operations in the forloop are constant time
        // Space Complexity: O(n) because of the extra space used by the arraylist 

    }
}
