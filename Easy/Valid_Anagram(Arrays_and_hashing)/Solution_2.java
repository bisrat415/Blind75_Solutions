// In this solution, we count occurrences of each letter in the two strings and compare them

class Solution_2 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarma";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        // We increment the count for each letter in s and decrement the count for each letter in t 
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        // We check if the count for every character is zero
        for (int c : counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
        // Let n be the maximum length of s and t
        // Time Complexity: O(n) - because we are looping through the string once and accessing the counter table is a constant time operation
        // Space Complexity: O(1) - although we do use extra space, the space complexity is O(1) because the counter array's size stays constant no matter how large n is
    }    
}
