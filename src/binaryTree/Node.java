package binaryTree;

public class Node {
    private Node left;
    private Node right;
    private int data;
    
    public Node(int data){
        this.data=data;
        left=right=null;
    }
    public void setleft(Node left){
        this.left=left;
    }
    public void setright(Node right){
        this.right=right;
    }
    public int getData(){
        return data;
    }
    public Node getright(){
        //System.out.println("Right child node : "+right.getData());
        return right;
    }
    public Node getleft(){
        //System.out.println("Left child node : "+left.getData());
        return left;
    }
}
