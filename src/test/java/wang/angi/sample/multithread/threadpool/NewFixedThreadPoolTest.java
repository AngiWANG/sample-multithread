package wang.angi.sample.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		int i = 0;
		while (i < 5) {
			executorService.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(10 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(".................");
				}
			});
			i++;
		}
	}

}
