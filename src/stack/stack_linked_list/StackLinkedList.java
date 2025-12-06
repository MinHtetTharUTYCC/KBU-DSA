package stack.stack_linked_list;


public class StackLinkedList {
    private Node top;

    public StackLinkedList(){}

    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            top = newNode;
        }else {
            newNode.setNext(top);
            top = newNode;
        }
        System.out.println("Pushing: " + top.getData());
    }

    public Node pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }

        System.out.println("Popping: " + top.getData());
        top = top.getNext();
        return top;
    }
    public  Node getTop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        System.out.println("The node on the top: "+ top.getData());
        return top;
    }

    private boolean isEmpty() {
        return top == null;
    }

    static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println();
        stack.pop();

        System.out.println();
        stack.getTop();
    }

}
