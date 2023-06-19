// This is a recursive solution that has a helper method with one more parameter that keeps count of the level on each recursive call
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        int level = 0;
        levelOrderHelper(root, levels, level);
        return levels;



    }
    public static void levelOrderHelper(TreeNode root, List<List<Integer>> levels, int level) {
        if (root == null) {
            return;
        }
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        levelOrderHelper(root.left, levels, level + 1);
        levelOrderHelper(root.right, levels, level + 1);
    } 
    // Let n be the number of nodes in the binary tree and h be the height of the tree
    // Time Complexity: O(n) because we are visiting each node once
    // Space Complexity: O(h) - O(n) for worst case (skewed tree) and O(logn) for best case / average case (balanced tree)

    
}
