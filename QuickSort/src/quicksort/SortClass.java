package quicksort;

import java.util.ArrayList;
import java.util.Iterator;

public class SortClass {

    private int array[];
    private int down[];
    private int up[];
    private int size;
//    ArrayList lower = new ArrayList();
//    ArrayList higher = new ArrayList();

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        this.array = arr;
        split(arr);
        size = arr.length;
        quickSort(up,0, up.length - 1);
        quickSort(down,0, down.length - 1);
        concat(down,up);
    }
    
    private int[] concat(int [] first, int [] second){
        int length1= first.length;
        int length2= second.length;
        int [] temp= new int[length1+length2];
        System.arraycopy(first, 0, temp, 0, length1);
        System.arraycopy(second, 0, temp, length1, length2);
        System.arraycopy(temp, 0, array, 0, size);
//        for (int i=0; i<temp.length; i++)
//        this.array[i]=temp;
        return array;
    }
    
    private void split(int[] a){
        int counter = 0;

        int p = a[((a.length)/2)]; //Set pivot as the middle value
        ArrayList left = new ArrayList();
        ArrayList right = new ArrayList();

        while (counter < a.length) { //loop the whole array

            if (a[counter] < p) { //split in lowers than p
                left.add(a[counter]);
                counter++;
            }
            else if (a[counter] > p) { //split highers than p
                right.add(a[counter]);
                counter++;
            }else{  //we found pivot
                counter++;
            }
        }
        right.add(p); //we add pivot to right
        down = copy(left);
        up = copy(right);
    }
    private int[] copy(ArrayList myList) {
        int[] cop = new int[myList.size()];
        Iterator<Integer> it = myList.iterator();
        int i = 0;
        while (it.hasNext()) {

            cop[i] = it.next();
            i++;
        }
        return cop;
    }

    private void quickSort(int[] myArr, int low, int high) {
        
        if( myArr.length<=1){ //in case the middle point is the highest one or the lowest one, then the array would be empty.
            return;
        }
        else {
        int a = low;
        int b = high;
        int pivot = myArr[low + (high - low) / 2]; //Set pivot as the middle value

        while (a <= b) {

            while (myArr[a] < pivot) {
//                lower.add(myArr[a]);
                a++;
            }
            while (myArr[b] > pivot) {
//                higher.add(myArr[b]);
                b--;
            }
            if (a <= b) {
                move(myArr,a, b);
                a++;
                b--;
            }
        }
        if (low < b) {
            quickSort(myArr,low, b);
        }
        if (a < high) {
            quickSort(myArr,a, high);
        }
    }
    }

    private void move(int[] list,int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
