package lab0_ivansangines;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class LAB0_IVANSANGINES {

    static String[] dictionary = new String[72875];

    public static void main(String[] args) throws IOException {
        FileReader tReader = new FileReader("text");
        Scanner inFile = new Scanner(tReader);

        FileReader wReader = new FileReader("words");
        Scanner inDictionary = new Scanner(wReader);

        int dCounter = 0;
        while (inDictionary.hasNext()) {
            dictionary[dCounter] = inDictionary.next();
            dCounter++;
        }
        int count = 1;
        while (inFile.hasNextLine()) {
            String ln = inFile.nextLine();
            System.out.println(count + ": " + ln);
            String[] words = ln.split(" ");
            if (count < 10) {
                System.out.print("   ");
            } else {
                System.out.print("    ");
            }
            for (int c = 0; c < words.length; c++) {
                int letters = words[c].length();
                if (CheckWords(words[c]) == true) {
                    for (int b = 0; b < letters; b++) {
                        System.out.print(" ");
                    }
                } else {
                    for (int i = 0; i < letters; i++) {
                        System.out.print("^");
                    }
                }
                System.out.print(" ");
            }
            System.out.println("");
            count++;
        }

    }

    public static boolean CheckWords(String w) {
        boolean ans = false;
//        int pos = 1;
//        String nword = " ";
//        for (int i = 0; i < w.length(); i++) {
//            if (Character.isLetter(w.charAt(i)) == false) {
//                pos = i;
//            }
//            if (pos == 0) {
//                nword = w.substring(1, w.length() + 1);
//            }
//            if (pos == w.length()) {
//                nword = w.substring(0, w.length() - 1);
//            }
//        }
        String nWord=w.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        for (int c = 0; c < dictionary.length; c++) {
            if (dictionary[c].equalsIgnoreCase(nWord)) {
                ans = true;
            }
        }
        return ans;

    }

}
