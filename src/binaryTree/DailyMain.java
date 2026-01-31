package binaryTree;

public class DailyMain {
    int scrolledHours = 0;

    public void myMonday(){
        System.out.println("I just woke up");
        System.out.println("Scrolling tiktok...");
        System.out.println("Meet Aajaan Weena");
    }

    public void morningRoutine(){
        System.out.println("I just woke up");
        System.out.println("Scrolling tiktok...");

        morningRoutine();
        System.out.println("Meet Aajaan Weena");
    }

    public void smartRoutine() {
        System.out.println("Scrolling tiktok... (Hour " + (scrolledHours + 1) + ")");
        scrolledHours++;

        if (scrolledHours == 3) {
            System.out.println("Finally stopping! Now I go meet Aajaan Weena.");
            return;
        }

        smartRoutine();
    }

    static void main() {
        DailyMain myDay = new DailyMain();
        System.out.println("\n\nMY MONDAY:");
        myDay.myMonday();

        System.out.println("\n\nMORNING ROUTINE:");
//        myDay.morningRoutine();

        System.out.println("\n\nSMART ROUTINE:");
        System.out.println("Just woke up now");
        System.out.println( "I will stop scrolling after 3 hours.");
//        myDay.smartRoutine();


    }
}
