/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   Tester class to test the efficiency of four algorithms.
 *          The user can select the size of the array, order of elements and sorting algorithm to use
 */

import java.util.Scanner;

public class AlgorithmsAnalysis {

    public static void main(String[] args) {
        // Algorithm classes
        BubbleSort bubble = new BubbleSort();
        InsertionSort insertion = new InsertionSort();
        SelectionSort selection = new SelectionSort();

        // Stopwatch class and array class
        Array array = new Array();
        StopWatch timer = new StopWatch();

        // arrays to hold random, sorted and inversely sorted elements
        int[] randomElements, sortedElements, invertedElements;
        int sizeOption, algorithmOption, elementOption;
        long randomTime, sortedTime, invertedTime;

        elementOption = elementMenu();
        sizeOption = sizeMenu();

        switch(elementOption) {
            case 1:
                if(sizeOption == 1)
                    randomElements = array.createRandom(Array.SMALL);
                else if(sizeOption == 2)
                    randomElements = array.createRandom(Array.MEDIUM);
                else if(sizeOption == 3)
                    randomElements = array.createRandom(Array.LARGE);
                break;

            case 2:
                if(sizeOption == 1)
                    sortedElements = array.createSorted(Array.SMALL);
                else if(sizeOption == 2)
                    sortedElements = array.createSorted(Array.MEDIUM);
                else if(sizeOption == 3)
                    sortedElements = array.createSorted(Array.LARGE);
                break;

            case 3:
                if(sizeOption == 1)
                    invertedElements = array.createInverted(Array.SMALL);
                else if(sizeOption == 2)
                    invertedElements = array.createInverted(Array.MEDIUM);
                else if(sizeOption == 3)
                    invertedElements = array.createInverted(Array.LARGE);
                break;
        }

        algorithmOption = algorithmMenu();

        timer.start();
        switch(algorithmOption) {
            case 1:
                /* TODO : Standard bubblesort option */
                break;

            case 2:
                /* TODO : enhanced bubble sort option */
                break;

            case 3:
                /* TODO : Selection Sort option */
                break;

            case 4:
                /* TODO : Insertion Sort option */
                break;
        }
    }

    /**
     * Method to display a menu and allow the user to select the size of the array
     * @return - option the user selected
     */
    public static int sizeMenu() {
        Scanner keyIn = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. 1,000 elements");
            System.out.println("2. 10,000 elements");
            System.out.println("3. 100,000 elements");
            System.out.print("Please select the size of the array: ");
            option = keyIn.nextInt();

            if(option != 1 && option != 2 && option != 3)
                System.out.println("ERROR!! Please select a number from the menu [1, 2, or 3]");
        } while(option != 1 && option != 2 && option != 3);
        return option;
    }

    /**
     * Displays a menu to allow the user to select the algorithm to use
     * @return - option selected by the user
     */
    public static int algorithmMenu() {
        Scanner keyIn = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Standard Bubble Sort");
            System.out.println("2. Enhanced Bubble Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Insertion Sort");
            System.out.println("Please select the algorithm to sort the array: ");
            option = keyIn.nextInt();

            if(option != 1 && option != 2 && option != 3 && option != 4)
                System.out.println("ERROR!! Please select an option from the menu [1, 2, 3, or 4]");
        } while(option != 1 && option != 2 && option != 3 && option != 4);
        return option;
    }

    /**
     * Displays a menu to allow the user to select the order of elements in the array
     * @return - option selected by the user
     */
    public static int elementMenu() {
        Scanner keyIn = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Random Elements");
            System.out.println("2. Sorted Elements");
            System.out.println("3. Inversely Sorted Elements");
            System.out.print("Please select the order of the array: ");
            option = keyIn.nextInt();

            if(option != 1 && option != 2 && option != 3)
                System.out.println("ERROR!! Please select an option from the menu [1, 2, or 3]");
        } while(option != 1 && option != 2 && option != 3);
        return option;
    }
}
