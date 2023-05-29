// In this solution we first convert the strings s and t to arrays and then sort the arrays. 
// This is based on the logic that if t is an anagram of s, sorting both strings will result in two identical strings

import java.util.Arrays;

class Solution_1 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarma";
        System.out.println(isAnagram(s, t));
        
    }
    public static boolean isAnagram(String s, String t) {
        // if s and t have different lengths, one can not be the anagram of another so we return early
        if (s.length() != t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
        // Let n be the maximum length of s and t
        // Time Complexity: O(nlogn) - sorting costs O(nlogn) and comparing the arrays costs O(n)
        // Space Complexity: O(n) - toCharArray costs O(n) space 
    }

}
