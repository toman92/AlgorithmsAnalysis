/**
 *  Author: Sean Toman
 *  Date:   10/03/2018
 *  Desc:   A StopWatch class to help time the efficiency of algorithms
 */

public class StopWatch {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;

    /**
        Constructs a stopwatch that is in the stopped state
        and has no time accumulated
     */
    public StopWatch() {
        reset();
    }

    /**
        Starts the stopwatch. Time starts accumulating now
     */
    public void start() {
        if(isRunning) {
            return;
        }

        this.isRunning = true;
        this.startTime = System.nanoTime();
    }

    /**
        Stops the stopwatch. Time stops accumulating and is
        added to the elapsed time
     */
    public void stop() {
        if(!isRunning) {
            return;
        }

        this.isRunning= false;
        long endTime = System.nanoTime();
        this.elapsedTime = endTime - this.startTime;
    }

    /**
     * returns the elapsed time in nanoseconds
     * @return - elapsed time between start and end time
     */
    public long getElapsedTime() {
        if(isRunning) {
            long endTime = System.nanoTime();
            this.elapsedTime = endTime - this.startTime;
            return this.elapsedTime;
        }
        else {
            return this.elapsedTime;
        }
    }

    /**
        Stops the stopwatch and resets the elapsed time to 0
     */
    public void reset() {
        this.elapsedTime = 0;
        this.isRunning = false;
    }
}
