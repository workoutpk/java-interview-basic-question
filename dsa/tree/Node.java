package dsa.tree;

// Class containing left and right child
// of current node and key value
class Node {
    //    int data;
//    int key;
//    Node left, right;
//    public Node(int item)
//    {
//        key = item;
//        left = right = null;
//    }
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        // Initialize and allocate memory for tree nodes
//        Node firstNode = new Node(2);
//        Node secondNode = new Node(3);
//        Node thirdNode = new Node(4);
//        Node fourthNode = new Node(5);
//
//        // Connect binary tree nodes
//        firstNode.left = secondNode;
//        firstNode.right = thirdNode;
//        secondNode.left = fourthNode;
    }
}
