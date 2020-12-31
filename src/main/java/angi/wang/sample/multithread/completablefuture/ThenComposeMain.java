package angi.wang.sample.multithread.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 *
 */
public class ThenComposeMain {
    static Logger logger = LoggerFactory.getLogger(ThenComposeMain.class);

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            logger.info("supplyAsync");
            return "abc";
        }, Executors.newCachedThreadPool()).thenComposeAsync(string -> {
            logger.info("thenComposeAsync");
            String a = "aaaa-" + string;
            return CompletableFuture.supplyAsync(() -> {
                logger.info("supplyAsync");
                String b = "bbbb-" + a;
                return b;
            });
        }).thenAcceptAsync(logger::info);
        logger.info("main over!");
    }
}
