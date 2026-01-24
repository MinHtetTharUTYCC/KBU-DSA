package queue.circular_queue;

public class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(3);
        queue.enqueue(8);
        queue.dequeue();
        queue.getAll();
        queue.enqueue(12);
        queue.dequeue();
        queue.enqueue(7);
        queue.dequeue();


        System.out.println();
        queue.enqueue(1111);
        queue.getAll();

        System.out.println();
        queue.enqueue(2222);
        queue.getAll();

        System.out.println();
        queue.enqueue(3333);
        queue.getAll();




    }
}
