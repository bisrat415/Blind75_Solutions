// This solution solves the problem iteratively using a stack to help us make inorder traversal of the BST
// We decrement k by 1 on every iteration of the while loop and when k reaches 0, we return root.val 
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
public class Solution_2 {
    public static void main(String[] args) {

    }
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        // Let n be the number of nodes in the tree and h be the height of the tree
        // Time Complexity: O(h + k) - before starting to pop out, one has to go down to a leaf.
        // So it is O(logn + k) for a balanced tree and O(n + k) for skewed
        // Space Complexity: O(h) - O(n) in the worst case (skewed tree) and O(logn) in the best / average case (balanced tree) 
    }
    
}
