package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // In-order DFS: Left, Root, Right
    static void inOrderDFS(Node node) {
        if (node == null) return;
        inOrderDFS(node.left);
        System.out.print(node.data + " ");
        inOrderDFS(node.right);
    }

    // Pre-order DFS: Root, Left, Right
    static void preOrderDFS(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderDFS(node.left);
        preOrderDFS(node.right);
    }

    // Post-order DFS: Left, Right, Root
    static void postOrderDFS(Node node) {
        if (node == null) return;
        postOrderDFS(node.left);
        postOrderDFS(node.right);
        System.out.print(node.data + " ");
    }

    // BFS: Level order traversal
    static void BFS(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


    // Function to insert a new node in the binary tree
    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        // Create a queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            // If left child is empty, insert the new node here
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                q.add(temp.left);
            }

            // If right child is empty, insert the new node here
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
        return root;
    }

    // In-order traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Function to search for a value in the binary tree
    // using DFS
    static boolean searchDFS(Node root, int value) {
        // Base case: If the tree is empty or we've reached
        // a leaf node
        if (root == null) return false;

        // If the node's data is equal to the value we are
        // searching for
        if (root.data == value) return true;

        // Recursively search in the left and right subtrees
        boolean left_res = searchDFS(root.left, value);
        boolean right_res = searchDFS(root.right, value);

        return left_res || right_res;
    }

    // Function to delete a node from the binary tree
    static Node deleteNode(Node root, int val) {
        if (root == null) return null;

        // Use a queue to perform BFS
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node target = null;

        // Find the target node
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == val) {
                target = curr;
                break;
            }
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        if (target == null) return root;

        // Find the deepest rightmost node and its parent
        Node lastNode = null;
        Node lastParent = null;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> parentQueue = new LinkedList<>();
        q1.add(root);
        parentQueue.add(null);

        while (!q1.isEmpty()) {
            Node curr = q1.poll();
            Node parent = parentQueue.poll();

            lastNode = curr;
            lastParent = parent;

            if (curr.left != null) {
                q1.add(curr.left);
                parentQueue.add(curr);
            }
            if (curr.right != null) {
                q1.add(curr.right);
                parentQueue.add(curr);
            }
        }

        // Replace target's value with the last node's value
        target.data = lastNode.data;

        // Remove the last node
        if (lastParent != null) {
            if (lastParent.left == lastNode) lastParent.left = null;
            else lastParent.right = null;
        } else {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        // Creating the tree
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);


        System.out.print("In-order DFS: ");
        inOrderDFS(root);
        System.out.print("\nPre-order DFS: ");
        preOrderDFS(root);
        System.out.print("\nPost-order DFS: ");
        postOrderDFS(root);
        System.out.print("\nLevel order: ");
        BFS(root);
    }
}
