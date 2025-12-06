
public class LinkedList2 {

    private Node header;
    private Node tail;
    
    public LinkedList2(){
        header=null;
    }
    public void delFirst(){
        if(header==null){
            System.out.println("No Node in the Linked list");
        }else if(header==tail){
            header=tail=null;
        }else{
            Node temp=header.getNext();
            header=temp;
        }
    }
    public void delLast(){
        if(header==null){
            System.out.println("No Node in the Linked list");
        }else if(header==tail){
            header=tail=null;
        }else{
            Node temp = header;
            do{
                temp=temp.getNext();
            }while(temp.getNext()!=tail);
            tail=temp;
        }
    }
    public void delAnyPos(){
        
    }
    public void traverse(){
        if(header==null){
            System.out.println("No node in the Linked list");
        }else{
            Node curr=header;
            do{
                System.out.println("Node in the list : "+curr.getData());
                curr=curr.getNext();
            }while(curr.getNext()!=null);
        }
    }
    public void searching(int data){
        if(header==null){
            System.out.println("No Node in the Linked list");
        }else{
            Node curr = header;
            do{
                if(curr.getData()==data){
                    System.out.println("Yes this node is in the Linked list");
                }
                curr=curr.getNext();   
            }while(curr.getNext()!=null);
        }
    }
    public Node getHeader(){
        System.out.println("The header node is : "+header.getData());
        return header;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(header==null){
            header=newNode;
            tail=newNode;
        }else{
            newNode.setNext(header);
            header=newNode;
        }    
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(header==null){
            header=newNode;
            tail=newNode;
        }else{
            tail.setNext(newNode);
            tail=newNode;
        }
    }
    public Node getTail(){
        System.out.println("Tailer of This Likedlist : "+tail.getData());
        return tail;
    }
    public void addAnyPos(){
        
    }
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.getHeader();
        list.addLast(9);
        list.addLast(10);
        list.getTail();
        
        list.delFirst();
        System.out.println("Header node After calling delFirst()");
        list.getHeader();
        
        list.delLast();
        System.out.println("Tail node After calling delLast");
        list.getTail();
        
        list.traverse();
        list.searching(5);
    }
    
}
