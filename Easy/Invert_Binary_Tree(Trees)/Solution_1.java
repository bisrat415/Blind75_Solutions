// This is an iterative solution that utilizes level order traversal using queue to solve the problem
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution_1 {
    public static void main(String[] args) {
        
    }
    public static TreeNode invertTree(TreeNode root) {
        // Solution #1 (Iterative Approach)
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                 queue.add(currentNode.right);
            
            }
        }
        return root;
        // Time Complexity = O(n)
        // Space Complexity = O(n) since in the worst case, the queue will contain all nodes in one level of the binary tree. And for a full binary tree the leaf level has n/2 nodes
    }
}
