package wang.angi.sample.multithread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolExecutorTest {
	@Test
	public void test1() throws Throwable {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 30, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2));
		int i = 0;
		System.out.print("please enter a int: ");
		int max = 5;
		while (i < max) {
			threadPoolExecutor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(100 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(".................");
				}
			});
			i++;
			Thread.sleep(5 * 1000);
		}
	}
}
