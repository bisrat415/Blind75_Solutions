import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(s, result, new ArrayList<>(), 0);
        return result;
    }
    public static void backTrack(String s,  List<List<String>> result, List<String> partition, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                partition.add(s.substring(index, i + 1));
                backTrack(s, result, partition, i + 1);
                partition.remove(partition.size() - 1);
            }
        }

    }
    public static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
    // Let n be the length of the string, s
    // Time Complexity: O(n * 2^n) - in the worst case (when all possible substrings are palindromes) there will be 2^n possible substrings and for each substrings it takes O(n) to  check if it's a palindrome or not and generate the substring
    // Space Complexity: O(n) because the maximum depth of the recursive call stack is bounded by n
}
