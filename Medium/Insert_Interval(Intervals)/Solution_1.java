// Step 1: Insert the new interval in the right position
// Step 2: Then merge any intervals that are overlapping
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        LinkedList<int[]> mergedList = new LinkedList<>();
        mergedList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (mergedList.getLast()[1] >= intervals[i][0]) {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], intervals[i][1]);
            } else {
                mergedList.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> merged = new ArrayList<>(Arrays.asList(intervals));
        boolean isInserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                merged.add(i, newInterval);
                isInserted = true;
                break;
                }
        }
        if (!isInserted) {
            merged.add(newInterval);
        }
        return merged.toArray(new int[merged.size()][2]);
        // Let n be the total number of intervals
        // Time Complexity: O(n) - inserting newInterval into intervals takes O(n) time in the worst case (when we have to add it at the end). And then merging the overlapping intervals takes O(n) time as well
        // Space Complexity: O(n) - the arraylist merged we create in insertInterval takes O(n) space
    }
}
