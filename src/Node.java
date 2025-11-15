public class Node {
    private int iData;
    private Node next;

    public Node(int iData) {
        this.iData = iData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;

    }

    public int getData() {
        return iData;
    }

    public void setData(int iData) {
        this.iData = iData;
    }
}