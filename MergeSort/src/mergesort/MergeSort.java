package mergesort;

import java.io.IOException;

public class MergeSort {

    public static void main(String[] args) throws IOException {
        SimpleMergeSort sms = new SimpleMergeSort(1024); // 128K of int values
        
        
        long startTime = System.nanoTime();
        sms.mergesort();
        long endTime = System.nanoTime();
        
        long totalNanos = endTime - startTime;
        long minutes = totalNanos / 1000000000 / 60;
        totalNanos -= minutes * 60000000000L;
        long seconds = (int) (totalNanos / 1000000000.0);
        totalNanos -= seconds * 1000000000L;
        long milliSeconds = (int) (totalNanos / 1000000.0);
        System.out.println(sms.getRunInfo());
        System.out.printf("%nTime merge: %02d:%02d:%03d %n%n", minutes, seconds, milliSeconds);
        System.out.println("MergeSort Complete!/n");

        RadixSort rad = new RadixSort();
        long startTimeRad = System.nanoTime();

        rad.Sort();

        long endTimeRad = System.nanoTime();

        long totalNanosRad = endTimeRad - startTimeRad;
        long minutesRad = totalNanosRad / 1000000000 / 60;
        totalNanosRad -= minutesRad * 60000000000L;
        long secondsRad = (int) (totalNanosRad / 1000000000.0);
        totalNanosRad -= secondsRad * 1000000000L;
        long milliSecondsRad = (int) (totalNanosRad / 1000000.0);

        
        rad.printData();
        System.out.println(rad.getRunInfo());
        System.out.printf("%nTime: %02d:%02d:%03d %n%n", minutesRad, secondsRad, milliSecondsRad);
        System.out.println("Radix Sort Complete!");
    }

}
