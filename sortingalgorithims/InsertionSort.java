/* -------------------------------------------------------
 Jun Simons
 June 2021
 InsertionSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] arr, boolean[] colors, DrawSort util) {
        for (int i=1; i<arr.length; i++) { //for every element in the array
            int div = arr[i];
            int ind = i-1;
            //move everything greater than the div one position forward
            while(ind >= 0 && arr[ind]>div) {
                arr[ind+1] = arr[ind--];
                Arrays.fill(colors, false);
                colors[div] = true;
                colors[ind+1] = true;
                util.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception ignored) {
                }
            }
            //move div to correct spot ("insert" it)
            arr[ind+1] = div;
            Arrays.fill(colors, false);
            colors[div] = true;
            colors[ind+1] = true;
            util.repaint();
            try {
                Thread.sleep(2);
            } catch (Exception ignored) {
            }
        }
    }
}
