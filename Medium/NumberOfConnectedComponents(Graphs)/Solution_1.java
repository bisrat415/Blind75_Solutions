// This solution uses dfs through recrusion to solve the problem
// We try start a dfs through each node in the graph and visit every neighbor during that specifc dfs until we reach a deadend in which case we went through all the nodes in one connected component of a graph
//  Each time we finish exploring a connected component, we can find another vertex that has not been visited yet, and start a new DFS from there. 
// The number of times we start a new DFS will be the number of connected components.
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }
    public static int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int numComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, i);
                numComponents++;
            }
        }
        return numComponents;
    }

    public static void dfs(List<List<Integer>> adjList, boolean[] visited, int startNode) {
        visited[startNode] = true;
        for (int neighbor : adjList.get(startNode)) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor);
            }
            
        }
    }
    // Let n be the total number of nodes and e be the total number of edges
    // Time Complexity: O(n + e) - creating adjList takes O(n + e) time and the dfs takes O(n) time (we only call dfs if a node has not been visited yet)
    // Space Complexity: O(n + e) because of the adjList arraylist which takes O(e) space (if you have e edges, you can have up to 2e entries in the adjacency list because the graph is undirected), the visited array which takes O(n) space and the recursive call stack which can take O(n) space in the worst case (if all the nodes are connected)
}
