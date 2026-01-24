package pracs.files;

import java.io.File;
import java.util.Scanner;

public class FilesMain {
    public static void main(String[] args) throws Exception {
        File file = new File("new file.txt");
        Scanner sc = new Scanner(file);

        int words = 0;
        while(sc.hasNextLine()){
            words += sc.nextLine().split((" ")).length;
        }
        System.out.println("Number of words: " + words);
    }
}
