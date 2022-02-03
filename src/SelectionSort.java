/* -------------------------------------------------------
 Jun Simons
 June 2021
 SelectionSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] arr, boolean[] colors, DrawSort util) {
        while(true) {
            for(int start=0; start<arr.length-1; start++) {
                int min_index = start;
                for (int i = start+1; i < arr.length; i++) { //get min number in range
                    if(arr[i] < arr[min_index]) min_index= i;
                }
                //swap occurs here
                int temp = arr[min_index];
                arr[min_index] = arr[start];
                arr[start] = temp;
                Arrays.fill(colors, false);
                colors[min_index] = true;
                colors[start] = true;
                util.repaint();
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
            }
            boolean ordered = true;
            for(int i=0; i<arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    ordered = false;
                    break;
                }
            }
            if (ordered) break;
        }
    }

}

