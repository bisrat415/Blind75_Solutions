// This solution simplies solution 1 by using facts about valid trees (Advanced Graph Theory)
// A valid tree always has n-1 edges
// Graph with less than n-1 edges is definitely not connected
// Graph with greater than n-1 edges definitely has cycles
// Bases on these facts we can just check it n - 1 is equal to the length of edges. If not equal we just return false immediately because there this graph is definitely not a tree
import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {
         int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n , edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
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
        dfs(adjList, 0, seen);
        return n == seen.size();


    }
    public static void dfs(List<List<Integer>> adjList, int currNode, Set<Integer> seen) {
        seen.add(currNode);
        for (int neighbor : adjList.get(currNode)) {
            if (!seen.contains(neighbor)) {
                dfs(adjList, neighbor, seen);
            }
        }
    }
    // Let n be the number of nodes and e be the number of edges
    // Time Complexity: O(n) - creating adjList takes O(n + e) time. If the number of edges is not equal to n - 1 we will immediately return false. So in the worst case (when e == n - 1), it is guranteed for e to be less than n. 
    // That means creating adjList actually takes O(2n) which is just O(n)
    // In the worst case (when the graph is connected) the recursive method dfs2, will take O(n) time. So overall, the time complexity is O(n)

    // Space Complexity: O(n) - for the same reason provided in the time complexity analysis, adjList takes O(n) space.
    // In the worst case (the graph is connected), both seen and the recursive call stack take O(n) space. So overall, the space complexity is O(n)
}
