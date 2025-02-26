package dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BoundaryTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> boundary = boundaryTraversal(root);
        System.out.println("Boundary: "+boundary);
        BoundaryTraversal tree = new BoundaryTraversal();

        System.out.print("Leaf nodes: ");
        tree.printLeafNodesIteratively(root);
    }


    // Main function for boundary traversal
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Add root node
        result.add(root.data);

        // Traverse left boundary
        traverseLeftBoundary(root.left, result);

        // Traverse leaf nodes
        traverseLeafNodes(root.left, result);
        traverseLeafNodes(root.right, result);

        // Traverse right boundary in reverse order
        List<Integer> rightBoundary = new ArrayList<>();
        traverseRightBoundary(root.right, rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    private static void traverseLeftBoundary(Node node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void traverseLeafNodes(Node node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        traverseLeafNodes(node.left, result);
        traverseLeafNodes(node.right, result);
    }

    private static void traverseRightBoundary(Node node, List<Integer> result) {
        if (node == null) return;
        if (!isLeaf(node)) {
            traverseRightBoundary(node.right != null ? node.right : node.left, result);
            result.add(node.data); // Add after recursion for reverse order
        }
    }

    private static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }


    // Function to print leaf nodes
    private void printLeafNodesIteratively(Node root) {
        if (root == null) {
            return; // If the tree is empty, return
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            // Check if it's a leaf node
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " "); // Print leaf node value
            }

            // Push right child first so that left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}

