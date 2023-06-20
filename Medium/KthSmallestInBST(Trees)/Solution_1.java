// This is a recursive solution that traverses the BST inorder and adds each element into an arraylist and returns the (k-1) element in the arraylist 
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
import java.util.*;
public class Solution_1 {
    public static void main(String[] args) {

    }
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        // Let n be the number of nodes in the tree and h be the height of the tree
        // Time Complexity: O(n) because we are visiting each node once
        // Space Complexity: O(h) - O(n) in the worst case (skewed tree) and O(logn) in the best case / average case (balanced tree)
    }
}
