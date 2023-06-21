// This solution splits the inorder array into two (using the root we get from the preorder array) and recursively solves it by th calling the method on the two chunks
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
    public static HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public static int preorderIdx = 0;

    public static void main(String[] args) {

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        int left = 0;
        int right = inorder.length - 1;
        return buildTreeHelper(preorder, left, right);


    }
    public static TreeNode buildTreeHelper(int[] preorder, int left, int right) {
       if (left > right) {
            return null;
        }
        int rootVal = preorder[preorderIdx];
        preorderIdx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, left, inorderMap.get(rootVal) - 1);
        root.right = buildTreeHelper(preorder, inorderMap.get(rootVal) + 1, right);
        return root;
        // Let n be the length of the array preorder or inorder (it's already given that preorder.length == inorder.length)
        // Time Complexity: O(n) - building the hashmap requires O(n) time. And we are visting each element in the arrays once (O(n)) and all the other operations are constant time
        // Space Complexity: O(n) - building the hashmap requires O(n) space. And the size of the call stack depends on the height of the tree which is O(n) in the worst case and O(logn) in the best / average case. 
        // So overall the space complexity is O(n)
    }
    
}
