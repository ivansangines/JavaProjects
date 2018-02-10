package lab1_sangines;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab1_Sangines {

    static ArrayList<String> myArray = new ArrayList<String>();
    private static Game[] down = new Game[4];
    private static Game[] cross = new Game[4];
    private static String[][] matrix = new String[13][13];
    private static int globalCounter = 0;
    private static int counter;

    public static void main(String[] args) throws FileNotFoundException {
        readStore();
        readDicionary();
        llenarMatrix();
        printMatix();
        menu();

    }

    public static void readDicionary() throws FileNotFoundException {
        FileReader dReader = new FileReader("words.txt");
        Scanner inDictionary = new Scanner(dReader);

        while (inDictionary.hasNext()) {
            myArray.add(inDictionary.next());
        }
    }

    public static void getHelp(int l) {

        for (int i = 0; i < myArray.size(); i++) {
            if (myArray.get(i).length() == l) {
                System.out.println(myArray.get(i));
            }
        }
    }

    public static void readStore() throws FileNotFoundException {
        int counterDown = 0;
        int counterAcross = 0;
        FileReader aRead = new FileReader("clues.txt");
        Scanner inClues = new Scanner(aRead);
        while (inClues.hasNext()) {
            String word = inClues.next();
            String pos = inClues.next();
            String direction = inClues.next();
            String clue = inClues.nextLine();
            int col = Integer.parseInt(pos.substring(1));
            if (direction.equalsIgnoreCase("a")) {
                cross[counterAcross] = new Game(word, pos.charAt(0), col, direction.charAt(0), clue, globalCounter);
                counterAcross++;
            } else {
                down[counterDown] = new Game(word, pos.charAt(0), col, direction.charAt(0), clue, globalCounter);
                counterDown++;
            }
            globalCounter++;
        }
        counter=globalCounter;
    }

    public static void llenarMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = (" ");
                } else {
                    if (i == 0 && j > 0) {
                        matrix[i][j] = "" + (j - 1);
                    } else {
                        if (j == 0 && i > 0) {
                            matrix[i][j] = "" + (char) (i + 96);
                        } else {
                            matrix[i][j] = "*";
                        }
                    }
                }

            }
        }
        for (int j = 0; j < cross.length; j++) {
            String word = cross[j].getWord();
            int column = cross[j].getiPos();
            char row = cross[j].getyPos();

            for (int i = 0; i < word.length(); i++) {
                matrix[(int) row - 96][column + 1] = "" + (char) 169;
                column++;
            }
        }
        for (int k = 0; k < down.length; k++) {
            String word = down[k].getWord();
            int column = down[k].getiPos();
            char row = down[k].getyPos();

            for (int i = 0; i < word.length(); i++) {
                matrix[(int) row - 96][column + 1] = "" + (char) 169;
                row++;
            }
        }
    }

    public static void printMatix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Across:");
        System.out.println("\t Row \t Column \t Clue");
        for (int i = 0; i < cross.length; i++) {
            System.out.println(cross[i].getPos() + ".\t  " + cross[i].getyPos() + "\t  " + cross[i].getiPos() + "\t\t" + cross[i].getClue());
        }
        System.out.println("Down:");
        System.out.println("\t Row \t Column \t Clue");
        for (int i = 0; i < down.length; i++) {
            System.out.println(down[i].getPos() + ".\t  " + down[i].getyPos() + "\t  " + down[i].getiPos() + "\t\t" + down[i].getClue());
        }
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please choose the number of the word to guess or x to exit: ");
        String answer = in.next();
        if (Character.isLetter(answer.charAt(0))) {
            if (answer.charAt(0) == 'c') {
                System.out.println("Enter the word length: ");
                int wLength = in.nextInt();
                System.out.println("Possible words are: ");
                getHelp(wLength);
                menu();
            }
            if (answer.charAt(0) == 'x') {
                System.exit(0);
            } else {
                System.out.println("Wrong input tio!");
                menu();
            }
        } else {
            int ans = Integer.parseInt(answer);
            if (ans >= 0 && ans <= globalCounter) {
                Game array = find(ans);
                String palabra = array.getWord();
                System.out.print("What is your guess? ");
                String guess = in.next();
                if (palabra.equalsIgnoreCase(guess)) {
                    System.out.println("Nicee Tio!");
                    counter--;
                    if (array.getDirection() == 'a') {
                        int c = array.getiPos();
                        for (int i = 0; i < guess.length();i++) {
                            String letter=""+guess.charAt(i);
                            matrix[(int) array.getyPos() - 96][c + 1]=letter;
                            c++;
                        }
                        printMatix();
                        if(counter!=0){
                        menu();
                        }else{
                            System.out.println("You won the game! Good job tio!!");
                            System.exit(1);
                        }
                    }else{
                        if (array.getDirection() == 'd') {
                        int c = array.getyPos();
                        for (int i = 0; i < guess.length();i++) {
                            String letter=""+guess.charAt(i);
                            matrix[c - 96][array.getiPos() + 1]=letter;
                            c++;
                        }
                        printMatix();
                        if(counter!=0){
                        menu();
                        }else{
                            System.out.println("You won the game! Good job tio!!");
                            System.exit(1);
                        }
                    }
                    }
                        
                } else {
                    System.out.println("Meeeeeec that is wrong!");
                    menu();
                }
            } else {
                System.out.println("wrong input tio!");
                menu();
            }
        }

    }

    public static Game find(int a) {
        Game value = null;
        for (int i = 0; i < cross.length; i++) {
            if (a == cross[i].getPos()) {
                value = cross[i];
            }
        }
        for (int i = 0; i < cross.length; i++) {
            if (a == down[i].getPos()) {
                value = down[i];
            }
        }
        return value;
    }
}
