// This is a recursive solution for Q.1325 (Delete Leaves With a Given Value) from Leetcode

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

public class DeleteLeavesWithGivenValue {
    public static void main(String[] args) {
        
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
        // Time Complexity: O(n) because we are visiting each node once
        // Space Complexity: - It is determined by the maximum depth of the recursive call stack. And that is O(n) in the worst case (when the tree is skewed) and O(logn) in the best (average) case (when the tree is balanced)
    }
}
