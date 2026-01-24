package midterm;

import java.util.Stack;

public class First {
    static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        int[] values = {1,3,5,7,9,11,13,15,17,19};
        for (int value : values) {
            s.push(value);
        }

        int n= 25;
        for(int i=0;i<4;i++){
            n+= s.pop();
        }

        for(int i=0;i<2;i++){
            n-= s.pop();
        }

        System.out.println(n);
    }
}
