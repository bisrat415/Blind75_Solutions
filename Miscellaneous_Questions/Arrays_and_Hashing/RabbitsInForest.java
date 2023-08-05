// This is a solution for Q.781(Rabbits in Forest) from Leetcode
// We uses a hashmap to store each unique color with the number of rabbits with that color
// For detailed description of this algorithm visit this link: https://leetcode.com/problems/rabbits-in-forest/solutions/3860087/clear-solution-with-comments-java-python/
import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        System.out.println(numRabbits(answers));
    }
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int answer : answers) {
            if (answer == 0) { // When it's the only Rabbit of its color
                sum++;
            } else if (!map.containsKey(answer) || map.get(answer) == 0) { // When a color appears for the first time
                map.put(answer, 1);
                sum += answer + 1;
            } else { // We saw this color already so we just add one to its count
                map.put(answer, map.get(answer) + 1);
                if (map.get(answer) > answer) { // if n + 1 rabbits said there are n rabbits with the same color as them, this group is full so we reset it to zero
                    map.put(answer, 0);
                }
            }
        }
        return sum;
        // Let n be the length of the array, answers
        // Time Complexity: O(n) because we are traversing through answers in a forloop and all the operations in the loop are constant time
        // Space Complexity: O(n) because of the hashmap (there might be n distinct groups in the worst case) 
    }
}
