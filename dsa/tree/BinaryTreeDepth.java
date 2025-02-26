package dsa.tree;

public class BinaryTreeDepth {
    Node root;
    // Method to find the depth of the tree
    public int findDepth(Node node) {
        // Base case: if tree is empty
        if (node == null) {
            return 0;
        }

        // Recursively compute the depth of left and right subtrees
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);
        System.out.println("leftDepth data :: " +node.left);
        System.out.println("leftDepth :: " +leftDepth);
        System.out.println("rightDepth :: " +rightDepth);
        // Return the larger depth plus 1 (for current node)
        return Math.max(leftDepth, rightDepth) + 1;
    }
    // Constructor
    BinaryTreeDepth() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTreeDepth tree = new BinaryTreeDepth();

        // Creating a sample tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
        System.out.println(tree.root);
//        System.out.println(tree.root.left);
//        System.out.println(tree.root.left.left);
        System.out.println("Depth of the binary tree is: " +
                tree.findDepth(tree.root));
    }
}
