package wang.angi.sample.multithread.forkjoin;

import angi.wang.sample.multithread.joinfork.ForkJoinQuickSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinQuickSortTest {
    private static final int LEN = 10;

    private List<Integer> prepareForData() {
        Random random = new Random(System.currentTimeMillis());
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            data.add(random.nextInt(20));
        }
        return data;
    }

    private void print(String literal, List<Integer> data) {
        System.out.println(literal);
        for (int element : data) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        List<Integer> data = prepareForData();
        print("####before", data);
        ForkJoinQuickSort<Integer> quickSort = new ForkJoinQuickSort<>(data);
        // ForkJoin线程池
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);
        print("####after", data);
    }
}
