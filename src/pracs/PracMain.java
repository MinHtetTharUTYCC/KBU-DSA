package pracs;

public class PracMain {
    public String reverseString(String str){
        String newString = "";

        for(int i= str.length() -1;i<=0;i--){
            newString += str.charAt(i);
            System.out.println(i);
        }
        System.out.println(newString);
        return newString;
    }

    static void main(String[] args) {
        PracMain prac = new PracMain();
        System.out.println(prac.reverseString("Hilo"));
    }
}
