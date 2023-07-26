// This is a solution for Q.17(Letter Combinations of a Phone Number) from Leetcode
// We use backtracking through recursion to comeup with all the possible combinations

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinations {
    public static Map<Character, String> map = new HashMap<>();
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backTrack(digits, result, 0, new ArrayList<>());
        return result;
    }
    public static void backTrack(String digits, List<String> result, int index, List<Character> currResult) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char ch : currResult) {
                sb.append(ch);
            }
            result.add(sb.toString());
            return;
        }
        char currChar = digits.charAt(index);
        String currRep = map.get(currChar);
        for (int i = 0; i < currRep.length(); i++) {
            currResult.add(currRep.charAt(i));
            backTrack(digits, result, index + 1, currResult);
            currResult.remove(currResult.size() - 1);
        }
    }
    // Let n be the length of digits
    // Time Complexity: O(4^n) - in the worst case (when the input consists of only 7s and 9s) we will have 4^n total combinations
    // Space Complexity: O(n) because of the recursive call stack
    // We don't consider result in our space complexity analysis because it is part of our output
}
