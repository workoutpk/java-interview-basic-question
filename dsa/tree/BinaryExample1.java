package dsa.tree;

public class BinaryExample1 {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);

//        System.out.println("Example of  :::  "+root.toString());

        System.out.print("Inorder traversal before insertion: ");
        BinaryTree.inorder(root);
        System.out.println();

        int key = 6;
        root = BinaryTree.insert(root, key);

        System.out.print("Inorder traversal after insertion: ");
        BinaryTree.inorder(root);
        System.out.println();
    }
}
