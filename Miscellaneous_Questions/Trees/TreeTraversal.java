import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class TreeTraversal {
    Node root;

    public TreeTraversal() {
        root = null;
    }

    // Pre-order traversal
    private void preOrderTraversal(Node node) {
        if (node == null)
            return;

        // Visit the current node
        System.out.print(node.data + " ");

        // Recursively traverse the left subtree
        preOrderTraversal(node.left);

        // Recursively traverse the right subtree
        preOrderTraversal(node.right);
    }
    // Post-order traversal
    private void postOrderTraversal(Node node) {
        if (node == null)
            return;

        // Recursively traverse the left subtree
        postOrderTraversal(node.left);

        // Recursively traverse the right subtree
        postOrderTraversal(node.right);

        // Visit the current node
        System.out.print(node.data + " ");
    }

    

    // In-order traversal
    private void inOrderTraversal(Node node) {
        if (node == null)
            return;

        // Recursively traverse the left subtree
        inOrderTraversal(node.left);

        // Visit the current node
        System.out.print(node.data + " ");

        // Recursively traverse the right subtree
        inOrderTraversal(node.right);
    }

    // Level-order traversal
    private void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    public static void main(String[] args) {
       TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Pre-order traversal of the binary tree:");
        tree.preOrderTraversal();

        System.out.println("Post-order traversal of the binary tree:");
        tree.postOrderTraversal();

        System.out.println("\nIn-order traversal of the binary tree:");
        tree.inOrderTraversal();

        System.out.println("\nLevel-order traversal of the binary tree:");
        tree.levelOrderTraversal();
    }
}

