// This is Q.450 (Delete Node in a BST) from leetcode
// This solution uses recursion to delete the required node

// There are three possible situations:
// 1: If the node to be deleted is a leaf just delete it by setting it to null
// 2: If the node to be deleted has a right child, find the successor (somewhere lower in the right subtree), replace the value of the node by the successor and delete the successor recursively
// 3: If the node to be deleted only has a left child, find the predecessor (somewhere lower in the left subtree), repace the value of the node with the predecessor and delete the predecessor recursively

public class DeleteFromBST {

    public static void main(String[] args) {

    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key == root.val) {
            if (root.right == null && root.left == null) {
                return null;
            } 
            if (root.right != null) {
                TreeNode suc = successor(root);
                root.val = suc.val;
                root.right = deleteNode(root.right, suc.val);
            } else {
                TreeNode pre = predecessor(root);
                root.val = pre.val;
                root.left = deleteNode(root.left, pre.val);
            }
            
        }
        return root;
        // Let n be the number of nodes in the tree and h be the height of the tree
        // Time Complexity: O(2n) in the worst case (the tree is skewed and we are deleting the root) which simplifies to O(n)
        // And O(2logn) in the best / average case (the tree is balanced and we are deleting the root) which simplifies to O(logn)
        // Space Complexity: O(h) - O(n) in the worst case(skewed tree) and O(logn) in the best case (balanced tree)
    }
    public TreeNode successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;

    }
    public TreeNode predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;

    }
    
}
