package angi.wang.sample.multithread.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 *
 */
public class ComplatableFutureMain {
    static Logger logger = LoggerFactory.getLogger(ComplatableFutureMain.class);

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            logger.info("step1 begin");
//            try {
//                Thread.sleep(10 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            logger.info("step1 end");
            logger.info("isDaemon: "+Thread.currentThread().isDaemon());
            return "abc";
        }).thenApplyAsync(s -> {
            logger.info("thenApplyAsync");
            return s + "-cde";
        }).thenApply(s -> {
            logger.info("thenApply");
            return s + "-def";
        }).thenAcceptAsync(s -> logger.info(s));
        logger.info("main over!");
    }
}
