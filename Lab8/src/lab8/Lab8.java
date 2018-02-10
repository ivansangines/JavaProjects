package lab8;

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Lab8 {

    static double average;

    public static void main(String[] args) throws FileNotFoundException {
        String name = "";
        String ssn = "";
        double grade1;
        double grade2;
        double grade3;
        double grade4;

        try {
            FileReader nReader = new FileReader("inFile.txt");
            Scanner input = new Scanner(nReader);
            PrintWriter write = new PrintWriter("output.txt");
            System.out.println("Name        SSNumber    Average    Grade   Distinction  Range");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner in = new Scanner(line);
                name = in.next();
                ssn = in.next();
                grade1 = in.nextDouble();
                grade2 = in.nextDouble();
                grade3 = in.nextDouble();
                grade4 = in.nextDouble();

                char[] names = new char[10];
                char[] ssnumber = new char[9];
                for (int i = 0; i < name.length(); i++) {
                    names[i] = name.charAt(i);
                }
                for (int i = name.length(); i < names.length; i++) {
                    names[i] =' ';
                }
                for (int i = 0; i < ssn.length(); i++) {
                    ssnumber[i] = ssn.charAt(i);
                }
                for (int i = ssn.length(); i < ssnumber.length; i++) {
                    ssnumber[i] =' ';
                }
                System.out.print(names);
                write.print(names);
                System.out.print("  ");
                write.print("  ");
                System.out.print(ssnumber);
                write.print(ssnumber);
                average=Average(grade1,grade2,grade3,grade4);
                DecimalFormat df=new DecimalFormat("0.0");
                System.out.print("   "+df.format(average)+"\t    ");
                write.print("   "+df.format(average)+"\t    ");
                System.out.print(LetterGrade(average)+"      ");
                write.print(LetterGrade(average)+"      ");
                System.out.print(Distinction(grade1,grade2,grade3,grade4)+"\t");
                write.print(Distinction(grade1,grade2,grade3,grade4)+"\t");
                write.print(Range(grade1,grade2,grade3,grade4));
                
            }
            write.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    public static double Average(double grd1,double grd2,double grd3,double grd4){
        double aver=(((grd1+grd2+grd3)*0.2)+(+grd4*0.4));
        return aver;
    }
    
    public static String LetterGrade(double av){
        if(av<=60)
            return("F \t");
        else if(av<=67)
            return("D \t");
        else if(av<=70)
            return("D+ \t");
        else if(av<=73)
            return("C- \t");
        else if(av<=77)
            return("C \t");
        else if(av<=80)
            return("C+ \t");
        else if(av<=83)
            return("B- \t");
        else if(av<=87)
            return("B \t");
        else if(av<=90)
            return("B+ \t");
        else if(av<=93)
            return("A- \t");
        else
            return("A \t");
        
    }
    
    public static String Distinction(double g1,double g2,double g3,double g4){
        if(average<90 && (g1<85 || g2<85 || g3<85 || g4<85))
            return "NO";
        else
            return "YES";
        
    }
    
    public static double Range(double g1,double g2,double g3,double g4){

        double max1=Math.max(g1, g2);
        double max2=Math.max(g3, g4);
        double max=Math.max(max1, max2);
        double min1=Math.min(g1, g2);
        double min2=Math.min(g3, g4);
        double min=Math.min(min1, min2);
        double range=max-min;
        DecimalFormat df=new DecimalFormat("0.00");
        System.out.println(df.format(range));
        return range;
        
    }
    

}
