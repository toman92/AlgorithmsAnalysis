import java.util.Random;

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
                    incWrites(3);
                }
            }
        }
        return toSort;
    }

    public static void main(String[] args) {
        BubbleSort bubbleTest = new BubbleSort();
        Random noGen = new Random();

        int[] myArray = new int[100];
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = noGen.nextInt(100);
        }
        bubbleTest.sort(myArray);
        System.out.println("Checks: " + bubbleTest.getChecks());
        System.out.println("Swaps: " + bubbleTest.getSwaps());
        System.out.println("Writes: " + bubbleTest.getWrites());
    }
}
