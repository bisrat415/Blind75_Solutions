// This solution uses DFS through recursion
// To make sure the graph is connected we count the number of nodes that were visited through the dfs and compare that with n
// We also make sure that the graph does not have any cycles 
// A graph contains no cycles if, and only if, the depth-first search never goes back to an already discovered node. We need to be careful though not to count trivial cycles of the form A → B → A that occur with most implementations of undirected edges.
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n , edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        // Solution #1 (DFS and Graph Theory) - Recursive
       List<List<Integer>> adjList = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           adjList.add(new ArrayList<Integer>());
       }
       for (int[] edge : edges) {
           adjList.get(edge[0]).add(edge[1]);
           adjList.get(edge[1]).add(edge[0]);
       }
       Set<Integer> seen = new HashSet<>();
       return dfs(adjList, 0, -1, seen) && seen.size() == n;
    }
    public static boolean dfs(List<List<Integer>> adjList, int currNode, int prevNode, Set<Integer> seen) {
        seen.add(currNode);
        for (int neighbor : adjList.get(currNode)) {
            if (seen.contains(neighbor) && neighbor != prevNode) {
                return false;
            }
            if (!seen.contains(neighbor)) {
                if (!dfs(adjList, neighbor, currNode, seen)) {
                    return false;
                }
            }
        }
        return true;
    }
    // Let n be the number of nodes and e be the number of edges
    // Time Complexity: O(n + e) - creating adjList takes O(n + e) time and in the worst case (when the graph is a connected) dfs takes O(n + e) time as well
    // Space Complexity: O(n + e) - adjList takes O(e) space (if you have e edges, you can have up to 2e entries in the adjacency list because the graph is undirected), and in the worst case (when the graph is a connected) seen takes O(n) space
}
