package mergesort;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RadixSort {

    private int size;
    private int MaxPass;
    private RandomAccessFile F, A, B;
    private StringBuffer runInfo;
    private String maxBinary = " ";

    public RadixSort() throws IOException {           //default
        this(1024);

    }

    public RadixSort(int size) throws IOException {
        this.size = size;
        runInfo = new StringBuffer(2048);
        createFiles();
        F.seek(0L); //Pointer top of the file.

        MaxPass = F.readInt();

        int value;

        for (int i = 1; i < size; i++) {

            value = F.readInt();

            if (value > MaxPass) {            //We will find the biggest number in the file
                MaxPass = value;
            }
        }
        maxBinary = Integer.toBinaryString(MaxPass) + "";              //converting the biggest number to binary
        runInfo.append("MaxPass = " + maxBinary.length() + "\n\n");   //maxpass is length of the binary number of the biggest number

    }

    private void createFiles() throws IOException {

        Random rand = new Random();
        F = new RandomAccessFile("F.bin", "rw");
        A = new RandomAccessFile("A.bin", "rw");
        B = new RandomAccessFile("B.bin", "rw");

        for (int i = 0; i < size; i++) {
            F.writeInt(rand.nextInt(100));              //number from 0-99 
        }
        for (int i = 0; i < size; i++) {       // A and B will have same size of the file (do not know how many numbers will be in A or B)
            A.writeInt(0);
            B.writeInt(0);
        }

    }

    public void Sort() throws IOException {
        for (int i = maxBinary.length(); i > 0; i--) {                      // sort for maxpass times
            SplitFile(i - 1);
        }
    }

    public void SplitFile(int i) throws IOException {
        int countA = 0, countB = 0;           //count of remaining elements in A and B
        A.seek(0L);
        B.seek(0L);            //move pointer to the top.
        F.seek(0L);

        for (int a = 0; a < size; a++) {

            String num = Integer.toBinaryString(F.readInt()) + "";   //reading the number from the file
            for (int j = num.length(); j < maxBinary.length(); j++) {      //adding 0s to the front, to make sure all numbers have the same length
                num = "0" + num;
            } //for
            if (num.charAt(i)=='0') {                       //comparing bit by bit
                A.writeInt(Integer.parseInt(num, 2));      //numbers with 0 in file A
                countA++;                                 //counting numbers in A
            } else {
                B.writeInt(Integer.parseInt(num, 2));      //numbers with 1 in file B
                countB++;                                   //counting number in B
            }
        }//for
        F.seek(0L);
        A.seek(0L);                  //move pointer to the top before reading again.
        B.seek(0L);
        for (int j = 0; j < countA; j++) {        //write all numbers from file A to F
            F.writeInt(A.readInt());
        }
        for (int j = 0; j < countB; j++) {        //write all numbers from file B to F
            F.writeInt(B.readInt());
        }
    }

    public String getRunInfo() {
        return runInfo.toString();                //return the stringbuffer

    }

    public void printData() throws IOException {

        F.seek(0L);
        for (int i = 0; i < size; i++) {          //print all data in the file F
            System.out.println("" + F.readInt());
        }
    }
}
