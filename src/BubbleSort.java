/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   A child class of Sort, to implement the standard and enhanced bubble sort algorithms
 */

public class BubbleSort extends Sort {

    public BubbleSort() {
        super();
    }

    @Override
    public int[] sort(int[] toSort) {
        for(int i = 0; i < toSort.length-1; i++) {
            for(int j = 0; j < toSort.length-1; j++) {
                incChecks();
                if(toSort[j] > toSort[j+1]) {
                    int temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                    incSwaps();
                }
            }
        }
        return toSort;
    }

    /**
     * Main method to test BuubleSort class
     * @param args
     */
    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
        Array myArray = new Array();
        StopWatch timer = new StopWatch();

        int[] smallRandom = myArray.getSortedArray(Array.LARGE);


        //myArray.printArray(smallRandom);

        //System.out.println();
        timer.start();
        smallRandom = bubble.sort(smallRandom);
        timer.stop();
        System.out.println("Time in nano secs: " + timer.getElapsedTime());
        System.out.println();

        //myArray.printArray(smallRandom);
        System.out.println("Checks: " + bubble.getChecks());
        System.out.println("Swaps: " + bubble.getSwaps());
    }
}
