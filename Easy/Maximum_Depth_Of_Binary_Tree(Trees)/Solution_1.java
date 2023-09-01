// This is an iterative approach
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
public class Solution_1 {
    public static void main(String[] args) {
        
    }
    public int maxDepth(TreeNode root) {
        // Solution #1 (Iterative Approach)
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);
        int currentDepth = 0;
        int depth = 0;
        while (!stack.isEmpty()) {
            currentDepth = depthStack.pop();
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                depth = Math.max(currentDepth, depth);
                stack.push(currentNode.left);
                stack.push(currentNode.right);
                depthStack.push(currentDepth + 1);
                depthStack.push(currentDepth + 1);
            }

        }
        return depth;
    }

}
