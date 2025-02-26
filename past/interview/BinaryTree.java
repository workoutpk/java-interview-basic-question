package past.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class BinaryTree {
    // Node class for the binary tree

    Node root;

    // BFS traversal using Queue
    public void breadthFirstSearch() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // Add left child to queue
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child to queue
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }


    // In-order traversal: Left -> Root -> Right
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // First traverse left subtree
        inOrderTraversal(node.left);

        // Then visit the root
        System.out.print(node.data + " ");

        // Finally traverse right subtree
        inOrderTraversal(node.right);
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // First visit the root
        System.out.print(node.data + " ");

        // Then traverse left subtree
        preOrderTraversal(node.left);

        // Finally traverse right subtree
        preOrderTraversal(node.right);
    }

    // Post-order traversal: Left -> Right -> Root
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // First traverse left subtree
        postOrderTraversal(node.left);

        // Then traverse right subtree
        postOrderTraversal(node.right);

        // Finally visit the root
        System.out.print(node.data + " ");
    }

    // Level-order traversal using Queue
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Remove the first node from queue
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // Add left child to queue if exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child to queue if exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Iterative In-order traversal using Stack
    public void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current is now null, pop an element from stack
            current = stack.pop();

            System.out.print(current.data + " ");

            // Set current to process the right subtree
            current = current.right;
        }
    }
    // DFS traversals
    // 1. Preorder traversal (Root -> Left -> Right)
    public void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // 2. Inorder traversal (Left -> Root -> Right)
    public void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // 3. Postorder traversal (Left -> Right -> Root)
    public void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Wrapper methods for DFS traversals
    public void dfsTraversals() {
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
    }
    // Main method to test the traversals
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creating a sample binary tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("In-order traversal (Recursive):");
        tree.inOrderTraversal(tree.root);  // Expected output: 4 2 5 1 3

        System.out.println("\nIn-order traversal (Iterative):");
        tree.inOrderIterative(tree.root);  // Expected output: 4 2 5 1 3

        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.root); // Expected output: 1 2 4 5 3

        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root); // Expected output: 4 5 2 3 1

        System.out.println("\nLevel-order traversal:");
        tree.levelOrderTraversal(tree.root); // Expected output: 1 2 3 4 5

        System.out.println();
        // Perform BFS
        tree.breadthFirstSearch();
        System.out.println("DFS traversals: ");
        // Perform all DFS traversals
        tree.dfsTraversals();

    }
}
