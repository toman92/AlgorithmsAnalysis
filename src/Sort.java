/**
    Author: Sean Toman
    Date:   10/03/2018
    Desc:   An abstract parent class for sorting algorithms
 */

public abstract class Sort {

    private int checks;
    private int swaps;

    /**
     * Constructor initialises checks and swaps to 0
     */
    public Sort() {
        this.checks = 0;
        this.swaps = 0;
    }

    /**
     * return the current number of checks that have occurred
     * @return
     */
    public int getChecks() {
        return this.checks;
    }

    /**
     * return the current number of swaps that have occurred
     * @return - number of swaps
     */
    public int getSwaps() {
        return this.swaps;
    }

    /**
     * increment checks by one
     */
    public void incChecks() {
        this.checks++;
    }

    /**
     * Increment swaps by one
     */
    public void incSwaps() {
        this.swaps++;
    }

    /**
     * Increments swaps by given amount
     * @param amount - amount to increment swaps
     */
    public void incSwaps(int amount) {
        this.swaps += amount;
    }

    /**
     * Reset counter back to 0
     */
    public void reset() {
        this.swaps = 0;
        this.checks = 0;
    }

    /**
        takes an array in, sort it and returns the sorted array
        To be implemented by child classes
        @param toSort int array to sort
        @return sorted int array
     */
    public abstract int[] sort(int[] toSort);
}
