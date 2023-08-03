// This solution sorts the intervals using the ending times and uses a greedy approach to find the solution
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int k = Integer.MIN_VALUE;
        int result = 0;
        for (int[] interval : intervals) {
            int x = interval[0];
            int y = interval[1];
            if (x >= k) {
                k = y;
            } else {
                result++;
            }
        }
        return result;
        // Let n be the total number of intervals
        // Time Complexity: O(n) because we are traversing through intervals and all the
        // operations in the forloop are constant time
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }
}
