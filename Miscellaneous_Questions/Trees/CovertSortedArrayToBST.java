// This is a solution for Q.108(Convert Sorted Array to Binary Search Tree)

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class CovertSortedArrayToBST {
    public static void main(String[] args) {

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        TreeNode root = helper(nums, left, right);
        return root;
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
    // Time Complexity: O(n) because we are visiting each node once
    // Space Complexity: O(logn) - the maximum depth of the recursive call stack is
    // logn because the tree is balanced
}
