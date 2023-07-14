// This solution uses dfs to figure out if there is a way to finish all courses (if there is a cycle we can't finish)
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{0, 3}, {1, 3}, {2, 0}, {2, 1}};
        System.out.println(canFinish(numCourses, prerequisites)); // prints true
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses2, prerequisites2)); // prints false
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] currPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjList, visited, currPath, i)) {
                return false;
            }
        }
        return true;

    }
    public static boolean dfs(List<List<Integer>> adjList, boolean[] visited, boolean[] currPath, int node) {
        // If we visit the node again while we were on the same path, there is a cycle
        if (currPath[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        currPath[node] = true;
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (dfs(adjList, visited, currPath, neighbor)) {
                return true;
            }
        }
        currPath[node] = false;
        return false;
    }
    // Let n be the number of nodes (numCourses) and e be the number of edges (the size of the prerequisites array)
    // Time Complexity: O(n + e) - creating adjList takes O(n + e) time. The dfs recursive call take O(n + e) because it handles each node once and then iterates over all the neighbors of that node 
    // Space Complexity: O(n + e) - adjList takes O(e) space and visit and currPath arrays take O(n) space each. And the height of the recursive call stack is bounded by n
}
