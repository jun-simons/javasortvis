/* -------------------------------------------------------
 Jun Simons
 June 2021
 BubbleSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] arr, boolean[] colors, DrawSort util) {
        boolean sorted = false;
        //this loops until the array is sorted
        while(true) {
            //if ordered is still true after looping through, the array is done sorting
            boolean ordered = true;
            //swap successive elements in the array if they are out of order
            for(int i=0; i<arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {
                    ordered = false;
                    int temp= arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    Arrays.fill(colors, false);
                    colors[i] = true;
                    colors[i+1] = true;
                    util.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (Exception ignored) {
                    }
                }
            }
            if (ordered) break;
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
