/* -------------------------------------------------------
 Jun Simons
 June 2021
 GUI.java
 SortingAlgorithimVisualizer
 ------------------------------------------------------- */

package com.company;

import javax.swing.*;
import java.util.Scanner;

public class GUI {
    private static DrawSort util;
    private JFrame window;

    public static final int WIDTH = 1400;
    public static final int HEIGHT = 800;

    static Scanner input = new Scanner(System.in);

    //Constructor
    public GUI() { //initialize JFrame GUI
        window = new JFrame("JUN-SORT");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        util = new DrawSort(); //All graphics happen in DrawSort
        window.add(util);
        util.repaint();

        window.pack();
        window.setVisible(true);
    }

    public static void main(String... args) {
        GUI gui = new GUI(); //initiate everything

        //main input loop
        while(true) {
            System.out.println("Which sorting algorithm would you like to see");
            System.out.println("1: Selection Sort\n2: Quick Sort\n3: Bubble Sort\n4: Insertion Sort\n5: Merge Sort\n-1 to exit program");
            switch(input.nextInt()) { //get input and call correct method
                case 1 -> {
                    System.out.println("You chose Selection Sort");
                    util.selectionSort();
                }
                case 2 -> {
                    System.out.println("You chose Quick Sort");
                    util.quickSort();
                }
                case 3 ->{
                    System.out.println("You chose Bubble Sort");
                    util.bubbleSort();
                }
                case 4 -> {
                    System.out.println("You chose Insertion Sort");
                    util.insertionSort();
                }
                case 5 -> {
                    System.out.println("You chose Merge Sort");
                    util.mergeSort();
                }
                case -1 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid response, please try again");
                }
            }
            System.out.println("The array is now sorted");
            System.out.println("Enter any key to shuffle the array and continue: ");
            input.next();
            //shuffle and repaint with cool shuffling graphics :)
            if (input.hasNextLine()) util.visualizeShuffle();
            util.repaint();
        }
    }

}
