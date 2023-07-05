// This solution compares the node value with its upper and lower limits if they are available. 
// Then repeats the same step recursively for left and right subtrees

public class Solution_1 {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }
        if ((left != null && left >= root.val) || (right != null && right <= root.val)) {
            return false;
        }
        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
        // Let n be the number of nodes in the tree and h be height of the tree
        // Time Complexity: O(n) because we are visting every node once
        // Space Complexity: O(h) - O(n) in the worst case (skewed tree) and O(logn) in the best case / average case (balanced tree)
    }

}
