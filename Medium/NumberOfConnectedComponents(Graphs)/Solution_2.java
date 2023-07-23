// This solution implements the Union-Find (Disjoint Set) data structure to find the number of connected components
public class Solution_2 {
    private static int[] roots;
    private static int[] ranks;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        roots = new int[n];
        ranks = new int[n]; //  represents an upper bound on the height of the tree rooted at that node
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }
        int numComponents = n;
        for (int[] edge : edges) {
            numComponents -= union(edge[0], edge[1]);
        }
        return numComponents;
    }

    // Implement find with path compression optimization
    public static int find(int node) {
        if (roots[node] == node) {
            return node;
        }
        roots[node] = find(roots[node]);
        return roots[node];
    }

     // Implement Union by rank 
    public static int union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        // If the nodes are already connected (they have the same root) return 0
        if (root1 == root2) {
            return 0;
        }

        // If the nodes are not connected yet, connect them and return 1
        //  The root of the set with a lower rank is attached to the root of the set with a higher rank
        if (ranks[root1] > ranks[root2]) {
            roots[root2] = root1;
        } else if (ranks[root2] > ranks[root1]) {
            roots[root1] = root2;
        } else {
            roots[root2] = root1;
            ranks[root1] += 1;
        }
        return 1;
    }

    // Let n be the total number of nodes and e be the total number of edges
    // Time Complexity: O(n + e*α(n)) - populating roots and ranks with their default starting values takes O(n) time. 
    // In the worst case, each edge may lead to a union operation, and for each union operation, there can be a find operation, which would give a time complexity of O(E * log n). 
    // However, due to the path compression and union by rank heuristics, the actual time complexity of the algorithm becomes closer to O(E * α(n)), where α(n) is the inverse Ackermann function, which is a very slow-growing function and can be considered as nearly constant for all practical purposes.
    
    // Space Complexity: O(n) because of the arrays roots and ranks
}
