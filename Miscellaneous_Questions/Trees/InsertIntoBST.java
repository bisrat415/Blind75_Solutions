// This is Q.701(Insert into a Binary Search Tree) from leetcode
// This solution uses recursion to go to the right spot in the tree and insert the node there


import javax.swing.tree.TreeNode;

    public static void main(String[] args) {

    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
        // Let n be the number of nodes in the tree and h be the height of the tree
        // Time Complexity: O(logn) on average assuming the tree is well balanced and O(n) in the worst case (when the tree is skewed)
        // Space Complexity: O(h) - O(n) in the worst case (skewed tree) and O(logn) in the best case (balanced tree)

    }
    
}
