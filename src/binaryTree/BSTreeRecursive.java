package binaryTree;

public class BSTreeRecursive {
    private Node root;

    public BSTreeRecursive() {
        root=null;
    }

    public void insert(int data){
        root = insertRecursive(root,data);
    }

    public Node insertRecursive(Node current,int data){
        if(current==null){
            System.out.println("Root node is: " + data);
            System.out.println("Finished");
            return new Node(data);
        }

        if(data < current.getData()){
            System.out.println("Coming Node: "+ data);
            System.out.println("Check Node: "+ current.getData() + " => going to the left subtree");
            current.setleft(insertRecursive(current.getleft(),data));
        }else if(data > current.getData()){
            System.out.println("Coming Node: "+ data);
            System.out.println("Check Node : "+ current.getData() + " => going to the right subtree");
            current.setright(insertRecursive(current.getright(),data));
        }

        return  current;
    }
    static void main(String[] args) {
        BSTreeRecursive bst = new BSTreeRecursive();
        bst.insert(5);
        bst.insert(7);
        bst.insert(77);
        bst.insert(4);
        bst.insert(3);
        bst.insert(9);
        System.out.println("Root "+bst.root.getData());


    }
}
