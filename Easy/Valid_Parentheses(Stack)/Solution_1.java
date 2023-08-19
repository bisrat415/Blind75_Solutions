// This solution uses a stack (to take advantage of the last-in-first-out characteristics) and a hashmap (to store the opening brackets with their matching closing brackets) 
import java.util.*;
public class Solution_1 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!stack.isEmpty()) {
                    Character temp = stack.pop();
                    if (temp != map.get(s.charAt(i))) {
                    return false;
                    }
                 } else {
                     return false;
                 }
            } else {
                stack.push(s.charAt(i));
            }
            
        }
        return stack.isEmpty();

        // Time complexity: O(n) because we are traversing through the array once and all the operations in the forloop are constant time
        // Space complexity: O(n) - in the worst case (when all the characters in the input string are opening brackets) the stack will have n element. And the map takes O(1) space
    }
}