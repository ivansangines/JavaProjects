/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byte_sangines;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Byte_Sangines {

   
    public static void main(String[] args) throws IOException {
        FileReader myRead = new FileReader("binary.txt");
        Scanner input = new Scanner(myRead);
        while (input.hasNext()) {
            String num1 = input.next();
            String num2 = input.next();
            ByteClass byte1 = new ByteClass(num1.toCharArray());
            ByteClass byte2 = new ByteClass (num2.toCharArray());
            boolean underflow;
            boolean overflow;

//          First number
            if (num1.charAt(0) == '1') {
                byte1 = byte1.to2sComplement();
            }
            int mag1 = byte1.magnitude();

//          Secon number
            byte2.biasTo2sComplement();
            if(num2.charAt(0)=='0'){
                byte2=byte2.to2sComplement();
            }
            int mag2 = byte2.magnitude();
            
//          Bynari Sum
            ByteClass sumByte = byte1.add(byte2);

            if (num1.charAt(0) == '1') {
                mag1 = (-mag1);
            }
            if (num2.charAt(0) == '0') {
                mag2 = (-mag2);
            }
//          Decimal sum
            int decimalSum = mag1 + mag2;
                
            if((decimalSum)<-128){
                underflow=true;
            }else{
                underflow=false;
            }if((decimalSum)>127){
                overflow=true;
                
            }else{
                overflow=false;
            }
            
            System.out.println("  "+num1+ "\t"+"2's complement "+"\t"+"\t"+mag1);
            System.out.println("+ "+num2+ "\t"+"Biased Notation"+"\t"+"     +  "+mag2);
            System.out.println("------------"+"\t"+"\t"+"\t"+"\t"+"----");
            if(underflow){
                System.out.println("  Underflow"+"\t"+"\t"+"\t"+"\t"+decimalSum);
              
            }else if(overflow){
                System.out.println("  Overflow"+"\t"+"\t"+"\t"+"\t"+decimalSum);
            }else{
                System.out.println("  "+sumByte+"\t"+"\t"+"\t"+"\t"+decimalSum);
            }
            System.out.println("");
            
        }

    }

}
