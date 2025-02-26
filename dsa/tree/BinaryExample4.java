package dsa.tree;

public class BinaryExample4 {
    static Node node;
    public static void printLeftNode(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        printLeftNode(root.left);
    }

    public static void printRightNode(Node root){
        if(root ==null){
            return;
        }
        System.out.println(root.data);
        printRightNode(root.right);
    }

    public static boolean hasLeaf(Node node){
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        printLeftNode(root);
        printRightNode(root);
    }
}
