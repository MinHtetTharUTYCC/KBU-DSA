package doublelk;

public class MyNode {
    private  int iData;
    private MyNode next;
    private MyNode prev;

    public MyNode(int iData) {
        this.iData = iData;
        next = null;
        prev = null;
    }

    public int getIData() {
        return iData;
    }
    public void setIData(int iData) {
        this.iData = iData;
    }

    public MyNode getNext() {
        return next;
    }
    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getPrev() {
        return prev;
    }
    public void setPrev(MyNode prev) {
        this.prev = prev;
    }
}
