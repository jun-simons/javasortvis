/* -------------------------------------------------------
 Jun Simons
 June 2021
 MergeSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr, boolean[] colors, DrawSort util) {
        sortStep(arr, 0, arr.length - 1, colors, util);
    }

    //merges two array sections together
    void merge(int[] arr, int s, int m, int e, boolean[] colors, DrawSort util) {
        //calculate sizes and make arrays
        int leftSize = 1+(m-s);
        int rightSize = e-m;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        //copy array into left and right array
        //these arrays are temporary
        for (int i = 0; i < leftSize; i++) left[i] = arr[i+s];
        for (int j = 0; j < rightSize; j++) right[j] = arr[1+j+m];

        //loop through both the right and left array
        //the lowest number gets added back into the main array first
        //everything gets merged in order
        int l = 0, r = 0;
        int ind = s;
        while (l < leftSize && r < rightSize) {
            if (left[l] <= right[r]) { //if left is less, get from left first
                arr[ind] = left[l++];
            }
            else { //otherwise if right is less, get from right first
                arr[ind] = right[r++];
            }
            //update graphics every time we do this
            Arrays.fill(colors, false);
            colors[ind] = true;
            util.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
            //move to next array index and repeat
            ind++;
        }

        //copy leftovers from either array, and update graphics
        while (l < leftSize) {
            arr[ind] = left[l++];
            Arrays.fill(colors, false);
            colors[ind] = true;
            util.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
            ind++;
        }
        while (r < rightSize) {
            arr[ind] = right[r++];
            Arrays.fill(colors, false);
            colors[ind] = true;
            util.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
            ind++;
        }
    }

    //recursive sortStep method
    void sortStep(int[] arr, int s, int e, boolean[] colors, DrawSort util) {
        if (s < e) {
            //calculate our pivot point
            int midpoint = (e-s)/2 + s;
            //Sort each half recursively and merge them together
            sortStep(arr, s, midpoint, colors, util);
            sortStep(arr, midpoint+1, e, colors, util);
            merge(arr, s, midpoint, e, colors, util);
        }
    }

}
