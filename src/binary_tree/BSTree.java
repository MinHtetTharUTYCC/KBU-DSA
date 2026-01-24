package binary_tree;

public class BSTree {
    private Node root;

    public BSTree(){
        root = null;
    }

    public void insertion(int data){
        Node newNode = new Node(data);

        if(root == null) {
            root = newNode;
        }

        Node current = root;
        while (true) {
            if (data < current.getData()) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    return;
                } else {
                    current = current.getLeft();
                }
            } else if (data > current.getData()) {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    return;
                } else {
                    current = current.getRight();
                }
            }else{
                return;
            }
        }

    }
    public void deletion(){}

    public boolean searching(){
        return true;
    }

    public void inorder(){


    }
    public void preorder(){}
    public void postorder(){}

    static void main(String[] args) {

        BSTree bstree = new BSTree();
        bstree.insertion(5);
        bstree.insertion(9);
        bstree.insertion(4);
        bstree.insertion(1);
        bstree.insertion(3);

        System.out.println(bstree.root.getData());
        System.out.println(bstree.root.getLeft().getData());
        System.out.println(bstree.root.getRight().getData());
        System.out.println(bstree.root.getLeft().getLeft().getData());
        System.out.println(bstree.root.getLeft().getLeft().getRight().getData());



    }
}
