// This is an iterative version of Solution #2 that uses bfs rather than dfs
import java.util.*;
public class Solution_3 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n , edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
         List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        seen.add(0);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int neighbor : adjList.get(currNode)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return seen.size() == n;
    }
    // Let n be the number of nodes and e be the number of edges
    // Time Complexity: O(n) - creating adjList takes O(n + e) time. If the number of edges is not equal to n - 1 we will immediately return false. So in the worst case (when e == n - 1), it is guranteed for e to be less than n. 
    // That means creating adjList actually takes O(2n) which is just O(n)
    // In the worst case (when the graph is connected) the while loop for bfs, will take O(n) time. So overall, the time complexity is O(n)

    // Space Complexity: O(n) - for the same reason provided in the time complexity analysis, adjList takes O(n) space.
    // In the worst case (the graph is connected), seen takes O(n) space. And the size of the queue is bound by n. So overall, the space complexity is O(n)
}
