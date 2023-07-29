// This is a solution for Q.253 (Meeting Rooms II) from Leetcode
// We first sort the array and then use a minheap to add and remove elements based on the fact that the intervals overlap or not

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_RoomII {
    public static void main(String[] args) {
        int[][] intervals = {{5, 10}, {0, 30}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]); // Start from the first meeting and push the end time in the heap. So the root of heap will always carry the earliest ending meeting
        for (int i = 1; i < intervals.length; i++) {
            // If the root of the heap and the current interval don't overlap we remove from the heap because the room will be free
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
        // Let n be the total number of intervals
        // Time Complexity: O(nlogn) - sorting takes O(nlogn) and the forloop also takes O(nlogn) because we are traversing through the array once and the heap operations in the forloop take O(logn) time
        // Space Complexity: O(n) - in the worst case (when all the intervals overlap) we will have all the intervals in the heap
        // And we are assuming that the sorting of the array is done in-place
    }
}
