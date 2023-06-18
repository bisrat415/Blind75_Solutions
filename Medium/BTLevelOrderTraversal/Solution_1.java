// This is an iterative solution that utilizes a queue to scan through the tree with Breadth First Search (BFS) and add the nodes at the right place in the arraylist
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
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.remove();
                level.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
    // Let n be the number of nodes in the binary tree
    // Time Complexity: O(n) because we are visting each node once and all the operations in the loop are constant time
    // Space Complexity: O(n) because in the worst case, if the binary tree is a complete binary tree, the maximum number of nodes in the lowest level is N/2 (where N is the number of nodes in the binary tree) so we will have n / 2 elements in the queue at once
}
