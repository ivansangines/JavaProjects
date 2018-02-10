/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Calculator {

    private static int counter = 1;
    private static char myArray[] = new char[counter];

    public static void main(String[] args) throws PostFix {
        reader();
       
    }

    public static void reader()throws PostFix {
        Scanner in = new Scanner(System.in);
        System.out.println("Chose the name of one of the possible files:\n- Tio\n- Operations");
        String name = in.next();

        try {
            FileReader reader = new FileReader(name);
            Scanner inFile = new Scanner(reader);
            System.out.println("The program does exist\n");
            while(inFile.hasNextLine()){
                String line=inFile.nextLine();
                Tools tool = new Tools();
                String resultado = tool.infixToPostTIO(line);
                System.out.println("resultado= " + resultado);
                int a=tool.getResult(resultado);
                System.out.println("final= " + tool.getResult(resultado)+"\n");
            }
            
        } catch (FileNotFoundException err) {

            System.err.println("Sorry, this file does not exist.");
        }
        
    }

}

