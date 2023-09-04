// This is an iterative approach to figure out if two trees are the same
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
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode first = queue.remove();
            TreeNode second = queue.remove();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        return true;
    }
    // Time Complexity: O(N), where N is the total number of nodes in the larger tree. The algorithm performs a level-order traversal of the two trees simultaneously, visiting each node once. This is because the algorithm needs to compare all the nodes in both trees to determine if they are identical.
    // Space Complexity: The space complexity is determined by the size of the queue used to store the nodes during the traversal. In the worst case, the queue can hold up to the maximum number of nodes at a single level in both trees. In a completely balanced binary tree, the maximum number of nodes at a level is approximately N/2 (where N is the total number of nodes). Therefore, the space complexity is O(N) in the worst case.
}
