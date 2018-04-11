import java.util.Random;

/**
    Author: Sean Toman
    Date:   10/03/2018
    Desc:   A class to implement the selection sort algorithm
 */

public class SelectionSort extends Sort {

    public SelectionSort() {
        super();
    }

    @Override
    public int[] sort(int[] toSort) {
        for(int i = 0; i < toSort.length-1; i++) {
            // the first element in the array is set to smallest
            int smallest = i;
            incWrites();
            for(int j = i+1; j < toSort.length; j++) {
                incChecks();
                //if current element is smaller than smallest, that element is then assigned to smallest
                if(toSort[j] < toSort[smallest]) {
                    smallest = j;
                    incWrites();
                }
            }

            //swaps the two values
            int temp = toSort[i];
            toSort[i] = toSort[smallest];
            toSort[smallest] = temp;
            incWrites(3);
            incSwaps();
        }
        return toSort;
    }

    public static void main(String[] args) {
        SelectionSort sortTest = new SelectionSort();
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
