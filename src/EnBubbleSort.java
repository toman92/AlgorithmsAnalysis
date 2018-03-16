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
                    isSorted = false;
                    incSwaps();
                }
            }
        }
        return toSort;
    }
}
