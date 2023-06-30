// This solution uses BFS using queues (iterative)
// We will use a hash map to store the reference of the copy of all the nodes that have already been visited and copied. 
// The key for the hash map would be the node of the original graph and corresponding value would be the corresponding cloned node of the cloned graph. 
// The visited is used to prevent cycles and get the cloned copy of a node.
public class Solution_2 {
    public static void main(String[] args) {
        
    }
    public static Node CloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            for (Node neighbor : currNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                visited.get(currNode).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
        // Let n be the number of nodes and m be the number of edges
        // Time Complexity: O(n + m) - each node and each egde (neighbor) is visited exactly once during the BFS traversal. And all the other operations in the loop are constant time
        // Space Complexity: O(n) - the hashmap takes O(n) space and the queue takes O(w) where w is the width (breadth) of the graph. 
        //  The width of a graph refers to the maximum number of nodes at any "level" of the graph during the traversal
    }
}
