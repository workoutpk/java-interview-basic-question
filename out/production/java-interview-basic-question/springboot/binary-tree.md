I'll show you different ways to traverse a binary tree: In-order, Pre-order, Post-order, and Level-order traversal.



```java
public class BinaryTree {
    // Node class for the binary tree
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    Node root;
    
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
    }
}

```

This implementation includes:

1. **Node Class**: A basic structure for tree nodes containing data and references to left and right children.

2. **Traversal Methods**:
    - **In-order** (Left -> Root -> Right): Useful for getting elements in sorted order in a BST
    - **Pre-order** (Root -> Left -> Right): Useful for creating a copy of the tree or prefix expression
    - **Post-order** (Left -> Right -> Root): Useful for deleting the tree or postfix expression
    - **Level-order**: Visits nodes level by level from top to bottom
    - **Iterative In-order**: Non-recursive implementation using a stack

3. Key Features:
    - Both recursive and iterative implementations
    - Clear comments explaining the process
    - A test case in the main method
    - Queue-based implementation for level-order traversal
    - Stack-based implementation for iterative in-order traversal

The time complexity for all traversals is O(n) where n is the number of nodes in the tree. The space complexity is:
- O(h) for recursive traversals (where h is the height of the tree)
- O(n) for level-order traversal in the worst case
- O(h) for iterative in-order traversal

Would you like me to explain any specific traversal method in more detail or show how to modify the code for specific use cases?