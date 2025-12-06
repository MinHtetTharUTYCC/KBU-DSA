package stack;

public class StackArray {
    private int size;
    private int[] stackArr;
    private int top;

    public StackArray(int size) {
        this.size = size;
        stackArr = new int[size];
        top = -1;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Stack Full");
        }else{
            top++;
            stackArr[top] = data;
            System.out.println("Pushed Data : " + stackArr[top]);
        }

    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        } else {
            int data = stackArr[top];
            top--;
            System.out.println("Pop Data : " + data);
            return stackArr[top];
        }
    }

    public int getTop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            System.out.println("The element at the top: "+ stackArr[top]);
            return stackArr[top];
        }
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == size-1;
    }

    public static void main(String[] args) {
        System.out.println("STACK ARRAY");
        StackArray stack = new StackArray(5);

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
