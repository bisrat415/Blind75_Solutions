// This is a solution for the Time Planner question from Pramp

// Question: Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies the duration requirement, return an empty array.
// Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
// Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.
// In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.

import java.util.*;
public class TimePlanner {
    public static void main(String[] args) {
        int[][] slotsA = {{10 ,50}, {60, 120}, {140, 210}};
        int[][] slotsB = {{0, 15}, {60, 70}};
        int dur = 8;
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, dur)));
    }
    public static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // your code goes here
    int ia = 0;
    int ib = 0;
    int[] result = new int[2];
    while (ia < slotsA.length && ib < slotsB.length) {
      int start = Math.max(slotsA[ia][0],slotsB[ib][0]);
      int end = Math.min(slotsA[ia][1],slotsB[ib][1]);
      if (end - start >= dur) {
        result[0] = start;
        result[1] = start + dur;
        return result;
      } 
      if (slotsA[ia][1] < slotsB[ib][1]) {
        ia++;
      } else {
        ib++;
      }
    }
    return new int[0];
  }
  // Let m be the length of slotsA and n be the length of slotsB
  // Time Complexity: O(n + m) - because in the worst case we might have to visit each interval in each array once and all the other operations in the while loop are constant time
  // Space Complexity: O(1) because we are only using constant extra space

}
