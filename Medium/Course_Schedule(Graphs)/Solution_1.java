// This solution uses Khan's Algorithm to do find the topological sorting of the graph and figure out if there is a way to finish all courses (if there is a cycle we can't finish)
// For detailed explanation of Khan's Algorithm watch this video: https://www.youtube.com/watch?v=cIBFEhD77b4&t=2s
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{0, 3}, {1, 3}, {2, 0}, {2, 1}};
        System.out.println(canFinish(numCourses, prerequisites)); // prints true
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses2, prerequisites2));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses]; 
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int numCompletedCourses = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.remove();
            for (int neighbor : adjList.get(currCourse)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
            numCompletedCourses++;
        }
        return numCompletedCourses == numCourses;
        // Let n be the number of nodes and e be the number of edges (the size of the prerequisites array)
        // Time Complexity: O(n + e) - creating adjList takes O(e), creating indegree takes O(n) time. 
        // In the worst case each node will be pushed into the queue once taking O(n) time and removing each node from the queue and visiting all its neighbors takes O(e) time
        // So overall the time complexity is O(n + e)
        // Space Complexiy: O(n + e) - adjList takes O(e) space, indegree takes O(n) space and the queue takes O(n) space in the worst case. And that computes to O(n + e)
    }
}
