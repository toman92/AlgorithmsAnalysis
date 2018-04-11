/**
    Author: Sean Toman
    Date:   10/03/2018
    Desc:   An abstract parent class for sorting algorithms
 */

public abstract class Sort {

    private long checks;
    private long swaps;
    private long writes;

    /**
     * Constructor initialises checks and swaps to 0
     */
    public Sort() {
        this.checks = 0;
        this.swaps = 0;
        this.writes = 0;
    }

    /**
     * return the current number of checks that have occurred
     * @return - number of checks
     */
    public long getChecks() {
        return this.checks;
    }

    /**
     * return the current number of swaps that have occurred
     * @return - number of swaps
     */
    public long getSwaps() {
        return this.swaps;
    }

    /**
     * return the current number of writes that have occurred
     * @return - number of writes to memory
     */
    public long getWrites() {
        return this.writes;
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
    public void incSwaps(long amount) {
        this.swaps += amount;
    }

    /**
     * Increments writes to memory by one
     */
    public void incWrites() {
        this.writes++;
    }

    /**
     * Increments writes to memory by given amount
     * @param amount - amount to increment writes by
     */
    public void incWrites(long amount) {
        this.writes += amount;
    }

    /**
     * Reset swaps and checks back to 0
     */
    public void reset() {
        this.swaps = 0;
        this.checks = 0;
        this.writes = 0;
    }

    /**
        takes an array in, sort it and returns the sorted array
        To be implemented by child classes
        @param toSort - int array to sort
        @return - sorted int array
     */
    public abstract int[] sort(int[] toSort);
}
