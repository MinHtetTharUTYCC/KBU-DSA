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
        System.out.println("\n\nMy Monday:");
        myDay.myMonday();

        System.out.println("\n\nMorning Routines:");
        myDay.morningRoutine();

        System.out.println("\n\nSmart Routines:");
        myDay.smartRoutine();


    }
}
