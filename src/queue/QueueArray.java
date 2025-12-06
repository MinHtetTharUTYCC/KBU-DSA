package queue;

public class QueueArray {
    private int size;
    private int[] queArr;
    private int front;
    private int rear;

    public QueueArray(int size) {
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

        rear++;
        queArr[rear] = data;
        if(front == -1){  //update front if it's empty queue
            front = 0;
        }

        System.out.println("Enqueued: " + queArr[rear]);
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
            front++;
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
        return rear == size-1;
    }
}
