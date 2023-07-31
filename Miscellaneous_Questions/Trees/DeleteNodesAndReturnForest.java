// This is a solution for Q1110 (Delete Nodes And Return Forest)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeNode;

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
public class DeleteNodesAndReturnForest {
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> toDeleteSet = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int num : to_delete) {
            toDeleteSet.add(num);
        }
        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }
        helper(root);
        return result;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
    // Let n be the total number of nodes
    // Time Complexity: O(n) because we are visting each node once
    // Space Complexity: O(n) in the worst case (when the tree is skewed) and O(logn) in the best (average) case (when the tree is balanced)
    
}
