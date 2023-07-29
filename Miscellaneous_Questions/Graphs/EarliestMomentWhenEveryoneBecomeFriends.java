// This is a solution for Q.1101(The Earliest Moment When Everyone Become Friends)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solution #1 (DFS)
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

// Solution #2 (Union-Find)
class EarliestMomentWhenEveryoneBecomeFriends2 {

     public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        DisjointSet ds = new DisjointSet(n);
        int count = n;
        for (int[] log : logs) {
            int node1 = log[1];
            int node2 = log[2];
            if (!ds.areSameSet(node1, node2)) {
                ds.union(node1, node2);
                count--;
                if (count == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }
}

class DisjointSet {
    int[] roots;
    int[] ranks;
    public DisjointSet(int n) {
        this.roots = new int[n];
        this.ranks = new int[n];
        for (int i = 0; i < n; i++) {
            this.roots[i] = i;
            this.ranks[i] = 0;
        }
    }

    // Implement find with path compression
    public int find(int node) {
        if (roots[node] == node) {
            return node;
        }
        roots[node] = find(roots[node]);
        return roots[node];
    }

    public boolean areSameSet(int node1, int node2) {
        return find(node1) == find(node2);
    }

    // Implement union by rank
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
    // Let n be the total number of nodes and m be the total number of logs
    // Time Complexity: O(mlogm + n + mα(n)) - sorting logs takes O(mlogm)
    // Creating the disjoint set instance takes O(n) time because we have to populate the arrays roots and ranks
    // For each log we are calling our ds methods union and areSameSet and these methods take α(n) which represents the inverse Akermann Function which is almost constant for practical purposes

    // Space Complexity: O(n + space used by the sorting algorithm) - roots and ranks take O(n) space. 
    // In java the Arrays.sort() is implemented as a variant of quicksort algorithm whose space complexity is O(log⁡m)
}
