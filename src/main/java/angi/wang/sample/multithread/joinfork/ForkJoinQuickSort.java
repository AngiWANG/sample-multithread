package angi.wang.sample.multithread.joinfork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * 基于ForkJoin实现快速排序
 *
 * @param <T>
 * @author angi
 */
public class ForkJoinQuickSort<T extends Comparable> extends RecursiveAction {

    static Logger logger = LoggerFactory.getLogger(ForkJoinQuickSort.class);

    /**
     * 待排序的数据
     */
    private List<T> data;
    /**
     * 开始索引
     */
    private int left;
    /**
     * 结束索引
     */
    private int right;

    public ForkJoinQuickSort(List<T> data) {
        this.data = data;
        this.left = 0;
        this.right = data.size() - 1;
    }

    public ForkJoinQuickSort(List<T> data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            // 取中间索引
            int pivotIndex = left + ((right - left) / 2);
            logger.info("pivotIndex: " + pivotIndex);
            pivotIndex = partition(pivotIndex);
            // 并行递归
            invokeAll(new ForkJoinQuickSort(data, left, pivotIndex -
                            1),
                    new ForkJoinQuickSort(data, pivotIndex + 1, right));
        }
    }

    /**
     * 一分为二
     *
     * @param pivotIndex
     * @return
     */
    private int partition(int pivotIndex) {
        T pivotValue = data.get(pivotIndex);
        swap(pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (data.get(i).compareTo(pivotValue) < 0) {
                swap(i, storeIndex);
                storeIndex++;
            }
        }
        swap(storeIndex, right);
        return storeIndex;
    }

    /**
     * 交换
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        if (i != j) {
            T iValue = data.get(i);
            data.set(i, data.get(j));
            data.set(j, iValue);
        }
    }
}
