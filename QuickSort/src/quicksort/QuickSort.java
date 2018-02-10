
package quicksort;


public class QuickSort {

    public static void main(String[] args) {
      SortClass s = new SortClass();
        int[] array = {5,54,12,66,77,88,91,16,97};
        //int[] array = {5,54};
        
        System.out.print("The original array is: [ ");
        for(int n:array){
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println("");
        s.sort(array);
        System.out.print("The QuickSort result is: [ ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println("");
    }
    
}
