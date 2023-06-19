// This solution uses recursion to travel to the side of the tree that the nodes exist (we use the characterstics of a BST for this)
// And as soon as one is to the right and another is to the left of a given ancestor, we return that ancestor since it is the LCA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution_1 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    // Let n be the number of the number of nodes in the binary search tree and h be the height of the tree
    // Time Complexity: O(h) - O(n) for worst case (skewed BST) and O(logn) for best case (balanced BST)
    // Space Complexity: O(h) - O(n) for worst case (skewed BST) and O(logn) for best case / average case (balanced BST)
}
