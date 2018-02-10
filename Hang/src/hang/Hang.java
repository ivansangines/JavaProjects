package hang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hang {

    static FileReader nReader;
    private static String[] dictionary;
    private static char[] guesses;
    private static char[] arrayWord;
    private static char[] arrayTest;
    private static int length;
    private static String word;
    private static int attempts;
    private static int c;

    public Hang() {
        dictionary = new String[127142];
        length = 0;
        word = "";
        attempts = 0;
        c = 0;
    }

//read words    
    public static void read() throws FileNotFoundException {
        nReader = new FileReader("dictionary.txt");
        Scanner inFile = new Scanner(nReader);
        int c = 0;
        while (inFile.hasNext()) {
            dictionary[c] = inFile.next();
            c++;
        }
    }

    //set length
    public static void setUp() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the word's lenght: ");
        if (in.hasNextInt()) {
            length = in.nextInt();
            findLength(length);
        } else {
            String bad = in.nextLine();
            System.out.println("Wrong input tio. Run the problam again to start over :)");
        }
    }

    //check length
    public static void findLength(int l) {

        int position = 1;
        int a = 0;
//        String word;
        while (position != dictionary.length) {
            word = dictionary[position];
            position++;
            if (word.length() == length) {
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Wrong length! Try again.");
            setUp();
        } else {
            chooseWord();
            game(word);
        }
    }

    //choose word
    public static String chooseWord() {
        Random ran = new Random();
        int index;
        while (word.length() != length) {
            index = ran.nextInt(dictionary.length - 1);
            word = dictionary[index].toUpperCase();
        }
        return word;
    }

    public static void game(String w) {
        attempts();
        arrayWord = new char[w.length()];
        arrayTest = new char[w.length()];
        for (int b = 0; b < w.length(); b++) {
            arrayTest[b] = '-';
        }
        for (int i = 0; i < w.length(); i++) {
            arrayWord[i] = w.charAt(i);
        }
        Scanner guess = new Scanner(System.in);
        while ((c < attempts)&&(!Arrays.equals(arrayWord, arrayTest))) {
            System.out.print("\nYour guess is: ");
            String letter = guess.next().toUpperCase();
            char l = letter.charAt(0);
            for (int a = 0; a < arrayWord.length; a++) {
                if (arrayWord[a] == l) {
                    arrayTest[a] = l;
                }
            }
            guesses[c] = l;
            c++;
            System.out.println("\nYou have guessed: " + Arrays.toString(guesses));
            
            System.out.println("You have " + (attempts - c) + " guess(es) left.");
            System.out.print("Word: ");
            for(int i=0; i<arrayTest.length;i++){
                System.out.print(arrayTest[i]);
            }
            System.out.println("");
        }
        again();

    }

    public static void attempts() {
        
        System.out.print("How many attemps? ");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            attempts = input.nextInt();
            guesses = new char[attempts];
        } else {
            String badIn = input.nextLine();
            System.out.println("Wrong input tio.");
        }
    }

    public static void again() {
        if (Arrays.equals(arrayWord,arrayTest))
            System.out.println("\nYou have won!!");
        else
            System.out.println("\nYou have lost");
        
        System.out.println("Do you want to play again?\n(0) play again\n(1) quit\n\nChoose a move (0-1): ");
        Scanner a = new Scanner(System.in);
        if (a.hasNextInt()) {
            int answer = a.nextInt();
            if (answer > 1) {
                System.out.println("Wrong input tio");
                again();
            } else {
                if (answer == 0) {
                    c=0;
                    setUp();
                }
                if (answer == 1) {
                    System.out.println("Thanks for playing");
                    System.exit(1);
                }
            }
        } else {
            String bad = a.nextLine();
            System.out.println("Wrong input tio");

            again();
        }
    }
}
