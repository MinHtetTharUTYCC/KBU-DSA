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
        return true;
    }
    public void inorder(){
        
    }
    public void preorder(){
        
    }
    public void postorder(){
        
    }
    public void deleting(){
        
    }
    
    public static void main(String[] args) {
        
        BSTree bst = new BSTree();
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
        bst.insert(3);
        bst.insert(9);
        System.out.println("Root "+bst.root.getData());

    
    }
    
}
