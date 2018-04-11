import java.util.Random;

/**
 *  Author: Sean Toman
 *  Date:   18/03/2018
 *  Desc:   A child class of Sort, class to represent the enhanced bubble sort algorithms
 */
public class EnBubbleSort extends Sort {

    public EnBubbleSort() {
        super();
    }

    @Override
    public int[] sort(int[] toSort) {
        boolean isSorted = false;
        for(int i = 0; i < toSort.length-1 && !isSorted; i++) {
            isSorted = true;
            for(int j = 0; j < toSort.length-1-i; j++) {
                incChecks();
                if(toSort[j] > toSort[j+1]) {
                    int temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                    incSwaps();
                    incWrites(3);
                    isSorted = false;
                }
            }
        }
        return toSort;
    }

    public static void main(String[] args) {
        EnBubbleSort sortTest = new EnBubbleSort();
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
