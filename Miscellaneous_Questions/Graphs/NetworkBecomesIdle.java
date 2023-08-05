import java.util.*;
public class NetworkBecomesIdle {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}};
        int[] patience = {0, 2, 1};
        System.out.println(networkBecomesIdle(edges, patience));
    }

    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] shortestDistance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int neighbor : adjList.get(currNode)) {
                if (!visited.contains(neighbor)) {
                    shortestDistance[neighbor] = 1 + shortestDistance[currNode];
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        int earliestIdleTime = 0;
        for (int i = 0; i < n; i++) {
            int lastSend = calculateLastSend(shortestDistance[i], patience[i]);
            int lastReceived = lastSend + 2 * shortestDistance[i];
            earliestIdleTime = Math.max(lastReceived, earliestIdleTime);
        }
        return earliestIdleTime + 1;

    }
    public static int calculateLastSend(int shortestDis, int patience) {
        if (patience >= shortestDis * 2) {
            return 0;
        }
        if ((shortestDis * 2) % patience == 0) {
            return shortestDis * 2 - patience;
        }
        return shortestDis * 2 - (shortestDis * 2) % patience;

    }
    // Let n be the total number of nodes (length of the array, patience) and e be the total number of edges
    // Time Complexity: O(n + e) - creating adjList takes O(n + e) time. And the bfs also takes O(n + e)
    // Space Complexity: O(n + e) - adjList takes O(n + e) space. visited and shortestDistance both take O(n) space so overall the space complexity will be O(n + e)
}
