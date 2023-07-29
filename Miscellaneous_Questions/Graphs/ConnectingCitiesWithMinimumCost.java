import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {

    class DisjointSet {
        int[] roots;
        int[] ranks;

        public DisjointSet(int n) {
            roots = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int node) {
            if (roots[node] == node) {
                return node;
            }
            roots[node] = find(roots[node]);
            return roots[node];
        }

        public boolean areInSameSet(int node1, int node2) {
            return find(node1) == find(node2);
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                if (ranks[root1] > ranks[root2]) {
                    roots[root2] = root1;
                } else if (ranks[root2] > ranks[root1]) {
                    roots[root1] = root2;
                } else {
                    roots[root2] = root1;
                    ranks[root1]++;
                }
            }
        }
    }

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        DisjointSet ds = new DisjointSet(n);
        int count = 1;
        int total = 0;
        for (int[] connection : connections) {
            int node1 = connection[0];
            int node2 = connection[1];
            if (!ds.areInSameSet(node1 - 1, node2 - 1)) {
                ds.union(node1 - 1, node2 - 1);
                count++;
                total += connection[2];
            }
        }
        return count == n ? total : -1;
        // Let n be the number of nodes and m be the number of edges
        // Time Complexity: O(mlogm) - sorting takes O(mlogm). The disjoint set methods
        // take constant time for all practical purposes (Inverse Ackermann Function) so
        // the forloop takes O(m) time
        // Space Complexity: O(n) because of the arrays roots and ranks
    }
}
