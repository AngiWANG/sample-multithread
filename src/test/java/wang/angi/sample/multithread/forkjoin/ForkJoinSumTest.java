package wang.angi.sample.multithread.forkjoin;

import angi.wang.sample.multithread.joinfork.ForkJoinSum;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSumTest {

    @Test
    public void testForkJoinSum(){
        ForkJoinSum forkJoinSum = new ForkJoinSum(0,30);
        ForkJoinPool pool = new ForkJoinPool();
        Integer sum = pool.invoke(forkJoinSum);
        System.out.println(sum);
    }
}
