package past.interview;

import dsa.map.MultiMapExample;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeExample1 {
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

    public void topTODown(Node node) {
        if (node == null) {
            return;
        }

    }

    public void leftToRight(Node node)  {
        if (node == null) {
            return;
        }
        BlockingQueue<Node> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add(node);
        while (!blockingQueue.isEmpty()){
            Node current =  blockingQueue.poll();

//            if(current.left != null){
//                blockingQueue.add(current.left);
//            }
            System.out.println(current.data);
            if(current.right != null){
                blockingQueue.add(current.right);
            }
        }

    }
    public static void main(String[] args) {
        BinaryTreeExample1 tree = new BinaryTreeExample1();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        System.out.println("In-order traversal (Recursive):");
//        tree.inOrderTraversal(tree.root);

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.right.left.left = new Node(8);
        tree.root.right.left.right = new Node(9);

        System.out.println("In-order traversal (Recursive):");
//        tree.inOrderTraversal(tree.root);
        //Output: [1, 2, 4, 7, 8, 9, 6, 3]
//        tree.leftToRight(tree.root);
        System.out.println("leftToRight: ");
        tree.leftToRight(tree.root);

    }
}
