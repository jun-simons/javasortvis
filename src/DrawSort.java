/* -------------------------------------------------------
 Jun Simons
 June 2021
 DrawSort.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
/*
    ----- This is the primary class that handles the graphics as well as calling sorting algorithms
    and shuffling the array.  The array itself as well as the corresponding array of color values are stored here

    -------- HOW IT WORKS --------
    Initially:
    1) Array is instantiated where the value placed inside the array is equal to the index of the array
    2) Array is shuffled using shuffle() initially, but visualizeShuffle() creates cool graphics after the sort is finished
    3) The GUI is drawn by drawing rectangles and using an arbitrary scale for height, converting array values to different height bars

    When the user picks a sorting algorithm:
    1) The DrawSort class has methods for each algorithim, which then call the corresponding class to do the sorting
    2) The array of numbers is passed to the class, as well as an array of booleans for color, and this object passes itself to the sorting classes
    3) While sorting, when swaps are made, the redraw() method is called at each step before Thread.sleep, so the user can see each step
    4) The boolean[] color array stores color data. If false, the rectangle is painted the primary bar color, which in this case is blue.
    If the color array stores true, the rectangle at that index will be painted the accent bar color, which in this case is salmon red.
    This means that whatever index is being actively swapped can be painted red just by setting the array at that index to True
    5) When sorting is finished, the animateColor() method makes the whole thing satisfyingly turn the accent color
 */

public class DrawSort extends JPanel {
    private int[] arr;
    private boolean[] color;

    /* --- CONFIGURATION ---*/
    public static final int WIDTH = 1400;
    public static final int HEIGHT = 800;
    private static final int BARSIZE = 5;
    private static final int MAX = WIDTH/BARSIZE;

    /* COLORS */
    Color primaryBarColor = new Color(48,78,200);
    Color accentBarColor = new Color(222, 73, 73);
    Color backgroundColor = Color.lightGray;

    //Constructor, initializes arrays
    public DrawSort() {
        arr = new int[MAX];
        color = new boolean[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = i;
        }
        shuffle();
        setBackground(backgroundColor);
    }

    //Sort methods
    public void quickSort() {
        new QuickSort().sort(arr,color, this);
        animateColor();
    }
    public void selectionSort() {
        new SelectionSort().sort(arr, color, this);
        animateColor();
    }
    public void bubbleSort() {
        new BubbleSort().sort(arr, color, this);
        animateColor();
    }
    public void insertionSort() {
        new InsertionSort().sort(arr, color, this);
        animateColor();
    }
    public void mergeSort() {
        new MergeSort().sort(arr, color, this);
        animateColor();
    }

    //Animation from left to right where the rectangles change color -- played after sorting is finished
    public void animateColor() {
        Arrays.fill(color, false);
        for (int i=0; i<arr.length; i++) {
            color[i] = true;
            repaint();
            try {
                Thread.sleep(3);
            } catch (Exception ignored) {
            }
        }
    }
    //shuffles array randomly
    public void shuffle() {
        for (int i=0; i<MAX; i++) {
            int ind = (int) (Math.random()*MAX);
            int temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
        }
    }
    //does the same thing as the method above, except
    //shows the sorting process step by step
    public void visualizeShuffle() {
        Arrays.fill(color, false);
        for (int i=0; i<MAX; i++) {
            int ind = (int) (Math.random()*MAX);
            int temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
        }
    }

    //Loops through array and draws the bars
    //Also looks at the color array of booleans to check what color each bar should be
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);
        graphics.setColor(primaryBarColor);

        for (int i = 0; i < MAX; i++) {
            int h = arr[i]*3; //arbitrary scaling factor for GUI bars
            int x = i+(BARSIZE-1)*i;
            int y = HEIGHT-h;
            if(color[i])  {
                graphics.setColor(accentBarColor);
                graphics.fillRect(x,y,BARSIZE,h);
                graphics.setColor(primaryBarColor);
            } else {
                graphics.fillRect(x,y,BARSIZE,h);
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
