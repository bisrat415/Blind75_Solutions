// This solution first sorts the intervals array and then merges the overlapping intervals using a linkedlist as an auxiliary structure 
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> mergedList = new LinkedList<>();
        for (int[] interval : intervals) {
            if (mergedList.isEmpty() || interval[0] > mergedList.getLast()[1]) {
                mergedList.add(interval);
            } else {
                mergedList.getLast()[1] = Math.max(interval[1],  mergedList.getLast()[1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]); // Or you could just pass an array of size zero and the method will manage the size itself
        // Let n be the total number of intervals in the beginning
        // Time Complexity: O(nlogn) - sorting takes O(nlogn) time and the rest of the operations take less time
        // Space Complexity: O(n) - because of mergedList 
    }
}
