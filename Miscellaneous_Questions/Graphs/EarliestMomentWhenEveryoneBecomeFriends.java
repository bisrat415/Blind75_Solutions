// This is a solution for Q.1101(The Earliest Moment When Everyone Become Friends)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {
        int[][] logs = {{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}};
        System.out.println(earliestAcq(logs, 4));
    }

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] log : logs) {
            int time = log[0];
            int person1 = log[1];
            int person2 = log[2];
            adjList.get(person1).add(person2);
            adjList.get(person2).add(person1);
            boolean[] visited = new boolean[n];
            int count = dfs(adjList, person1, visited);
            if (count == n) {
                return time;
            }
        }
        return -1;
        // Let m be the number of logs and n be the number of people
        // Time Complexity: O(max(mlogm, m*n)) - sorting the logs arrays O(mlogm) and
        // the forloop along with the recursive dfs takes O(m*n). So we take the max
        // Space Complexity: O(m*n) - adjList takes O(m*n) space and the depth of the
        // recursive call stack is bounded by n
    }

    public static int dfs(List<List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(adjList, neighbor, visited);
            }
        }
        return count;
    }
}
