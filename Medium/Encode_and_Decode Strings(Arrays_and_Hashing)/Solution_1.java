// This solution uses non-ASCII unichar character as a delimeter (any char with ASCII number above 256)
import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");

        String str = encode(strs);
        List<String> strs2 = decode(str);
        System.out.println(strs.equals(strs2));

    }

    public static String encode(List<String> strs) {
        if (strs.size() == 0) {
            return null;
        }
        String d = String.valueOf((char) 257);
        // Create a string containing the values in strs separated by d
        StringBuilder sb = new StringBuilder();
        sb.append(strs.get(0));
        for (int i = 1; i < strs.size(); i++) {
            sb.append(d);
            sb.append(strs.get(i));
        }
        return sb.toString();

    }

    public static List<String> decode(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        String d = String.valueOf((char) 257);
        // return the list of the words that are created by splitting the string s using d 
        return Arrays.asList(s.split(d, -1));
    }
    // Time Complexity: O(n) - both encode and decode take O(n) time considering that split is O(n)
	// Space Complexity: O(1) - sb in encode and the arraylist in decode are both part of the output so they won't be considered in the space analysis
}
