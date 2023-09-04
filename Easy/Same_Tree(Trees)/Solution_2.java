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
public class Solution_2 {
    public static void main(String[] args) {
        
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        // Time Complexity: Since each node is visited exactly once, the time complexity can be expressed as O(N), where N is the total number of nodes in the larger tree.
        // Space Complexity: it is determined by the depth of the recursion, which corresponds to the height of the tree. In the worst case scenario, where the tree is completely unbalanced and resembles a linked list, the recursion stack can reach a depth of N. Therefore, the space complexity is O(N) in the worst case.
    }
}
