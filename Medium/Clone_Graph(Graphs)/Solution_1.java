// This solution uses DFS through recursion to solve the problem
// We would take a hash map to store the reference of the copy of all the nodes that have already been visited and cloned. 
// The key for the hash map would be the node of the original graph and corresponding value would be the corresponding cloned node of the cloned graph. 
// If the node already exists in the visited we return corresponding stored reference of the cloned node

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.HashMap;

public class Solution_1 {
    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    public static Node cloneGraphHelper(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val);
        visited.put(node, clone);
        List<Node> cloneNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            cloneNeighbors.add(cloneGraphHelper(neighbor, visited));
        }
        clone.neighbors = cloneNeighbors;
        return clone;
    }
    // Let n be the number of nodes and m be the number of edges
    // Time Complexity: O(n + m) - The 'n' term is for visiting each node in the
    // graph and putting it in the map.
    // The 'm' term is for visiting each edge in the graph, as each edge represents
    // a relationship (neighbor) between two nodes

    // Space Complexity: O(n) - because of the hashmap that stores each node along
    // with its clone and the recursive call stack has a height of O(n) in the worst
    // case (when the graph is a linked list)
}
