import java.util.Random;

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
            incChecks();
            int next = toSort[i];
            // find the insertion location while moving all larger elements up
            int j = i;
            while(j > 0 && toSort[j-1] > next) {
                //incChecks();
                toSort[j] = toSort[j-1];
                incWrites();
                j--;
            }
            // insert the next element
            toSort[j] = next;
            incWrites();
            incSwaps();
        }
        return toSort;
    }

    public static void main(String[] args) {
        InsertionSort sortTest = new InsertionSort();
        Random noGen = new Random();

        int[] myArray = new int[100];
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = noGen.nextInt(100);
        }

        sortTest.sort(myArray);
        System.out.println("Checks: " + sortTest.getChecks());
        System.out.println("Swaps: " + sortTest.getSwaps());
        System.out.println("Writes: " + sortTest.getWrites());
    }
}
