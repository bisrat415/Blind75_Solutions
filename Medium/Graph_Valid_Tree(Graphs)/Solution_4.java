// This solution implements Union-Find to figure out if a graph is a tree or not
// We are using Union-Find to detect any cycles in which case the graph won't be a tree
public class Solution_4 {
    private static int[] roots;
    private static int[] ranks;
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n , edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        roots = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }

    // Implement find with path compression optimization
    public static int find(int node) {
        if (roots[node] == node) {
            return node;
        }
        roots[node] = find(roots[node]);
        return roots[node];
    }


    // Implement union by rank
    public static boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        // The nodes are already merged
        if (parent1 == parent2) {
            return false;
        }

        if (ranks[parent1] > ranks[parent2]) {
            roots[parent2] = parent1;
        } else if (ranks[parent2] > ranks[parent1]) {
            roots[parent1] = parent2;
        } else {
            roots[parent2] = parent1;
            ranks[parent1]++;
        }
        return true;
    }
    // Let n be the total number of nodes and e be the total number of edges
    // Time Complexity: O(n + e*α(n)) - populating roots and ranks with their default starting values takes O(n) time. 
    // In the worst case (e == n - 1), each edge may lead to a union operation, and for each union operation, there can be a find operation, which would give a time complexity of O(E * log n). 
    // However, due to the path compression and union by rank heuristics, the actual time complexity of the algorithm becomes closer to O(E * α(n)), where α(n) is the inverse Ackermann function, which is a very slow-growing function and can be considered as nearly constant for all practical purposes.
    
    // Space Complexity: O(n) because of the arrays roots and ranks
}
