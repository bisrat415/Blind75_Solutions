// This is an iterative solution that uses a stack to make an inorder traversal along the tree and validate
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
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Integer prev = null;
        while (!s.isEmpty() || root != null) {
            while (root!= null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev >= root.val) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
        // Let n be the number of nodes in the tree and h be height of the tree
        // Time Complexity: O(n) because we are visiting each node once when the tree is a BST and all the other operations in the loops are constant time
        // Space Complexity: O(h) - O(n) in the worst case (skewed tree) and O(logn) in the best case (balanced tree)
    }
}
