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
}
