// This is a solution for Q.14 (Longest Common Prefix) from Leetcode
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
        // Let n be the length of the array strs and m be the length of the shortest string
        // Time Complexity: O(n * m) because we are traversing strs once
        // And the length of the prefix gets reduced whenever it's not a prefix of the next string. Therefore, the length of the prefix can't be longer than the shortest string in the array.In terms of time complexity, the inner while loop keeps reducing the prefix until it matches the prefix of the current string, and in the worst case, it may have to reduce the prefix to the empty string, which would take a number of operations proportional to the length of the shortest string.

        // Space Complexity: O(1) because we are only using constant extra space
    }
}
