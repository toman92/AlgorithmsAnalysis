/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   A class to help create and populate int arrays of different sizes
 */

import java.util.Random;

public class Array {

    // Finals for 3 available size of array
    public static final int SMALL = 1000;
    public static final int MEDIUM = 10000;
    public static final int LARGE = 100000;

    // int arrays to store original contents of arrays so algorithms are working on same data
    private int[] randomOriginal;
    private int[] sortedOriginal;
    private int[] invertedOriginal;

    // number generator
    private Random noGen;

    public Array() {
        noGen = new Random();
    }

    /**
        Creates an array of given size with random elements ranging 0-999
        Stores this array to preserve original contents so algorithms are working on same data
        @param size - int size array should be. Use class finals
        @return array populated with random elements
     */
    public int[] createRandom(int size) {
        //Random noGen = new Random();
        int[] toPop = new int[size];
        this.randomOriginal = new int[size];
        for(int i = 0; i < toPop.length; i++) {
            toPop[i] = noGen.nextInt(1000);
        }
        System.arraycopy(toPop, 0, this.randomOriginal, 0, toPop.length);
        return toPop;
    }

    /**
        Creates an array of given size populated with sorted elements
        Stores this array to preserve original contents so algorithms are working on same data
        @param size - int size array should be. Use class finals
        @return array populated with sorted elements
     */
    public int[] createSorted(int size) {
        int[] toPop = new int[size];
        this.sortedOriginal = new int[size];
        for(int i = 0; i < toPop.length; i++) {
            toPop[i] = i+1;
        }
        System.arraycopy(toPop, 0, this.sortedOriginal, 0, toPop.length);
        return toPop;
    }

    /**
        Creates an array of given size with inversely sorted elements
        Makes a copy of the array to be stored to preserve original
        @param size - int size the array should be. Use class finals
        @return array populated with inversely sorted elements
     */
    public int[] createInverted(int size) {
        int[] toPop = new int[size];
        this.invertedOriginal = new int[size];
        for(int i = 0, j = toPop.length; i < toPop.length; i++, j--) {
            toPop[i] = j;
        }
        System.arraycopy(toPop, 0, this.invertedOriginal, 0, toPop.length);
        return toPop;
    }

    /**
     * Returns a copy of the original random array so original is preserved for later reference
     * @return - copy of original random array
     */
    public int[] getRandomOriginal() {
        int[] copy = new int[this.randomOriginal.length];
        System.arraycopy(this.randomOriginal, 0, copy, 0, this.randomOriginal.length);
        return copy;
    }

    /**
     * Returns a copy of the original sorted array so the original is preserved for later reference
     * @return - copy of original sorted array
     */
    public int[] getSortedOriginal() {
        int[] copy = new int[this.sortedOriginal.length];
        System.arraycopy(this.sortedOriginal, 0, copy, 0, this.sortedOriginal.length);
        return copy;
    }

    /**
     * Returns a copy of the original inversely sorted array so original is preserved for later reference
     * @return - copy of original inversely sorted array
     */
    public int[] getInvertedOriginal() {
        int[] copy = new int[this.invertedOriginal.length];
        System.arraycopy(this.invertedOriginal, 0, copy, 0, this.invertedOriginal.length);
        return copy;
    }

    /**
        prints array contents. For testing
        @param toPrint array to print
     */
    public void printArray(int[] toPrint) {
        for(int i : toPrint) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Tester method for Array class
     * @param args
     */
    public static void main(String[] args) {
        Array test = new Array();
        int[] random = test.createRandom(20);
        test.printArray(random);
        test.printArray(test.getRandomOriginal());
        EnBubbleSort sortTest = new EnBubbleSort();
        sortTest.sort(random);
        //int[] randomOrig = test.getRandomOriginal();
        sortTest.sort(test.getRandomOriginal());
        System.out.println();
        test.printArray(random);
        //test.printArray(randomOrig);
        test.printArray(test.getRandomOriginal());
    }
}
