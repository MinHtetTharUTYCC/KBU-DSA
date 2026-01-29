package binaryTree;

public class BSTree {
    private Node root;
    
    public BSTree(){
        root = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);
        System.out.println("newnode "+newNode.getData());
        
        if(root==null){
            root=newNode;
            System.out.println("Root");
            return;
        }
      
        Node current = root;

        
        while(true){
           
            if(data<current.getData()){
                if(current.getleft()==null){
                    current.setleft(newNode);
                    current=newNode;
                    System.out.println("Left");
                    return;
                }else{
                    current=current.getleft();
                }
                             
            }else if(data>current.getData()){
                
                if(current.getright()==null){
                    current.setright(newNode);
                    current=newNode;
                    System.out.println("Right");
                    return;
                }else{
                    current=current.getright();
                }
                
            }else{
                return;
            }
                    
        }

    }

    public boolean searching(int data){
        if(root == null){
            return false;
        }

        Node current = root;

        while(current != null){
            if(data == current.getData()){
                return true;
            }else if(data < current.getData()){
                current = current.getleft();
            }else{
                current = current.getright();
            }
        }

        return false;
    }

    // left,root,right
    public void inorder(){
        inorderHelper(root);
        System.out.println();
    }
    private void inorderHelper(Node node){
        if(node == null){
            return;
        }
        inorderHelper(node.getleft());
        System.out.print(node.getData() + " ");
        inorderHelper(node.getright());
    }


    // root,left,right
    public void preorder(){
        preorderHelper(root);
        System.out.println();
    }
    private void preorderHelper(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " ");
        preorderHelper(node.getleft());
        preorderHelper(node.getright());
    }


    // left,right,root
    public void postorder(){
        postorderHelper(root);
        System.out.println();
    }
    private void postorderHelper(Node node){
        if(node == null){
            return;
        }
        postorderHelper(node.getleft());
        postorderHelper(node.getright());
        System.out.print(node.getData() + " ");
    }

    public void deleting(int data){
        root = deleteHelper(root, data);
    }
    private Node deleteHelper(Node node, int data){
        if(node == null){
            return null;
        }

        if(data < node.getData()){
            node.setleft(deleteHelper(node.getleft(), data));
        }else if(data > node.getData()){
            node.setright(deleteHelper(node.getright(), data));
        }else{
            // Node with only one child or no child
            if(node.getleft() == null){
                return node.getright();
            }else if(node.getright() == null){
                return node.getleft();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.setData(minValue(node.getright()));

            // Delete the inorder successor
            node.setright(deleteHelper(node.getright(), node.getData()));
        }

        return node;
    }

    private int minValue(Node node){
        int minValue = node.getData();
        while(node.getleft() != null){
            minValue = node.getleft().getData();
            node = node.getleft();
        }
        return minValue;
    }
    
    public static void main(String[] args) {
        
        BSTree bst = new BSTree();
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
        bst.insert(3);
        bst.insert(9);

        if(bst.searching(7)){
            System.out.println("Found 7");
        }else{
            System.out.println("Not Found 7");
        }

        bst.inorder();
        bst.preorder();
        bst.postorder();

        bst.deleting(7);
        bst.deleting(5);
        bst.deleting(4);
        bst.deleting(3);
        bst.deleting(9);
        bst.inorder();

    
    }
    
}
