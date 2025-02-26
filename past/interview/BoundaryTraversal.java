package past.interview;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.


public class BoundaryTraversal {

    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Add root node
        result.add(root.val);

        // Traverse the left boundary
        traverseLeftBoundary(root.left, result);

        // Traverse leaf nodes
        traverseLeafNodes(root, result);

        // Traverse the right boundary
        traverseRightBoundary(root.right, result);

        return result;
    }

    private void traverseLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If it's not a leaf node, add to result
        if (node.left != null || node.right != null) {
            result.add(node.val);
        }

        // First traverse left, then right
        if (node.left != null) {
            traverseLeftBoundary(node.left, result);
        } else {
            traverseLeftBoundary(node.right, result);
        }
    }

    private void traverseLeafNodes(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If it's a leaf node, add to result
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        // Traverse left and right children
        traverseLeafNodes(node.left, result);
        traverseLeafNodes(node.right, result);
    }

    private void traverseRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // First traverse right, then left
        if (node.right != null) {
            traverseRightBoundary(node.right, result);
        } else {
            traverseRightBoundary(node.left, result);
        }

        // If it's not a leaf node, add to result
        if (node.left != null || node.right != null) {
            result.add(node.val);
        }
    }

    public static void main(String[] args) {
        // Example usage:

        // Constructing the following binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //       / \
        //      8   9
        // Left Boundary: 1 → 2 → 4
        // Leaf Nodes: 4 → 8 → 9 → 6 → 7
        // Right Boundary (Reversed): 3 → 7
        // Boundary Traversal Output: 1 → 2 → 4 → 8 → 9 → 6 → 7 → 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        BoundaryTraversal bt = new BoundaryTraversal();
        List<Integer> boundaryNodes = bt.boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundaryNodes); // Output: [1, 2, 4, 8, 9, 6, 7, 3]
        System.out.println("traverseLeftBoundary: ");
    }
}
