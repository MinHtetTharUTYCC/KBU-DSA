package queue;

public class Main {

    public static void printDetails(QueueArray q){
        System.out.println();
        System.out.println("Front pointer is pointing to: " + q.peek());
        System.out.println("Rear pointer is pointing to: " + q.getRear());
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        printDetails(queue);
        System.out.println("IS FULL:"+queue.isFull());

        queue.dequeue();
        printDetails(queue);

        System.out.println("IS FULL:"+queue.isFull());


    }

}
