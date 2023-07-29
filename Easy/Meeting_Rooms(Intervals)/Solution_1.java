// This uses brute force 
public class Solution_1 {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean overlap(int[] meeting1, int[] meeting2) {
        return Math.min(meeting1[1], meeting2[1]) > Math.max(meeting1[0], meeting2[0]);
    }
    // Let n be the total number of intervals
    // Time Complexity: O(n^2) because of the forloop. And the method overlap takes constant time
    // Space Complexity: O(1) - we are only using constant extra space 
}
