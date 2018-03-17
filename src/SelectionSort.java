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
            for(int j = i+1; j < toSort.length; j++) {
                incChecks();
                //if current element is smaller than smallest, that element is then assigned to smallest
                if(toSort[j] < toSort[smallest]) {
                    smallest = j;
                }
            }

            //swaps the two values
            int temp = toSort[i];
            toSort[i] = toSort[smallest];
            toSort[smallest] = temp;
            incSwaps();
        }
        return toSort;
    }
}
