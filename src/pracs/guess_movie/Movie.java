package pracs.guess_movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String name;
    private final String hiddenName;

    public Movie(String name) {
        this.name = name.trim().toLowerCase();
        this.hiddenName = createHiddenName();
    }

    private String createHiddenName(){
        StringBuilder hidden = new StringBuilder();
        for(char c: name.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                hidden.append('_');
            }else if(c == ' '){
                hidden.append(' ');
            }else {
                hidden.append(c); //keep punctuation
            }
        }

        return  hidden.toString();
    }

    public boolean checkIsMatched(String guessedResult){
        return guessedResult.equals(name);
    }

    public String makeTheGuess(String currentGuessed, char c){
        char lowerChar = Character.toLowerCase(c);

        if(name.indexOf(lowerChar) == -1){
            return null;
        }
        char[] newGuess = currentGuessed.toCharArray();
        boolean changed = false;

        for(int i=0;i<name.length();i++){
            if(name.charAt(i)==lowerChar && newGuess[i] == '_'){
                newGuess[i] = name.charAt(i);
                changed = true;
            }
        }

        return changed ? new String(newGuess) : null;

    }

    public String getHiddenName(){
        return hiddenName;
    }

    public  String getName() {
        return name;
    }

    public boolean isComplete(String currentGuess){
        return !currentGuess.contains("_");
    }
}
