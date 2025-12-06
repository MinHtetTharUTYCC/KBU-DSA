package queue.queue_linked_list;

public class QueueLinkedList {
    private Node front;
    private Node rear;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    public void enqueue(int data){

    }

    public Node dequeue(){
        return null;
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


