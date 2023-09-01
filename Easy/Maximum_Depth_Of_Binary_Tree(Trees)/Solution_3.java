// This is a recursive top-down solution
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
public class Solution_3 {
    private int answer;
    public static void main(String[] args) {
        
    }
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 1);
        return answer;
    }

    public void maxDepthHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepthHelper(root.left, depth + 1);
        maxDepthHelper(root.right, depth + 1);
        // Let n be the number of nodes and h be the height of the binary tree
        // Time Complexity: O(n) because we are visiting each node once
        // Space Complexity: O(h) - O(n) for the worst case (skewed binary tree) and O(logn) for the best case (balance tree)
    }
}
