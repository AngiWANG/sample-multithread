package angi.wang.sample.multithread.joinfork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

/**
 * 基于ForkJoin实现求和
 *
 * @author angi
 */
public class ForkJoinSum
        extends RecursiveTask<Integer> {
    static Logger logger = LoggerFactory.getLogger(ForkJoinSum.class);
    private final int start;
    private final int end;
    private final static int THRESHOLD = 5;

    public ForkJoinSum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if ((end - start) < THRESHOLD) {
            for (int x = start; x < end; x++) {
                result += x;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinSum
                    leftCalculator = new ForkJoinSum(start, middle);
            ForkJoinSum
                    rightCalculator =
                    new ForkJoinSum(middle, end);
            leftCalculator.fork();
            rightCalculator.fork();
            result
                    +=
                    (leftCalculator.join() +
                            rightCalculator.join());
        }
        logger.info("result: " + result);
        return result;
    }
}
