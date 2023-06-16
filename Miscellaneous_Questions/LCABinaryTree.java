// This is 236 (Lowest Common Ancestor of a Binary Tree) on leetcode
// The solution uses post order traversal through recursion to find the Lowest Common Ancestor of two given nodes in a binary tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LCABinaryTree {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
        // Let n be the number of the number of nodes in the binary tree and h be the height of the tree
        // Time Complexity: O(n) because we are traversing through the whole tree
        // Space Complexity: O(h) - if the tree balanced O(logn) otherwise O(n)
    }

    // Blind75 has the same question but with binary search trees in the medium section
}
