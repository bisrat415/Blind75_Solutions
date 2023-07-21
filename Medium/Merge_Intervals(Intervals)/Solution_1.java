// This solution first sorts the intervals array and then merges the overlapping intervals using an arraylist as an auxiliary structure 
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
         List<int[]> mergedList = new ArrayList<>();
         int[] currInterval = new int[]{intervals[0][0], intervals[0][1]};
         int i = 1;
        while (i < intervals.length) {
            if (currInterval[1] >= intervals[i][0]) {
                currInterval = new int[]{currInterval[0], Math.max(currInterval[1], intervals[i][1])};
            } else {
                mergedList.add(new int[]{currInterval[0], currInterval[1]});
                currInterval = new int[]{intervals[i][0], intervals[i][1]};
            }
            i++;
        }
        mergedList.add(new int[]{currInterval[0], currInterval[1]});
        return mergedList.toArray(new int[mergedList.size()][2]); // Or you could just pass an array of size zero and the method will manage the size itself
        
        // Let n be the total number of intervals at the beginning
        // Time Complexity: O(nlogn) - sorting takes O(nlogn) time and the rest of the operations take less time 
        // traversing through the array with the while loop takes O(n) time and all the operations in the while loop are constant time
        // Space Complexity: O(n) because of mergedList
    }
}
