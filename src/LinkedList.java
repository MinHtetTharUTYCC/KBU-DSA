public class LinkedList {
    public Node header;

    public LinkedList(){
        header = null;
    }
    public  void addFirst(int data){
        Node newNode = new Node(data);
        if(header == null){
            header = newNode;
        }else{
            newNode.setNext(header);
            header=newNode;
        }
    }
    public  void addLast(){

    }
    public  void addAnyPos(){

    }

    public  static void main(String[] args){
        System.out.println("LINKED LIST DEMO");

    }
}
