package dsa.tree;

public class BinaryExample2 {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        int value = 6;
        if (BinaryTree.searchDFS(root, value))
            System.out.println(
                    value + " is found in the binary tree");
        else
            System.out.println(
                    value + " is not found in the binary tree");
    }
}
