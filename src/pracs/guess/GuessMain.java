package pracs.guess;

import java.util.Scanner;

public class GuessMain {
    public static void main(String[] args) {
        int ranNum = (int) (Math.random() * 100 + 1);
        System.out.println("Guessing " + ranNum);

        int guessCount = 0;

        while(guessCount < 5){
            System.out.println("Enter Your Guess: ");
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt();

            if(value == ranNum){
                System.out.println("Congratulations! You guessed correctly!");
                break;
            }else if(value > ranNum){
                System.out.println("Your guessed number is greater than random number");
            }else{
                System.out.println("Your guessed number is less than random number");
            }

            if(guessCount == 4){
                System.out.println("YOU LOST!!");
                break;
            }
            guessCount++;

        }
    }
}
