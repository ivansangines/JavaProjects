/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickdriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author ivans_000
 */
public class QuickClass {

   

    

    public QuickClass(int[] array) {

        int a = 0;
        int lower[];
        int higher[];

        int pivot = array[((array.length)/2)]; //Set pivot as the middle value
        ArrayList left = new ArrayList();
        ArrayList right = new ArrayList();

        while (a < array.length) {

            if (array[a] < pivot) {
                left.add(array[a]);
                a++;
            }
            else if (array[a] > pivot) {
                right.add(array[a]);
                a++;
            }else{
                a++;
            }
        }

        lower = copy(left);
        higher = copy(right);
        order(lower);
        order(higher);

        print(lower);
        System.out.print(" ");
        System.out.print(pivot);
        System.out.print(" ");

        print(higher);

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

    public void order(int[] arr) {
        Arrays.sort(arr);
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }

    }

}
