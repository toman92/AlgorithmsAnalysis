/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   A child class of Sort, to implement the insertion sort algorithm
 */

public class InsertionSort extends Sort {

    public InsertionSort() {
        super();
    }

    @Override
    public int[] sort(int[] toSort) {
        for(int i = 1; i < toSort.length; i++) {
            int next = toSort[i];
            // find the insertion location while moving all larger elements up
            int j = i;
            while(j > 0 && toSort[j-1] > next) {
                toSort[j] = toSort[j-1];
                incSwaps();
                incChecks();
                j--;
            }
            // insert the next element
            toSort[j] = next;
            incSwaps();
        }
        return toSort;
    }

    public static void main(String[] args) {
        InsertionSort insert = new InsertionSort();
        Array myArray = new Array();
        StopWatch timer = new StopWatch();

        int[] smallRandom = myArray.getRandomArray(Array.SMALL);
        int[] smallSorted = myArray.getSortedArray(Array.SMALL);
        int[] smallInvert = myArray.getInvertedArray(Array.SMALL);

        timer.start();
        insert.sort(smallRandom);
        timer.stop();
        System.out.println("Time in nano seconds to sort random: " + timer.getElapsedTime());
        System.out.println("Checks: " + insert.getChecks());
        System.out.println("Swaps: " + insert.getSwaps());

        timer.reset();
    }
}
