package binary_tree;

public class BinaryT {
    static void main(String[] args) {
        Node root = new Node(4);
        Node left = new Node(5);
        Node right = new Node(6);

        root.setLeft(left);
        root.setRight(right);

        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);

        left.setLeft(nodeOne);
        left.setRight(nodeTwo);

        System.out.println("Root is: " + root.getData());
        System.out.println("Left is: " + root.getLeft().getData());
        System.out.println("Right is: " + root.getRight().getData());

        System.out.println("Left of left Node is: " + left.getLeft().getData());
        System.out.println("Right of left Node is: " + left.getRight().getData());
    }

}
