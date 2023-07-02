// This solution uses recursion to solve the problem
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
public class Solution_2 {
    public static void main(String[] args) {
        
    }
    public static TreeNode invertTree(TreeNode root) {
         if (root == null){
            return root;
        }
        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
        // Let n be the number of nodes in the binary tree
        // Time Complexity = O(n) since each node in the tree is visited only once
        // Space complexity = O(n) because the number of function calls we have on the stack is proportional to the height of the tree (the longest path from the root to a leaf node). And the worst case is when all the nodes in the tree only have a single child in which case the height == the total number of nodes 
    }

}
