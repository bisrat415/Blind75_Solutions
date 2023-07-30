// This file contains two solutions for Q.366 (Find Leaves of Binary Tree) from Leetcode
// Solution #1 uses calls dfs to the all the way down to the leaves add them to result and then delete them and it does this until root becomes null
// Solution #2 uses the uniqueness of the heights for each leaf levels to organize the nodes in the right place in the arraylist

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBT {
    public static void main(String[] args) {
        
    }

    // Solution #1 (DFS until root becomes null)
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
           root = helper(root, leaves);
           result.add(leaves);
        }
        return result;
        // Let n be the total number of nodes
        // Time Complexity: O(n) - because each node in the tree is only processed once: it's either identified as a leaf and removed, or identified as a non-leaf and passed over to helper
        // Space Complexity: o(n) in the worst case (when the tree is skewed) and O(logn) in the best (average) case (when the tree is balanced) 
    }

    // Solution #2 (DFS once and use height of each node as a factor for organizing the leaves in the right place in the results array) 
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
        // Let n be the total number of nodes
        // Time Complexity: O(n) because we are visting each node once
        // Space Complexity: O(n) in the worst case (when the tree is skewed) and O(logn) in the best (average) case when the tree is balanced
    }

    // Solution #1 Helper
    public static TreeNode helper(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }
        root.left = helper(root.left,leaves);
        root.right = helper(root.right, leaves);
        return root;
    }

    // Solution #2 Helper
    public static int height(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left, result);
        int rightHeight = height(root.right, result);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        if (result.size() == currHeight) {
            result.add(new ArrayList<>());
        }
        result.get(currHeight).add(root.val);
        return currHeight;
    }



}
