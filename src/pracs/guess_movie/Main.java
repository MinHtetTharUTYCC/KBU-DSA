package pracs.guess_movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args){


        List<String> movieList = new ArrayList<>();

        try{
            File file = new File("movies.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                String movie = sc.nextLine().trim();
                if(!movie.isEmpty()){
                    movieList.add(movie);
                }
            }
            sc.close();

        }catch (FileNotFoundException e){
            System.out.println("Movies file not found");
            return;
        }

        if (movieList.isEmpty()) {
            System.out.println("No movies found in the file.");
            return;
        }

        System.out.println("Total movies read: " + movieList.size());
        Collections.shuffle(movieList);

        Movie movieToGuess = new Movie(movieList.getFirst());
        String guessedResult = movieToGuess.getHiddenName();
        StringBuilder wrongLetters = new StringBuilder();

        int wrongCount = 0;
        final int MAX_WRONG = 10;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("=== Guess the Movie ===");
            System.out.println("NAME: "+ movieToGuess.getName());
            System.out.println("Movie to guess: "+ guessedResult);
            System.out.println("You can make " + MAX_WRONG + " wrong guesses.\n");

            while (wrongCount < MAX_WRONG){
                System.out.println("Current: "+ guessedResult);
                System.out.println("Wrong letters ("+ wrongCount+"): " + (!wrongLetters.isEmpty() ? wrongLetters : "None"));

                System.out.println("Guess a letter (or 'quit' to exit): ");
                String input = sc.nextLine().trim().toLowerCase();

                if(input.equals("quit")){
                    System.out.println("Game ended. The movie was: " + movieToGuess.getName());
                }

                if(input.length() != 1 && !Character.isLetter(input.charAt(0))){
                    System.out.println("Invalid input. Please enter a single letter.");
                    continue;
                }

                char guessedChar = input.charAt(0);

                if(guessedResult.indexOf(guessedChar) != -1 || wrongLetters.indexOf(String.valueOf(guessedChar)) != -1){
                    System.out.println("You already guessed '"+ guessedChar + "'!");
                    continue;
                }

                String newGuess = movieToGuess.makeTheGuess(guessedResult,guessedChar);

                if(newGuess == null){
                    wrongLetters.append(guessedChar).append(" ");
                    wrongCount++;
                    System.out.println("Wrong! " + (MAX_WRONG - wrongCount) + " remaining...");
                }else{
                    guessedResult = newGuess;
                    System.out.println("Good guess");

                    if(movieToGuess.isComplete(guessedResult)){
                        System.out.println("Congratulations! You guessed the movie.");
                        System.out.println("The movie was: " + movieToGuess.getName());
                        System.out.println("You made "+ wrongCount + " wrong guesses.");
                        return;
                    }
                }

                if(wrongCount >= MAX_WRONG){
                    System.out.println("\nGame over! You've used all your guesses.");
                    System.out.println("The movie was: " + movieToGuess.getName());
                }
            }
        }
    }
}