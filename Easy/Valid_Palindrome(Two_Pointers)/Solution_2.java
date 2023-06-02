// This solution uses a while loop and two pointers to through the string from front and end and then compare the characters
public class Solution_2 {
    public static void main(String[] args) {
        String s1 = "race a car"; // This should be false
        String s2 = "A man, a plan, a canal: Panama"; // This should be true
        System.out.println(isPalindrome(s2));
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            Character start = s.charAt(i);
            Character end = s.charAt(j);
            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
             if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    // Let n be the length of the input string s
    // Time Complexity: O(n) because the whileloop is going through the string and the operations in the while are constant time
    // Space Complexity: O(n) because of the extra space used by the arraylist 
}
