/* -------------------------------------------------------
 Jun Simons
 June 2021
 QuickSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import java.util.Arrays;

public class QuickSort {
    public void sort (int[] arr, boolean[] colors, DrawSort util) {
        sortStep(arr,0,arr.length-1,util, colors);
    }

    public void sortStep(int[] arr, int s, int e, DrawSort util, boolean[] colors) {
        /* -- Recursive method for quicksort, divides itself and then calls itself twice -- */
        if (s < e) {
            //first get partition and sort around partition
            int pi = partition(arr, s, e, util, colors);
            //then call sortstep on bottom half and top half
            sortStep(arr, s, pi - 1, util, colors);
            sortStep(arr, pi + 1, e, util, colors);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int partition(int[] arr, int s, int e, DrawSort util, boolean[] colors){ //get partition for divide and conquer
        int r = (s - 1);
        int ind = arr[e];
        //loop through and move to correct order around partition
        for(int j = s; j <= e - 1; j++){
            if (arr[j] < ind) {
                r++;
                swap(arr, r, j);
                Arrays.fill(colors, false);
                colors[r] = true;
                colors[j] = true;
                util.repaint();
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
            }
        }
        swap(arr, r+1, e);
        Arrays.fill(colors, false);
        colors[r+1] = true;
        colors[e] = true;
        util.repaint();
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {
        }
        return 1+r;
    }


}
