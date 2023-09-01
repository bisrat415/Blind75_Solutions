// This is a recursive bottom-up approach
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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        return 1 + Math.max(rightDepth, leftDepth);
        // Let n be the number of nodes and h be the height of the binary tree
        // Time Complexity = O(n) because we are visiting each node once
        // Space Complexity = O(h) - O(n) for worst case (completely unbalanced tree) and O(logn) for best case (completely balanced tree) 
    }
    
}
