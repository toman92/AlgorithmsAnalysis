/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   A class to help create and populate int arrays of different sizes
 */

import java.util.Random;

public class Array {

    public static final int SMALL = 1000;
    public static final int MEDIUM = 10000;
    public static final int LARGE = 100000;

    /**
        Populates array with random number ranging from 0 to size of array
        @param size - int size array should be. Use class finals
        @return array populated with random elements
     */
    public int[] getRandomArray(int size) {
        Random noGen = new Random();
        int[] toPop = new int[size];
        for(int i = 0; i < toPop.length; i++) {
            toPop[i] = noGen.nextInt(toPop.length);
        }
        return toPop;
    }

    /**
        Populates array with sorted elements
        @param size - int size array should be. Use class finals
        @return array populated with sorted elements
     */
    public int[] getSortedArray(int size) {
        int[] toPop = new int[size];
        for(int i = 0; i < toPop.length; i++) {
            toPop[i] = i+1;
        }
        return toPop;
    }

    /**
        Populates array with inversely sorted elements
        @param size - int size the array should be. Use class finals
        @return array populated with inversely sorted elements
     */
    public int[] getInvertedArray(int size) {
        int[] toPop = new int[size];
        for(int i = 0, j = toPop.length; i < toPop.length; i++, j--) {
            toPop[i] = j;
        }
        return toPop;
    }

    /**
        prints array
        @param toPrint array to print
     */
    public void printArray(int[] toPrint) {
        for(int i = 0; i < toPrint.length; i++) {
            System.out.print(toPrint[i] + " ");
        }
    }
}
