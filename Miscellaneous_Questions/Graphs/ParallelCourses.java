import java.util.*;

public class ParallelCourses {
    public static void main(String[] args) {
        int[][] relations1 = {{1, 3}, {2, 3}};
         int[][] relations2 = {{1, 3}, {2, 3}, {3, 1}};
         System.out.println(minimumSemesters(0, relations1)); // prints 2
         System.out.println(minimumSemesters(0, relations2)); // prints -1
    }
    public static int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for (int[] relation : relations) {
            adjList.get(relation[0] - 1).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }
        Queue<int[]> queue = new LinkedList<>(); // the array has size two (i = 0 indicates the course number and i = 1 indicates the semester)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(new int[]{i, 1});
            }
        }
        int numCourseTaken = 0;
        while (!queue.isEmpty()) {
            int[] currCourse = queue.poll();
            numCourseTaken++;
            int courseNo = currCourse[0];
            int semester = currCourse[1];
            for (int neighbor : adjList.get(courseNo)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(new int[]{neighbor, semester + 1});
                }
            }
            if (n == numCourseTaken) {
                return semester;
            }
        }
        return -1;
        // Let n be the number of courses (vertices) and e be the number of relations (edges)
        // Time Complexity: O(n + e) - creating adjList takes O(n + e) and the BFS takes O(n + e) since have to visit every node and edge once in the worst case
        // Space Complexity: O(n + e) - adjList takes O(n + e) space and the size of the queue at a specific instance is bounded by the total number of nodes (n)
    }
}
