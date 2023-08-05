import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // We have three four people sections in one row: 
        // (2-5) - left section 
        // (4-7) - middle section
        // (6-9) - right section
        Map<Integer, Set<String>> taken = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNo = seat[1];
            if (seatNo == 1 || seatNo == 10) {
                continue;
            }
            Set<String> set = taken.computeIfAbsent(row, k -> new HashSet<>());
            if (seatNo >= 2 && seatNo <= 5) {
                set.add("left");
            }
            if (seatNo >= 4 && seatNo <= 7) {
                set.add("middle");
            }
            if (seatNo >= 6 && seatNo <= 9) {
                set.add("right");
            }
        }
        int numFourPeopleGroup = 2 * (n - taken.size()); // completely open rows will have two four people groups
        int[] openFPGCount = {2, 1, 1, 0}; // The index indicates the total number of occupied sections and the elements indicate the corresponding number of open four people group spaces
        for (Set<String> value : taken.values()) {
            numFourPeopleGroup += openFPGCount[value.size()];
        }
        return numFourPeopleGroup;
        // Let m be the total number of reserved seats
        // Time Complexity: O(m) because of the forloop that goes through reservedSeats. And the size of the hashmap is bounded by m
        // Space Complexity: O(m) - in the worst case (when there is at least one seat occupied in one of the sections in each row) the hashmap takes O(m) space
    }
}
