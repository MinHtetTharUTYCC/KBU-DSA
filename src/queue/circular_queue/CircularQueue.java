package queue.circular_queue;

public class CircularQueue {
    private int size;
    private int[] queArr;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.size = size;
        queArr = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data){
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if(isEmpty()){
            front = 0;
        }

        rear = (rear + 1) % size;
        queArr[rear] = data;

        System.out.println("Enqueued: "+ queArr[rear]);
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int data = queArr[front];
        if(front == rear){ //if only one item
            front=rear=-1;
        }else{
            front = (front+1)  % size;
        }

        System.out.println("Dequeued: " + data);
        return data;
    }

    public int peek(){
        return queArr[front];
    }
    public int getRear(){
        return queArr[rear];
    }

    public boolean isEmpty(){
        return (front==-1) && (rear==-1);
    }

    public boolean isFull(){
        return front == (rear+1)%size;
    }

    public void getAll(){
        for(int i: queArr){
            System.out.print(i+" ");
        }
    }
}
