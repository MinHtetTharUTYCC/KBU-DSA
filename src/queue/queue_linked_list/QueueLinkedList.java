package queue.queue_linked_list;

public class QueueLinkedList {
    private Node front;
    private Node rear;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
        }else{
            Node temp = rear;
            rear.setNext(newNode);
        }
        rear = newNode;
        System.out.println("Enqueue: "+ newNode.getData());

    }

    public Node dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        Node temp = front.getNext();
        Node temp2 = front;

        System.out.println("Dequeue: "+ temp.getData());
        front = temp;
        if(temp2== rear){
            rear=front=null;
        }

        return front;
    }

    public  Node peek(){
        return front;
    }

    public Node getRear(){
        return rear;
    }

    public boolean isEmpty(){
        return front == null && rear == null;
    }
}


