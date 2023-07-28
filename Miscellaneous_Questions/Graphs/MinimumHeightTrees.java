// This file has two solutions for Q.310 (Minimum Height Trees) from Leetcode
// Solution one is a brute forced approach that caculated the depth of each tree that is created by considering each node as root and take the minimums of those
// The second solution uses Topological Sorting
// For detailed description of the algorithm for the second solution visit this link: https://leetcode.com/problems/minimum-height-trees/editorial/

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(n , edges));
        System.out.println(findMinHeightTrees2(n , edges));
    }

      // Solution #1 (Brute-Force)
     public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
      
        List<List<Integer>> adjList= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            int height = dfs(adjList, new HashSet<>(), i);
            heights[i] = height;
        }

        int minHeight = Integer.MAX_VALUE;
        for (int height: heights) {
            minHeight = Math.min(minHeight, height);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == minHeight) {
            result.add(i);
            }
        }
        return result;
        // Let n be the total number of nodes and e be the total number of edges. e is always n - 1 as specified by the question
        // Time Complexity: O(n^2) because we are calling dfs on each node and each dfs takes O(n) time
        // Space Complexity: O(n) - adjList takes O(n + e) = O(n + n - 1) = O(n) space. And the maximum depth of the recursive call stack for the dfs is O(n)

        // Solution #2 (Topological Sorting and the concept of centroids)
    }

    // Helper method for solution one 
    public static int dfs(List<List<Integer>> adj, Set<Integer> visited, int index){
      visited.add(index);
      int max = 0;
      for(int i = 0; i < adj.get(index).size(); i++){
        if(!visited.contains(adj.get(index).get(i))) {
          max = Math.max(max, dfs(adj, visited, adj.get(index).get(i)));
        }
        else{
          continue;
        }        
      }
      return 1 + max;
    }

    // Solution 2 (Topological Sorting and the concept of centroids)
    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n < 2) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key : adjList.keySet()) {
            if (adjList.get(key).size() == 1) {
                queue.offer(key);
            }
        }
        while (n > 2) {
            n -= queue.size();
            int s = queue.size();
            while (s > 0) {
                int currNode = queue.poll();
                for (int neighbor : adjList.get(currNode)) {
                    adjList.get(neighbor).remove(currNode);
                    if (adjList.get(neighbor).size() == 1) {
                        queue.offer(neighbor);
                    }
                }
                s--;
            }
        }
        return new ArrayList<>(queue);
        // Let n be the total number of nodes and e be the total number of edges. e is always n - 1 as specified by the question
        // Time Complexity: O(n) - constructing the graph takes O(e) = O(n - 1) = O(n) time. 
        // The bfs takes O(n + e) = O(n + n - 1) = O(n) time. 
        
        // Space Complexity: O(n) - adjList takes O(n + e) = O(n + n - 1) = O(n) space. And in the worst case (when the nodes form a star shape, with one centroid and the rest of the nodes as leaf nodes) the queue takes O(n) space
    }
}
