// This solution first sorts the array to come up with a better complexity solution than Solution #1
import java.util.*;
public class Solution_2 {
     public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i + 1]; 
            if (meeting1[1] > meeting2[0]) {
                return false;
            }
        }
        return true;
    }
    // Let n be the total number of intervals
    // Time Complexity: O(nlogn) - because sorting takes O(nlogn) and the forloop takes O(n) because we are traversing through the array once and all the operations in the forloop are constant time
    // Space Complexity: O(1) because we only using constant extra space 
}
