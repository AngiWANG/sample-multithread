package angi.wang.sample.multithread.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class ComplatableFutureVoidMain {
    static Logger logger = LoggerFactory.getLogger(ComplatableFutureVoidMain.class);
    public static void main(String[] args) {
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            logger.info("step1 begin");
//            try {
//                Thread.sleep(10 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            logger.info("step1 end");
        });

        completableFuture.thenRun(() -> {
//            try {
//                Thread.sleep(10*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            logger.info("step2");});
        logger.info("main over!");
    }
}
