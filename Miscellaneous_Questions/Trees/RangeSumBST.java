// This is a solution for Q.938 (Range Sum of BST) from Leetcode

public class RangeSumBST {
    public static void main(String[] args) {
        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
		    return 0;
        }
        int sum = 0;
        if (root.val >= high) {
            sum += rangeSumBST(root.left, low, high);
        } else if (root.val <= low) {
	        sum += rangeSumBST(root.right, low, high);
        } else {
	        sum += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
	        sum += root.val;
        }
        return sum;
        // let n be the number of nodes in the tree and h be the height of the tree
        // Time Complexity: O(n) because we are visiting each node in the worst case
        // Space Complexity: O(h) - O(n) in the worst case (skewed BST) O(logn) in the best (average) case (balanced BST)
    }
}
