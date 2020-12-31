package angi.wang.sample.multithread.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 *
 */
public class ThenCombineMain {
    static Logger logger = LoggerFactory.getLogger(ThenCombineMain.class);

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            logger.info("supplyAsync");
            return "abc";
        }, Executors.newCachedThreadPool()).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
            logger.info("supplyAsync");
            return "cde";
        }), (string1, string2) -> {
            logger.info("thenComposeAsync");
            String a = string1 + "-aaaa-" + string2;
            return a;

        }).thenAcceptAsync(logger::info);
        logger.info("main over!");
    }
}
