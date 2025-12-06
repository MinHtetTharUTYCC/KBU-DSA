package stack.realstack;

import java.util.Stack;

public class RealStack {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();

        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");
        stack.push("fifth");

        System.out.println("TOP:: " + stack.peek());

        System.out.println();
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }



    }
}
