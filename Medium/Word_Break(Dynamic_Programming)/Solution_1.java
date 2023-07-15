// We use recursion with memoization to break down the problem into optimal subproblems, solve those subproblems and combine them to get the final solution
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakHelper(s, 0, wordDictSet, memo);    
    }
    public static boolean wordBreakHelper(String s, int start, Set<String> wordDictSet,  Boolean[] memo) {
        if (start == s.length()) {
	        return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        boolean result = false;
        for (int end = start + 1; end <= s.length(); end++) {
	        if (wordDictSet.contains(s.substring(start, end)) && wordBreakHelper(s, end, wordDictSet, memo)) {
		        result = true;
                break;
            }
        }
        memo[start] = result;
        return result;
    }
    // Let n be the length of the string, s
    // Time Complexity: O(n^3) - the recursive method is called for each character in the string which takes O(n) time. 
    // And in each recursive call we have a forloop that is proportional to the size of the substring that is passed so it takes O(n) time in the worst case. 
    // And the substring method takes O(n) time (For Java versions 7 and beyond substring takes O(1) time)
    // Space Complexity: O(n) - memo takes O(n) space and the height of the recursive call stack is also O(n) in the worst case
}
